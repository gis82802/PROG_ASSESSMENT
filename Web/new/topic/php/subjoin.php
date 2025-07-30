<?php
session_start();
$classID = $_SESSION['selected_class_id'];
$studentID = $_POST['studentID'] ?? '';

if (!$studentID || !$classID) {
    $_SESSION['error'] = "資料缺失。";
    header("Location: ../joinpass.php");
    exit;
}

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗：" . $conn->connect_error);
}

// 移除 waitjoinclass 中該學生申請
$sql = "DELETE FROM waitjoinclass WHERE ClassID = ? AND StudentID = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("ss", $classID, $studentID);
$stmt->execute();

$_SESSION['error'] = "已拒絕加入申請。";
header("Location: ../joinpass.php");
exit;
?>
