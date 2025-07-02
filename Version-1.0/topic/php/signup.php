<?php
// 資料庫連線設定
session_start(); // 開啟 session

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

$firstname = $_POST['firstname'];  // 表單中 name="username" 的欄位實際是 Email
$lastname = $_POST['lastname'];
$email = $_POST['email'];  // 表單中 name="username" 的欄位實際是 Email
$password = $_POST['password'];
$repassword = $_POST['repassword'];  // 表單中 name="username" 的欄位實際是 Email
$job = $_POST['job'];

if ($password !== $repassword) {
    $_SESSION['error'] = "密碼不一致，請重新確認！";
    header("Location: ../signup.php");
    exit();
}

$firstname = $conn->real_escape_string($firstname);
$lastname = $conn->real_escape_string($lastname);
$email = $conn->real_escape_string($email);
$password = $conn->real_escape_string($password);
$repassword = $conn->real_escape_string($repassword);
$job = $conn->real_escape_string($job);

$sql_check_email = "SELECT * FROM users WHERE Email = '$email'";
$result = $conn->query($sql_check_email);

if ($result->num_rows > 0) {
    $_SESSION['error'] = "這個 Email 已經註冊過，請使用其他 Email！";
    header("Location: ../signup.php");
    exit();
}

$sql_get_latest_userID = "SELECT UserID FROM users WHERE Job = '$job' ORDER BY UserID DESC LIMIT 1";
$result = $conn->query($sql_get_latest_userID);

if ($result->num_rows > 0) {
    // 獲取最新的 UserID
    $row = $result->fetch_assoc();
    $latest_userID = $row['UserID'];
    
    // 根據 `Job` 來生成新的 `UserID`
    // 取得 `UserID` 的後七位並遞增
    $new_userID = (int)substr($latest_userID, 1) + 1;  // 去掉 Job 部分，然後遞增
    $new_userID = str_pad($new_userID, 7, '0', STR_PAD_LEFT);  // 補足 7 位數字
    
    // 將 Job 和新的數字組合成完整的 UserID
    $new_userID = $job . $new_userID;
} else {
    // 如果沒有找到任何用戶，則從 0000001 開始
    $new_userID = $job . '0000001';
}

// 插入資料（不需要指定 UserID，因為已經手動生成）
$sql_insert = "INSERT INTO `users` (`UserID`, `Email`, `Password`, `FirstName`, `LastName`, `Job`) 
        VALUES ('$new_userID', '$email', '$password', '$firstname', '$lastname', '$job')";

if ($conn->query($sql_insert) === TRUE) {
    $_SESSION['error'] = "註冊成功！";
    header("Location: ../login.php");
    exit();
} else {
    $_SESSION['error'] = "註冊失敗，請重新註冊！";
    header("Location: ../signup.php");
}

$conn->close();
?>
