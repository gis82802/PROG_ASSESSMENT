<?php
session_start();

// 檢查是否為 POST 請求，如果不是則導向測資編輯頁面並退出
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    $_SESSION['error'] = "無效的請求方法！";
    header("Location: ../edittester.php");
    exit();
}

// 獲取從表單提交的通用參數
$action = $_POST['action'] ?? '';           // 操作類型：'add', 'edit', 'delete'
$homeworkID = $_POST['homeworkID'] ?? null; // 作業 ID
$classID = $_POST['classID'] ?? null;      // 班級 ID
$questionFolder = $_POST['question_folder'] ?? null; // 測資所屬的題目資料夾 (例如 'Q1', 'Q2')
// 注意：testerName 對於 'add' 動作將在後端自動生成，
// 對於 'edit'/'delete' 動作則從表單獲取
$testerName = $_POST['tester_name'] ?? ''; 

// 檢查所有必要參數是否存在。如果缺少任何一個，則設定錯誤訊息並導向
// 對於 add 動作，testerName 可以在此處先為空，因為它會在後端生成
if (empty($homeworkID) || empty($classID) || empty($action) || empty($questionFolder)) {
    $_SESSION['error'] = "缺少必要的作業、班級、題目或操作資訊！";
    header("Location: ../edittester.php");
    exit();
}

// 資料庫連線
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    $_SESSION['error'] = "資料庫連線失敗，請稍後再試。";
    header("Location: ../edittester.php");
    exit();
}

// 測資檔案的完整目錄路徑
// 結構為: data/{ClassID}/{HomeworkID}/tester/Q{QuestionID}/
$testerDirPath = __DIR__ . "/../data/$classID/$homeworkID/tester/$questionFolder/";

// 確保測資目錄存在。如果不存在且無法創建，則設定錯誤訊息並導向
if (!is_dir($testerDirPath)) {
    if (!mkdir($testerDirPath, 0777, true)) {
        $_SESSION['error'] = "無法建立測資目錄：{$testerDirPath}！請檢查權限。";
        $conn->close();
        header("Location: ../edittester.php");
        exit();
    }
}

