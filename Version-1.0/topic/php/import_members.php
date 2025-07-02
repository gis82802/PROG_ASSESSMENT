<?php
session_start();
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("資料庫連線失敗: " . $conn->connect_error);
}
$conn->set_charset("utf8mb4"); // 使用 utf8mb4 支援中文

if ($_FILES['csv_file']['error'] === UPLOAD_ERR_OK) {
    $file = fopen($_FILES['csv_file']['tmp_name'], 'r');

    $classID = $_POST['classID'] ?? null;

    // 跳過 CSV 第一行標題列
    fgetcsv($file);

    while (($row = fgetcsv($file)) !== FALSE) {
        $studentID = $conn->real_escape_string(trim($row[0]));
        $firstName = $conn->real_escape_string(trim($row[1]));
        $lastName = $conn->real_escape_string(trim($row[2]));
        
        // 中文處理，確保轉成 UTF-8（如果來源有問題）
        $firstName = mb_convert_encoding($firstName, "UTF-8", "auto");
        $lastName = mb_convert_encoding($lastName, "UTF-8", "auto");

        $email = $studentID . "@nfu.edu.tw"; // 根據學號產生 Email

        // 檢查是否已存在相同 Email
        $sql_check_email = "SELECT * FROM users WHERE Email = ?";
        $stmt = $conn->prepare($sql_check_email);
        $stmt->bind_param("s", $email);
        $stmt->execute();
        $result = $stmt->get_result();

        if ($result->num_rows > 0) {
            $existing = $result->fetch_assoc();
            $existingUserID = $existing['UserID'];

            // 檢查學生是否已在此課程
            $sql_check_course = "SELECT * FROM student WHERE ClassID = ? AND StudentID = ?";
            $stmt2 = $conn->prepare($sql_check_course);
            $stmt2->bind_param("ss", $classID, $existingUserID);
            $stmt2->execute();
            $courseResult = $stmt2->get_result();

            if ($courseResult->num_rows == 0) {
                // 還沒加入課程 → 插入 student 關聯表
                $stmt3 = $conn->prepare("INSERT INTO student (ClassID, StudentID) VALUES (?, ?)");
                $stmt3->bind_param("ss", $classID, $existingUserID);
                $stmt3->execute();
            }

            continue; // 跳到下一筆資料
        }

        // 建立新帳號
        $job = '0'; // 學生
        $sql_get_latest_userID = "SELECT UserID FROM users WHERE Job = ? ORDER BY UserID DESC LIMIT 1";
        $stmt4 = $conn->prepare($sql_get_latest_userID);
        $stmt4->bind_param("s", $job);
        $stmt4->execute();
        $result = $stmt4->get_result();

        if ($result->num_rows > 0) {
            $latest_userID = $result->fetch_assoc()['UserID'];
            $new_userID_num = (int)substr($latest_userID, 1) + 1;
            $new_userID = $job . str_pad($new_userID_num, 7, '0', STR_PAD_LEFT);
        } else {
            $new_userID = $job . '0000001';
        }

        $password = 'Ss123'; // 預設密碼
        $sql_insert_user = "INSERT INTO users (UserID, Email, Password, FirstName, LastName, Job) 
                            VALUES (?, ?, ?, ?, ?, ?)";
        $stmt5 = $conn->prepare($sql_insert_user);
        $stmt5->bind_param("ssssss", $new_userID, $email, $password, $firstName, $lastName, $job);

        if ($stmt5->execute()) {
            // 建立 user 成功 → 插入 student 關聯
            $stmt6 = $conn->prepare("INSERT INTO student (ClassID, StudentID) VALUES (?, ?)");
            $stmt6->bind_param("ss", $classID, $new_userID);
            $stmt6->execute();
        } else {
            $_SESSION['error'] = "新增學生失敗：" . $stmt5->error;
            header("Location: ../teacher.php");
            exit();
        }
    }

    fclose($file);
    $_SESSION['success'] = "匯入成功！";
    header("Location: ./selectclass.php?class_id=" . urlencode($classID));
    exit();

} else {
    $_SESSION['error'] = "上傳失敗，請確認檔案格式！";
    header("Location: ./selectclass.php?class_id=" . urlencode($_POST['classID'] ?? ''));
    exit();
}
?>
