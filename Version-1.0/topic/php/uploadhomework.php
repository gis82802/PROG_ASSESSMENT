
	<?php
        session_start();

        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            $questionID = $_POST['Question_id'] ?? null;
            $file = $_FILES['file'] ?? null;

            $userid = $_SESSION['UserID'];
            $homeworkID = $_SESSION['selected_homework_id'];
            $conn = new mysqli("localhost", "root", "", "topic");
            $sql = "SELECT * FROM homeworkslist WHERE HomeworkID = '$homeworkID'";
            $result = $conn->query($sql);
            $row = $result->fetch_assoc();
            $classID = $row['ClassID'];

            $uploadDir = __DIR__ . "/../data/$classID/$homeworkID/homework/$userid/Q$questionID/";
            if (!is_dir($uploadDir)) {
                mkdir($uploadDir, 0777, true);
            }

            // 清空該題資料夾中的舊檔案
            $files = glob($uploadDir . '/*');
            foreach ($files as $fileToDelete) {
                if (is_file($fileToDelete)) {
                    unlink($fileToDelete);
                }
            }

            $filename = basename($file['name']);
            $target = $uploadDir . '/' . $filename;

            if (move_uploaded_file($file['tmp_name'], $target)) {
                $_SESSION['error'] = "繳交失敗請重新繳交！";
                header("Location: ../uploadhomework.php");
                $pythonPath = "C:\Users\user\AppData\Local\Microsoft\WindowsApps\PythonSoftwareFoundation.Python.3.12_qbz5n2kfra8p0\python3.12.exe";
                $scriptPathGemini = "C:\\xampp\\htdocs\\topicbee\\py\\Gemini.py";
                $scriptPathMistral = "C:\\xampp\\htdocs\\topicbee\\py\\Mistral.py";
                $classIDArg = escapeshellarg($classID);
                $homeworkIDArg = escapeshellarg($homeworkID);
                $userIDArg = escapeshellarg($userid);
                $questionIDArg = escapeshellarg($questionID);
                $filenameArg = escapeshellarg($filename);

                RG:
                $cmd = "\"$pythonPath\" \"$scriptPathGemini\" $classIDArg $homeworkIDArg $userIDArg $questionIDArg $filenameArg";
                $output = shell_exec($cmd . " 2>&1");

                $readfeedbackGemini = __DIR__ . "/../data/$classID/$homeworkID/feedback/$userid/Q" . $questionID . "_Gemini_feedback.txt";

                // 多個關鍵字依序查找
                $keywords = ["**總分", "總分"];

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
                        $checkSql = "SELECT * FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$questionID' AND LLM = '0'";
                        $checkResult = $conn->query($checkSql);

                        if ($checkResult && $checkResult->num_rows > 0) {
                            // 更新資料
                            $updateSql = "UPDATE results SET Score = '$score' WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$questionID' AND LLM = '0'";
                            $conn->query($updateSql);
                        } else {
                            // 插入資料
                            $insertSql = "INSERT INTO results (HomeworkID, StudentID, Question, Score, LLM) VALUES ('$homeworkID', '$userid', '$questionID', '$score', '0')";
                            $conn->query($insertSql);
                        }
                    } else {
                        // 沒有成功取到分數 → 重試
                        goto RG;
                    }
                } else {
                    // 檔案不存在 → 重試
                    goto RG;
                }


                RM:
                $cmd2 = "\"$pythonPath\" \"$scriptPathMistral\" $classIDArg $homeworkIDArg $userIDArg $questionIDArg $filenameArg";
                $output2 = shell_exec($cmd2 . " 2>&1");
                $readfeedbackMistral = __DIR__ . "/../data/$classID/$homeworkID/feedback/$userid/Q" . $questionID . "_Mistral_feedback.txt";

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
                        $_SESSION['error'] = "繳交成功！";
                        // 檢查資料是否已存在
                        $checkSql = "SELECT * FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$questionID' AND LLM = '1'";
                        $checkResult = $conn->query($checkSql);

                        if ($checkResult && $checkResult->num_rows > 0) {
                            // 更新資料
                            $updateSql = "UPDATE results SET Score = '$score' WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$questionID' AND LLM = '1'";
                            $conn->query($updateSql);
                        } else {
                            // 插入資料
                            $insertSql = "INSERT INTO results (HomeworkID, StudentID, Question, Score, LLM) VALUES ('$homeworkID', '$userid', '$questionID', '$score', '1')";
                            $conn->query($insertSql);
                        }
                    } else {
                        // 沒有成功取到分數 → 重試
                        goto RM;
                    }
                } else {
                    goto RM;
                }

            } else {
                $_SESSION['error'] = "上傳失敗！";
                header("Location: ../uploadhomework.php");
            }
        } else {
            $_SESSION['error'] = "傳送失敗！";
            header("Location: ../uploadhomework.php");
        }
    ?>
