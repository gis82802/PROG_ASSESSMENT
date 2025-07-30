<?php
session_start();
$teacherID = $_SESSION['UserID'];
$classID = $_SESSION['selected_class_id'];

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

// 自動取得下一個作業ID（格式：8位數）
$getMaxID = "SELECT MAX(HomeworkID) AS MaxID FROM homeworkslist";
$result = $conn->query($getMaxID);
$row = $result->fetch_assoc();
$maxID = $row['MaxID'] ?? '00000000';
$homeworkID = str_pad((int)$maxID + 1, 8, '0', STR_PAD_LEFT);

// 表單資料
$homeworkName = $_POST['title'];
$deadline = $_POST['deadline'];
$questionSum = 0;
$subQuestions = [];

foreach ($_POST as $key => $value) {
    if (strpos($key, 'subTitle') === 0) {
        $questionSum++;
        $subQuestions[] = $value;
    }
}

// 存入作業資料
$sql = "INSERT INTO homeworkslist (HomeworkID, Deadline, HomeworkName, QuestionSum, ClassID)
        VALUES ('$homeworkID', '$deadline', '$homeworkName', '$questionSum', '$classID')";

if ($conn->query($sql) === TRUE) {
    // 建立資料夾：../homework_texts/00000001/
    $folderPath = "../data/$classID/$homeworkID/homework_texts";
    if (!file_exists($folderPath)) {
        mkdir($folderPath, 0777, true);
    }

    // 寫入每個小題為 Q1.txt、Q2.txt ...
    foreach ($subQuestions as $index => $text) {
        $fileName = $folderPath . "/Q" . ($index + 1) . ".txt";
        file_put_contents($fileName, $text);
    }
    
    echo "✅ 作業與小題建立成功！";
    $conn->close();
    header("Location: ../teacherclass.php");
} else {
    echo "❌ 錯誤：" . $conn->error;
}

$conn->close();
?>
