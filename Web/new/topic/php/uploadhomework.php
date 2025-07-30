<?php
session_start();

// 定義常數，便於管理和修改
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', '');
define('DB_NAME', 'topic');
define('UPLOAD_BASE_DIR', __DIR__ . '/../data/');
define('JAVA_CLASS_PATH', 'C:\\xampp\\htdocs\\topic\\java');
define('PYTHON_PATH', 'C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python311\\python.exe');
define('GEMINI_SCRIPT_PATH', 'C:\\xampp\\htdocs\\topic\\py\\Gemini.py');
define('MISTRAL_SCRIPT_PATH', 'C:\\xampp\\htdocs\\topic\\py\\Mistral.py');

// 統一的錯誤處理和重定向函數
function redirectToUploadPage($errorMessage) {
    $_SESSION['error'] = $errorMessage;
    header("Location: ../uploadhomework.php");
    exit();
}

// 確保請求方法是 POST
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    redirectToUploadPage("無效的請求方法！");
}

// 獲取傳遞過來的參數
$questionID = $_POST['Question_id'] ?? null;
$file = $_FILES['file'] ?? null;

// 檢查必要參數是否存在
if (!$questionID || !$file || $file['error'] !== UPLOAD_ERR_OK) {
    redirectToUploadPage("缺少必要的上傳參數或檔案上傳錯誤！錯誤代碼: " . ($file['error'] ?? '未知'));
}

// 從 Session 獲取使用者 ID 和作業 ID
$userid = $_SESSION['UserID'] ?? null;
$homeworkID = $_SESSION['selected_homework_id'] ?? null;

if (!$userid || !$homeworkID) {
    redirectToUploadPage("Session 資訊遺失，請重新登入或選擇作業！");
}

// 連接到資料庫
$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

// 檢查資料庫連接是否成功
if ($conn->connect_error) {
    redirectToUploadPage("資料庫連接失敗: " . $conn->connect_error);
}

// --- 查詢作業列表以獲取 ClassID (使用預處理語句) ---
$stmt = $conn->prepare("SELECT ClassID FROM homeworkslist WHERE HomeworkID = ?");
if (!$stmt) {
    redirectToUploadPage("準備查詢作業資訊失敗: " . $conn->error);
}
$stmt->bind_param("s", $homeworkID);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows === 0) {
    $stmt->close();
    $conn->close();
    redirectToUploadPage("找不到對應的作業資訊！");
}
$row = $result->fetch_assoc();
$classID = $row['ClassID'];
$stmt->close();

// 定義學生作業的上傳目錄路徑
$uploadDir = UPLOAD_BASE_DIR . "$classID/$homeworkID/homework/$userid/Q$questionID/";

// 檢查並建立上傳目錄
if (!is_dir($uploadDir)) {
    if (!mkdir($uploadDir, 0777, true)) {
        $conn->close();
        redirectToUploadPage("無法建立上傳目錄！");
    }
}

// 清空該題資料夾中的所有舊檔案，避免干擾新的批改
$filesInDir = glob($uploadDir . '*');
foreach ($filesInDir as $fileToDelete) {
    if (is_file($fileToDelete)) {
        unlink($fileToDelete); // 刪除檔案
    }
}

// 獲取上傳的檔案名稱並組合成目標路徑
$filename = basename($file['name']);
$target = $uploadDir . $filename;

// 移動上傳的檔案到目標目錄
if (!move_uploaded_file($file['tmp_name'], $target)) {
    $conn->close();
    redirectToUploadPage("檔案上傳失敗！請檢查檔案權限或大小。");
}

// --- 呼叫 Java 程式進行自動批改 ---

// Java 執行檔路徑 (確保 'java' 在系統 PATH 中)
$javaExecutable = "java";
// 要執行的 Java 類別名稱
$mainClass = "main_once_v1";

// 測資路徑假設為: data/{ClassID}/{HomeworkID}/tester/Q{QuestionID}/
$testerDir = UPLOAD_BASE_DIR . "$classID/$homeworkID/tester/Q" . $questionID;

// 組裝傳遞給 Java 程式的參數 (確保使用 escapeshellarg 避免命令注入問題)
$homeworkDirArg = escapeshellarg($uploadDir);
$studentFileNameArg = escapeshellarg($filename);
$testerDirArg = escapeshellarg($testerDir);
$classIDArg = escapeshellarg($classID);
$homeworkIDArg = escapeshellarg($homeworkID);
$userIDArg = escapeshellarg($userid);
$questionIDArg = escapeshellarg($questionID);
$filenameArg = escapeshellarg($filename);

// 構建完整的 Java 執行命令
$javaCmd = "\"$javaExecutable\" -cp \"" . JAVA_CLASS_PATH . "\" \"$mainClass\" $homeworkDirArg $studentFileNameArg $testerDirArg $classIDArg $homeworkIDArg";

// 執行 Java 程式並捕獲所有輸出 (包括標準輸出和標準錯誤)
$javaOutput = shell_exec($javaCmd . " 2>&1");
$javaResult = trim($javaOutput); // 去除首尾空白，獲取 Java 程式的最終輸出 ('1' 或 '0' 等)

// 判斷 Java 程式的執行結果，並設定相應的訊息
$javaStatusMessage = "";
if ($javaResult === '1') {
    $javaStatusMessage = "自動批改成功！";
} else {
    // 即使失敗，也只是記錄訊息，而不是終止程式
    $javaStatusMessage = "自動批改失敗！請檢查程式碼是否有誤或聯絡管理員。" . PHP_EOL . "詳細錯誤訊息：" . PHP_EOL . $javaOutput;
}
// 可以選擇將此訊息存入 Session 或日誌
$_SESSION['java_auto_grade_status'] = $javaStatusMessage;


