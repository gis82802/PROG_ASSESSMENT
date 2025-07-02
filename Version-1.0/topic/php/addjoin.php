<?php
session_start();
$studentID = $_POST['studentID'] ?? null;
$classID = $_SESSION['selected_class_id'] ?? null;

if (!$studentID || !$classID) {
    $_SESSION['error'] = "通過失敗，資料不完整。";
    header("Location: ../joinpass.php");
    exit;
}

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

// 避免重複插入，先檢查是否已經存在 student 表
$checkSql = "SELECT * FROM student WHERE ClassID = ? AND StudentID = ?";
$checkStmt = $conn->prepare($checkSql);
$checkStmt->bind_param("ss", $classID, $studentID);
$checkStmt->execute();
$checkResult = $checkStmt->get_result();

if ($checkResult->num_rows === 0) {
    // 插入正式的學生資料
    $insertSql = "INSERT INTO student (ClassID, StudentID) VALUES (?, ?)";
    $insertStmt = $conn->prepare($insertSql);
    $insertStmt->bind_param("ss", $classID, $studentID);
    $insertStmt->execute();
}else {
    $_SESSION['error'] = "通過失敗，該學生已經存在。";
    header("Location: ../joinpass.php");
    exit;
}

// 從 waitjoinclass 刪除申請紀錄
$deleteSql = "DELETE FROM waitjoinclass WHERE ClassID = ? AND StudentID = ?";
$deleteStmt = $conn->prepare($deleteSql);
$deleteStmt->bind_param("ss", $classID, $studentID);
$deleteStmt->execute();

$conn->close();

$_SESSION['error'] = "✅ 已通過該學生加入。";
header("Location: ../joinpass.php");
exit;
?>
