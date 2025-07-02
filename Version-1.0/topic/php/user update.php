<?php
session_start();

// 資料庫連線
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

// 取得使用者 ID
$userid = $_SESSION['UserID'];

// 取得使用者資料
$sql = "SELECT * FROM users WHERE UserID = '$userid'";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    $user = $result->fetch_assoc();
    $job = $user['Job']; // 0 = student, 1 = teacher
} else {
    $user = null;
    $job = 0; // 預設為學生，避免錯誤
}

// 根據 Job 設定導向頁面
$redirect_page = ($job == 1) ? '../teacher User Information.php' : '../student User Information.php';

// 修改基本資料
if ($_SERVER["REQUEST_METHOD"] == "POST" && !isset($_POST['change_password'])) {
    $firstname = $conn->real_escape_string($_POST['firstname']);
    $lastname = $conn->real_escape_string($_POST['lastname']);

    $sql = "UPDATE users SET FirstName='$firstname', LastName='$lastname' WHERE UserID='$userid'";
    if ($conn->query($sql) === TRUE) {
        echo "<script>alert('基本資料更新成功'); window.location.href='$redirect_page';</script>";
    } else {
        echo "更新失敗: " . $conn->error;
    }
}

// 修改密碼
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['change_password'])) {
    $old_password = $_POST['old_password'];
    $new_password = $_POST['new_password'];

    $check_sql = "SELECT Password FROM users WHERE UserID='$userid'";
    $result = $conn->query($check_sql);
    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $current_password = $row['Password'];

        if ($old_password === $current_password) {
            // 檢查新密碼是否與舊密碼一樣
            if ($new_password === $current_password) {
                echo "<script>alert('密碼更新失敗（密碼與原先一樣）'); window.location.href='$redirect_page';</script>";
                exit;
            }

            $update_sql = "UPDATE users SET Password='$new_password' WHERE UserID='$userid'";
            if ($conn->query($update_sql) === TRUE) {
                echo "<script>alert('密碼已更新'); window.location.href='$redirect_page';</script>";
            } else {
                echo "密碼更新失敗: " . $conn->error;
            }
        } else {
            echo "<script>alert('原密碼錯誤'); window.location.href='$redirect_page';</script>";
        }
    }
}


$conn->close();
?>