// --- 繼續執行 AI 評分 (不論 Java 批改結果如何) ---
$_SESSION['error'] = $javaStatusMessage . " 正在進行 AI 評分！"; // 提示用戶自動批改狀態並開始 AI 評分

// 定義分數關鍵字 (從反饋檔案中提取分數)
$keywords = ["**總分", "總分"];

// --- 執行 Gemini AI 評分 ---
$scoreGemini = null;
$retryCountGemini = 0;
$maxRetries = 3; // 設定最大重試次數

do {
    $cmdGemini = "\"" . PYTHON_PATH . "\" \"" . GEMINI_SCRIPT_PATH . "\" $classIDArg $homeworkIDArg $userIDArg $questionIDArg $filenameArg";
    $outputGemini = shell_exec($cmdGemini . " 2>&1"); // 執行 Python 腳本並捕獲輸出

    // 定義 Gemini 反饋檔案路徑
    $readfeedbackGemini = UPLOAD_BASE_DIR . "$classID/$homeworkID/feedback/$userid/Q" . $questionID . "_Gemini_feedback.txt";

    if (file_exists($readfeedbackGemini)) {
        $contentGemini = file_get_contents($readfeedbackGemini);
        foreach ($keywords as $keywordGemini) {
            if (preg_match("/" . preg_quote($keywordGemini, '/') . ".*?=\s*(\d+)/u", $contentGemini, $matches)) {
                $scoreGemini = $matches[1];
                break;
            } elseif (preg_match("/" . preg_quote($keywordGemini, '/') . "[^\d]*(\d+)/u", $contentGemini, $matches)) {
                $scoreGemini = $matches[1];
                break;
            }
        }
    }
    $retryCountGemini++;
} while ($scoreGemini === null && $retryCountGemini < $maxRetries); // 如果分數為空且未達到最大重試次數，則重試

if ($scoreGemini !== null) {
    // 儲存 Gemini 評分結果到資料庫 (使用預處理語句)
    $stmtGemini = $conn->prepare("INSERT INTO results (HomeworkID, StudentID, Question, Score, LLM) VALUES (?, ?, ?, ?, 0) ON DUPLICATE KEY UPDATE Score = ?");
    if ($stmtGemini) {
        $stmtGemini->bind_param("sssis", $homeworkID, $userid, $questionID, $scoreGemini, $scoreGemini);
        $stmtGemini->execute();
        $stmtGemini->close();
    } else {
        error_log("準備 Gemini 評分插入/更新語句失敗: " . $conn->error);
    }
} else {
    $_SESSION['error'] .= PHP_EOL . "Gemini AI 評分失敗或未取得分數！";
    error_log("Gemini AI 評分失敗，或從檔案中無法提取分數。輸出: " . $outputGemini);
}


// --- 執行 Mistral AI 評分 ---
$scoreMistral = null;
$retryCountMistral = 0;
do {
    $cmdMistral = "\"" . PYTHON_PATH . "\" \"" . MISTRAL_SCRIPT_PATH . "\" $classIDArg $homeworkIDArg $userIDArg $questionIDArg $filenameArg";
    $outputMistral = shell_exec($cmdMistral . " 2>&1");

    $readfeedbackMistral = UPLOAD_BASE_DIR . "$classID/$homeworkID/feedback/$userid/Q" . $questionID . "_Mistral_feedback.txt";

    if (file_exists($readfeedbackMistral)) {
        $contentMistral = file_get_contents($readfeedbackMistral);
        foreach ($keywords as $keywordMistral) {
            if (preg_match("/" . preg_quote($keywordMistral, '/') . ".*?=\s*(\d+)/u", $contentMistral, $matches)) {
                $scoreMistral = $matches[1];
                break;
            } elseif (preg_match("/" . preg_quote($keywordMistral, '/') . "[^\d]*(\d+)/u", $contentMistral, $matches)) {
                $scoreMistral = $matches[1];
                break;
            }
        }
    }
    $retryCountMistral++;
} while ($scoreMistral === null && $retryCountMistral < $maxRetries);

if ($scoreMistral !== null) {
    // 儲存 Mistral 評分結果到資料庫 (使用預處理語句)
    $stmtMistral = $conn->prepare("INSERT INTO results (HomeworkID, StudentID, Question, Score, LLM) VALUES (?, ?, ?, ?, 1) ON DUPLICATE KEY UPDATE Score = ?");
    if ($stmtMistral) {
        $stmtMistral->bind_param("sssis", $homeworkID, $userid, $questionID, $scoreMistral, $scoreMistral);
        $stmtMistral->execute();
        $stmtMistral->close();
    } else {
        error_log("準備 Mistral 評分插入/更新語句失敗: " . $conn->error);
    }
} else {
    $_SESSION['error'] .= PHP_EOL . "Mistral AI 評分失敗或未取得分數！";
    error_log("Mistral AI 評分失敗，或從檔案中無法提取分數。輸出: " . $outputMistral);
}

$_SESSION['error'] = (isset($_SESSION['error']) ? $_SESSION['error'] . PHP_EOL : '') . "繳交流程完成！"; // 最終成功或完成訊息

// 關閉資料庫連接
$conn->close();
// 重定向回上傳頁面
header("Location: ../uploadhomework.php");
exit();
?>