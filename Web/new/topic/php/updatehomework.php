<?php
session_start();

// 檢查必要的 session
if (!isset($_SESSION['selected_class_id'], $_SESSION['selected_homework_id'])) {
    $_SESSION['error'] = "Session 遺失，請重新操作。";
    header("Location: ../index.php");
    exit;
}

$classID = $_SESSION['selected_class_id'];
$homeworkID = $_SESSION['selected_homework_id'];
$homeworkName = $_POST['HomeworkName'] ?? '';
$deadline = $_POST['Deadline'] ?? '';
$questionCount = isset($_POST['QuestionCount']) ? intval($_POST['QuestionCount']) : 0;

// 資料庫連線
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗：" . $conn->connect_error);
}

// 更新作業名稱、截止時間、題數
$sql = "UPDATE homeworkslist SET HomeworkName = ?, Deadline = ?, QuestionSum = ? WHERE HomeworkID = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("ssis", $homeworkName, $deadline, $questionCount, $homeworkID);
$stmt->execute();
$stmt->close();

// 儲存每一題內容
$folder = __DIR__ . "/../data/$classID/$homeworkID/homework_texts";
if (!file_exists($folder)) {
    mkdir($folder, 0777, true);
}

for ($i = 1; $i <= $questionCount; $i++) {
    $text = $_POST["question_$i"] ?? '';
    $filePath = "$folder/Q$i.txt";
    file_put_contents($filePath, $text);
}

$conn->close();

// 成功提示
$_SESSION['error'] = "修改成功";
header("Location: ../edithomework.php");
exit;
?>
