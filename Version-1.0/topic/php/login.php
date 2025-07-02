<?php
session_start(); // 開啟 session

// 資料庫連線
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

$email = $conn->real_escape_string($_POST['username']);
$password = $conn->real_escape_string($_POST['password']);

$sql = "SELECT * FROM users WHERE Email = '$email' AND Password = '$password'";
$result = $conn->query($sql);

if ($result->num_rows === 1) {
    $row = $result->fetch_assoc();
    $_SESSION['UserID'] = $row['UserID'];
    if ($row['Job'] === '0') {
        $conn->close();
        header("Location: ../student.php");
    } else if ($row['Job'] === '1') {
        $conn->close();
        header("Location: ../teacher.php");
    } else {
        $_SESSION['error'] = "未知角色";
        $conn->close();
        header("Location: ../index.php");
    }
    exit();
} else {
    $_SESSION['error'] = "帳號或密碼錯誤！";
    $conn->close();
    header("Location: ../login.php");
    exit();
}
?>
