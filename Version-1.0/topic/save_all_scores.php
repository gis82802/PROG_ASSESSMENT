<?php
session_start();
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

$homeworkID = $_SESSION['selected_homework_id'] ?? null;
if (!$homeworkID || !isset($_POST['scores'])) {
    echo "資料不完整";
    exit;
}

$scores = $_POST['scores'];
foreach ($scores as $studentID => $score) {
    $studentID = $conn->real_escape_string($studentID);
    $score = intval($score);

    // 先查資料是否存在
    $check = $conn->query("SELECT * FROM final WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID'");
    if ($check->num_rows > 0) {
        $conn->query("UPDATE final SET Score = '$score' WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID'");
    } else {
        $conn->query("INSERT INTO final (HomeworkID, StudentID, Score) VALUES ('$homeworkID', '$studentID', '$score')");
    }
}
echo "所有分數已儲存成功！";
?>
