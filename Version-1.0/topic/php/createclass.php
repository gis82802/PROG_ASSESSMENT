<?php
session_start();

$teacherID = $_SESSION['UserID']; // 老師 ID
$title = $_POST['title'];         // 課程名稱          

// 資料庫連線
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

$title = $conn->real_escape_string($title);
$teacherID = $conn->real_escape_string($teacherID);

// 查詢目前最大的 ClassID（假設為純數字）
$sql = "SELECT MAX(CAST(ClassID AS UNSIGNED)) AS max_id FROM classes";
$result = $conn->query($sql);
$row = $result->fetch_assoc();

if ($row['max_id']) {
    $newID = str_pad($row['max_id'] + 1, 8, '0', STR_PAD_LEFT);
} else {
    $newID = "00000001"; // 第一筆
}

// 插入課程資料
$insert = "INSERT INTO classes (ClassID, Name, TeacherID)
           VALUES ('$newID', '$title', '$teacherID')";

if ($conn->query($insert) === TRUE) {
    header("Location: ../teacher.php");
    exit();
} else {
    echo "新增失敗: " . $conn->error;
}

$conn->close();
?>
