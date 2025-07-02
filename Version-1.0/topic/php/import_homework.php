<?php

session_start();
error_reporting(E_ALL);
ini_set('display_errors', 1);
set_time_limit(7200); // 設定最大執行時間為 300 秒（5分鐘）

$classID = $_SESSION['selected_class_id'];

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_FILES['homeworkZip'])) {
    $file = $_FILES['homeworkZip'];

    $originalNameRaw = $file['name'];
    $originalName = basename(str_replace('\\', '/', $originalNameRaw));

    if ($file['error'] !== UPLOAD_ERR_OK) {
        echo "上傳失敗，錯誤代碼：" . $file['error'];
        exit;
    }

    $allowedMimeTypes = ['application/zip', 'application/x-zip-compressed', 'multipart/x-zip'];
    $finfo = finfo_open(FILEINFO_MIME_TYPE);
    $mimeType = finfo_file($finfo, $file['tmp_name']);
    finfo_close($finfo);

    if (!in_array($mimeType, $allowedMimeTypes)) {
        echo "只允許上傳 ZIP 壓縮檔";
        exit;
    }

    $uploadDir = __DIR__ . '/../data/' . $classID . '/zip/';
    if (!is_dir($uploadDir)) {
        if (!mkdir($uploadDir, 0755, true)) {
            echo "建立資料夾失敗: $uploadDir";
            exit;
        }
    }

    $destination = $uploadDir . $originalName;

    if (move_uploaded_file($file['tmp_name'], $destination)) {
        echo "檔案上傳成功: " . htmlspecialchars(pathinfo($originalName, PATHINFO_FILENAME)) . "<br>";

        $_SESSION['last_uploaded_zip'] = $originalName;

        $zip = new ZipArchive;
        $res = $zip->open($destination);
        if ($res === true || $res === ZipArchive::ER_OK) {
            $extractPath = $uploadDir;  // 解壓縮到 zip 資料夾中PATHINFO_FILENAME) . '/';
            if (!is_dir($extractPath)) {
                mkdir($extractPath, 0755, true);
            }

            if ($zip->extractTo($extractPath)) {
                echo "解壓縮完成，檔案已解壓縮自：" . htmlspecialchars(pathinfo($originalName, PATHINFO_FILENAME)) . "<br>";
            } else {
                echo "解壓縮失敗";
                exit;
            }
            $zip->close();

            // QX.txt 統計區塊放在解壓縮完成後
            $txtFiles = glob($extractPath . pathinfo($originalName, PATHINFO_FILENAME) . '/*.txt');
            $txtCount = count($txtFiles);

            echo "找到 .txt 檔案數量為：$txtCount";
        } else {
            echo "無法開啟 ZIP 檔案，錯誤碼: $res";
            exit;
        }
    } else {
        echo "檔案移動失敗，目標路徑： $destination";
        exit;
    }

    $conn = new mysqli("localhost", "root", "", "topic");
    if ($conn->connect_error) {
        die("連線失敗: " . $conn->connect_error);
    }
    $getMaxID = "SELECT MAX(HomeworkID) AS MaxID FROM homeworkslist";
    $result = $conn->query($getMaxID);
    $row = $result->fetch_assoc();
    $maxID = $row['MaxID'] ?? '00000000';
    $homeworkID = str_pad((int)$maxID + 1, 8, '0', STR_PAD_LEFT);
    
    $homeworkName = pathinfo($originalName, PATHINFO_FILENAME);
    $deadline = date("Y-m-d H:i:s");  // 現在時間
    $questionSum = $txtCount;

    $sql = "INSERT INTO `homeworkslist`(`HomeworkID`, `Deadline`, `HomeworkName`, `QuestionSum`, `ClassID`) 
            VALUES (?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);

    if ($stmt) {
        $stmt->bind_param("sssis", $homeworkID, $deadline, $homeworkName, $questionSum, $classID);
        if ($stmt->execute()) {
            echo "<br>作業資料已成功寫入資料庫。";
        } else {
            echo "<br>資料寫入失敗：" . $stmt->error;
        }
        $stmt->close();
    } else {
        echo "<br>SQL 準備失敗：" . $conn->error;
    }

    $homeworkQDir = __DIR__ . '/../data/' . $classID . '/'.$homeworkID.'/homework_texts/';
    if (!is_dir($homeworkQDir)) {
        if (!mkdir($homeworkQDir, 0755, true)) {
            echo "建立資料夾失敗: $homeworkQDir";
            exit;
        }
    }

    $QFolder = $extractPath . pathinfo($originalName, PATHINFO_FILENAME) . '/';

   for ($i = 1; $i <= $txtCount; $i++) {
        $sourceFile = $QFolder . "Q$i.txt";
        $destFile = $homeworkQDir . "Q$i.txt";

        echo "尋找小題：$sourceFile → ";
        
        if (file_exists($sourceFile)) {
            if (!rename($sourceFile, $destFile)) {
                echo "搬移 Q$i.txt 失敗<br>";
            } else {
                echo "成功<br>";
            }
        } else {
            echo "找不到檔案 Q$i.txt<br>";
        }
    }

    echo "所有小題檔案已成功搬移到：$homeworkQDir<br>";
    $files_c = glob($QFolder . '*.c');
    $files_cpp = glob($QFolder . '*.cpp');
    $files_cs = glob($QFolder . '*.cs');
    $files_java = glob($QFolder . '*.java');
    $files_py = glob($QFolder . '*.py');

    $allFiles = array_merge($files_c, $files_cpp, $files_cs, $files_java, $files_py);

    for ($i = 1; $i <= $txtCount; $i++) {
        foreach ($allFiles as $filePath) {
            $filename = basename($filePath);  // e.g., abc_1.py
            $nameWithoutExt = pathinfo($filename, PATHINFO_FILENAME);

            // 判斷是否為 "_$i" 結尾前的檔案
            $pos = strpos($nameWithoutExt, "_$i");
            if ($pos !== false) {
                // 取出前綴名稱 -> abc
                $before = substr($nameWithoutExt, 0, $pos);
                $email = $before . '@nfu.edu.tw';

                // 查詢學生
                $sql_check_student = "
                    SELECT student.StudentID
                    FROM student
                    JOIN users ON student.StudentID = users.UserID
                    WHERE student.ClassID = ? AND users.Email = ?
                ";
                $stmt = $conn->prepare($sql_check_student);
                $stmt->bind_param("ss", $classID, $email);
                $stmt->execute();
                $result = $stmt->get_result();

                if ($result->num_rows > 0) {
                    $row = $result->fetch_assoc();
                    $studentID = $row['StudentID'];

                    // 建立目標資料夾
                    $homeworkDir = __DIR__ . "/../data/$classID/$homeworkID/homework/$studentID/Q$i/";
                    if (!is_dir($homeworkDir)) {
                        mkdir($homeworkDir, 0777, true);
                    }

                    // 刪除舊檔案
                    $files = glob($homeworkDir . '/*');
                    foreach ($files as $fileToDelete) {
                        if (is_file($fileToDelete)) {
                            unlink($fileToDelete);
                        }
                    }

                    // 搬移檔案
                    $targetPath = $homeworkDir . $filename;
                    if (rename($filePath, $targetPath)) {
                        echo "已轉移：$filename → $targetPath<br>";
                    } else {
                        echo "轉移失敗：$filename<br>";
                    }

                    $pythonPath = "C:\\Users\\gkggg\\AppData\\Local\\Programs\\Python\\Python313\\python.exe";
                    $scriptPathGemini = "C:\\xampp\\htdocs\\topicbee\\py\\Gemini.py";
                    $scriptPathMistral = "C:\\xampp\\htdocs\\topicbee\\py\\Mistral.py";
                    $classIDArg = escapeshellarg($classID);
                    $homeworkIDArg = escapeshellarg($homeworkID);
                    $userIDArg = escapeshellarg($studentID);
                    $questionIDArg = escapeshellarg($i);
                    $filenameArg = escapeshellarg($filename);
                    $time = 0;
                    RG:
                    $time++;
                    $error = "繳交失敗";
                    
                    $cmd = "$pythonPath \"$scriptPathGemini\" $classIDArg $homeworkIDArg $userIDArg $questionIDArg $filenameArg";
                    exec($cmd, $output, $return_var);
                    //echo "<pre>執行指令：$cmd\n";
                    //echo "回傳碼：$return_var\n";
                    //echo "輸出結果：\n" . implode("\n", $output) . "</pre>";

                    $readfeedbackGemini = __DIR__ . "/../data/$classID/$homeworkID/feedback/$studentID/Q" . $i . "_Gemini_feedback.txt";

                    // 多個關鍵字依序查找
                    $keywords = ["**總分", "總分"];
                    $retry = 0;
                    while (!file_exists($readfeedbackGemini) && $retry < 100) {
                        sleep(1);  // 每秒檢查一次
                        $retry++;
                    }

                    if (file_exists($readfeedbackGemini)) {
                        $content = file_get_contents($readfeedbackGemini);
                        $score = null;

                        // 嘗試依序比對所有關鍵字
                        foreach ($keywords as $keywordGemini) {
                            // 嘗試抓取「= 數字」格式
                            if (preg_match("/" . preg_quote($keywordGemini, '/') . ".*?=\s*(\d+)/u", $content, $matches)) {
                                $score = $matches[1];
                                break;
                            }
                            // 如果沒有「= 數字」格式，再抓一般數字
                            elseif (preg_match("/" . preg_quote($keywordGemini, '/') . "[^\d]*(\d+)/u", $content, $matches)) {
                                $score = $matches[1];
                                break;
                            }
                        }

                        if ($score !== null) {
                            // 檢查資料是否已存在
                            $checkSql = "SELECT * FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID' AND Question = '$i' AND LLM = '0'";
                            $checkResult = $conn->query($checkSql);

                            if ($checkResult && $checkResult->num_rows > 0) {
                                // 更新資料
                                $updateSql = "UPDATE results SET Score = '$score' WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID' AND Question = '$i' AND LLM = '0'";
                                $conn->query($updateSql);
                            } else {
                                // 插入資料
                                $insertSql = "INSERT INTO results (HomeworkID, StudentID, Question, Score, LLM) VALUES ('$homeworkID', '$studentID', '$i', '$score', '0')";
                                $conn->query($insertSql);
                            }
                        } else {
                            if($time>3){
                                $time = 0;
                                goto RM;
                            }
                            // 沒有成功取到分數 → 重試
                            goto RG;
                        }
                    }

                    $time=0;
                    RM:
                    $time++;
                    $cmd2 = "\"$pythonPath\" \"$scriptPathMistral\" $classIDArg $homeworkIDArg $userIDArg $questionIDArg $filenameArg";
                    exec($cmd2, $output, $return_var);
                    //echo "<pre>執行指令：$cmd2\n";
                    //echo "回傳碼：$return_var\n";
                    //echo "輸出結果：\n" . implode("\n", $output) . "</pre>";
                    $readfeedbackMistral = __DIR__ . "/../data/$classID/$homeworkID/feedback/$studentID/Q" . $i . "_Mistral_feedback.txt";

                    $retry = 0;
                    while (!file_exists($readfeedbackMistral) && $retry < 100) {
                        sleep(1);  // 每秒檢查一次
                        $retry++;
                    }

                    if (file_exists($readfeedbackMistral)) {
                        $content2 = file_get_contents($readfeedbackMistral);
                        $score = null;

                        foreach ($keywords as $keywordMistral) {
                            // 嘗試抓取「= 數字」格式
                            if (preg_match("/" . preg_quote($keywordMistral, '/') . ".*?=\s*(\d+)/u", $content2, $matches)) {
                                $score = $matches[1];
                                break;
                            }
                            // 如果沒有「= 數字」格式，再抓一般數字
                            elseif (preg_match("/" . preg_quote($keywordMistral, '/') . "[^\d]*(\d+)/u", $content2, $matches)) {
                                $score = $matches[1];
                                break;
                            }
                        }
                        if ($score !== null) {
                            $error = "繳交成功！";
                            // 檢查資料是否已存在
                            $checkSql = "SELECT * FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID' AND Question = '$i' AND LLM = '1'";
                            $checkResult = $conn->query($checkSql);

                            if ($checkResult && $checkResult->num_rows > 0) {
                                // 更新資料
                                $updateSql = "UPDATE results SET Score = '$score' WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID' AND Question = '$i' AND LLM = '1'";
                                $conn->query($updateSql);
                            } else {
                                // 插入資料
                                $insertSql = "INSERT INTO results (HomeworkID, StudentID, Question, Score, LLM) VALUES ('$homeworkID', '$studentID', '$i', '$score', '1')";
                                $conn->query($insertSql);
                            }
                        } else {
                            if($time>3){
                                $time = 0;
                                goto end;
                            }
                            // 沒有成功取到分數 → 重試
                            goto RM;
                        }
                    }
                    end:
                    echo $email. $error.'<br>' ;
                } else {
                    echo "查無學生資料：$email<br>";
                }
            }
        }
    }
}
?>