// 根據不同的操作類型執行對應的邏輯
switch ($action) {
    case 'add':
        $inContent = $_POST['tester_in_content'] ?? '';  // 輸入檔內容
        $outContent = $_POST['tester_out_content'] ?? ''; // 輸出檔內容

        // 確保輸出內容不為空
        if (empty($outContent)) {
            $_SESSION['error'] = "新增測資：輸出內容為必填！";
            break; 
        }
        
        // --- 核心改動：後端自動生成新的測資名稱 (數字 n+1) ---
        $maxNum = 0;
        // 掃描當前題目資料夾下的所有檔案
        if (is_dir($testerDirPath)) {
            $files = scandir($testerDirPath);
            foreach ($files as $file) {
                if ($file === '.' || $file === '..') continue; // 忽略 . 和 ..

                $fileInfo = pathinfo($file);
                $baseName = $fileInfo['filename']; // 測資的基本名稱 (例如 '1', 'custom_test')
                
                // 檢查是否為純數字的測資名稱 (這是關鍵)
                if (ctype_digit($baseName)) { // ctype_digit 檢查字串是否只包含數字
                    $num = (int)$baseName; // 將數字字串轉為整數進行比較
                    if ($num > $maxNum) {
                        $maxNum = $num;
                    }
                }
            }
        }
        $testerName = (string)($maxNum + 1); // 新的測資名稱是最大數字加一，並轉為字串
        // --- 自動生成結束 ---

        $inFilePath = $testerDirPath . $testerName . '.in';
        $outFilePath = $testerDirPath . $testerName . '.out';

        // 檢查測資檔案是否已存在 (以防萬一，儘管自動生成旨在避免重複)
        // 這種情況通常發生在：1) 目錄無法讀取，maxNum 錯誤；2) 程式碼邏輯有誤；3) 同一毫秒內多個請求
        if (file_exists($inFilePath) || file_exists($outFilePath)) {
            $_SESSION['error'] = "新增測資：系統生成的測資名稱 '{$testerName}' 已存在於題目 {$questionFolder} 下，請檢查或手動刪除舊檔案。";
            break;
        }

        // 寫入 .in 檔案 (如果內容不為空)
        if (!empty($inContent)) {
            if (file_put_contents($inFilePath, $inContent) === false) {
                $_SESSION['error'] = "新增測資：寫入輸入檔失敗！";
                break;
            }
        }
        
        // 寫入 .out 檔案 (必須有內容)
        if (file_put_contents($outFilePath, $outContent) === false) {
            // 如果寫入失敗，並且之前寫入了 .in 檔案，則嘗試刪除它以避免殘留
            if (file_exists($inFilePath)) {
                unlink($inFilePath);
            }
            $_SESSION['error'] = "新增測資：寫入輸出檔失敗！";
            break;
        }

        // 新增測資成功，設定成功訊息，頁面將重定向並重新載入
        $_SESSION['success'] = "測資 '{$testerName}' (題目 {$questionFolder}) 新增成功！";
        break;

    case 'edit':
        $inContent = $_POST['tester_in_content'] ?? '';
        $outContent = $_POST['tester_out_content'] ?? '';

        // 編輯操作中，測資名稱和輸出內容為必填
        if (empty($testerName) || empty($outContent)) {
            $_SESSION['error'] = "編輯測資：測資名稱和輸出內容為必填！";
            break;
        }

        $inFilePath = $testerDirPath . $testerName . '.in';
        $outFilePath = $testerDirPath . $testerName . '.out';

        // 確保至少輸出檔存在，否則可能是無效的編輯請求（測資已不存在）
        if (!file_exists($outFilePath)) {
            $_SESSION['error'] = "編輯測資：找不到 '{$testerName}.out' 檔案在題目 {$questionFolder} 下！";
            break;
        }

        // 寫入 .in 檔案。如果輸入內容為空，且 .in 檔案存在，則刪除它
        if (!empty($inContent)) {
            if (file_put_contents($inFilePath, $inContent) === false) {
                $_SESSION['error'] = "編輯測資：寫入輸入檔失敗！";
                break;
            }
        } else {
            if (file_exists($inFilePath)) {
                unlink($inFilePath);
            }
        }
        
        // 寫入 .out 檔案
        if (file_put_contents($outFilePath, $outContent) === false) {
            $_SESSION['error'] = "編輯測資：寫入輸出檔失敗！";
            break;
        }

        // 編輯測資成功，設定成功訊息，頁面將重定向並重新載入
        $_SESSION['success'] = "測資 '{$testerName}' (題目 {$questionFolder}) 編輯成功！";
        break;

    case 'delete':
        // 刪除操作，檢查測資名稱是否存在
        if (empty($testerName)) {
            $_SESSION['error'] = "刪除測資：缺少測資名稱！";
            break;
        }

        $inFilePath = $testerDirPath . $testerName . '.in';
        $outFilePath = $testerDirPath . $testerName . '.out';

        $deletedCount = 0;
        $deleteSuccess = true; // 標記是否所有刪除操作都成功

        // 嘗試刪除 .in 檔案
        if (file_exists($inFilePath)) {
            if (unlink($inFilePath)) {
                $deletedCount++;
            } else {
                $_SESSION['error'] = "刪除測資：刪除輸入檔失敗！";
                $deleteSuccess = false;
            }
        }
        // 嘗試刪除 .out 檔案
        if (file_exists($outFilePath)) {
            if (unlink($outFilePath)) {
                $deletedCount++;
            } else {
                $_SESSION['error'] = "刪除測資：刪除輸出檔失敗！";
                $deleteSuccess = false;
            }
        }

        // 根據刪除結果設定 Session 訊息。
        // 不再設定 $_SESSION['success']，因為您希望成功時沒有彈窗。
        if (!$deleteSuccess) {
            // 如果刪除失敗，錯誤訊息已在上面設定
        } else if ($deletedCount == 0) {
            $_SESSION['error'] = "刪除測資：找不到 '{$testerName}' 相關檔案或刪除失敗！";
        }
        
        // 不需要在此處設置成功消息，因為您希望不彈出通知。
        // 頁面重定向將直接發生。
        break;

    default:
        // 處理未知的操作類型
        $_SESSION['error'] = "未知的操作！";
        break;
}

// 關閉資料庫連線
$conn->close();
// 重定向回測資編輯頁面。
// 無論操作成功與否（除了刪除成功），都會通過 $_SESSION['error'] 或 $_SESSION['success'] 彈出提示。
// 刪除成功時，頁面也會因為重定向而重新整理，但不會有彈窗。
header("Location: ../edittester.php");
exit();
?>