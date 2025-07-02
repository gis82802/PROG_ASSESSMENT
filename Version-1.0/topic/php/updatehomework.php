<?php
session_start();
$classID = $_SESSION['selected_class_id'];
$homeworkID = $_SESSION['selected_homework_id'];
$homeworkName = $_POST['HomeworkName'] ;
$deadline =$_POST['Deadline'] ;

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗：" . $conn->connect_error);
}

// 更新作業名稱與截止時間
$sql = "UPDATE homeworkslist SET HomeworkName = ?, Deadline = ? WHERE HomeworkID = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("sss", $homeworkName, $deadline, $homeworkID);
$stmt->execute();

// 取得題數
$sql2 = "SELECT QuestionSum FROM homeworkslist WHERE HomeworkID = ?";
$stmt2 = $conn->prepare($sql2);
$stmt2->bind_param("s", $homeworkID);
$stmt2->execute();
$result = $stmt2->get_result();
$row = $result->fetch_assoc();
$questionSum = $row['QuestionSum'];
$stmt2->close();

// 儲存每題的 .txt 檔
$folder = __DIR__ . "/../data/$classID/$homeworkID/homework_texts";
if (!file_exists($folder)) {
    mkdir($folder, 0777, true);
}

for ($i = 1; $i <= $questionSum; $i++) {
    $text = $_POST["question_$i"] ?? '';
    $filePath = "$folder/Q$i.txt";
    file_put_contents($filePath, $text);
}

$conn->close();

$_SESSION['error'] = "修改成功";
header("Location: ../edithomework.php");
exit;
?>
