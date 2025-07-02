<?php
$id = intval($_GET['id']);

$host = "localhost";
$user = "root";
$password = "";
$dbname = "topic";

$conn = new mysqli($host, $user, $password, $dbname);
if ($conn->connect_error) {
    http_response_code(500);
    echo json_encode(["error" => "資料庫連線失敗"]);
    exit;
}

// 根據 HomeworkID 查詢 QuestionSum
$sql = "SELECT QuestionSum FROM homeworkslist WHERE HomeworkID = $id";
$result = $conn->query($sql);

if ($result && $row = $result->fetch_assoc()) {
    echo json_encode(['QuestionSum' => $row['QuestionSum']]);
} else {
    http_response_code(404);
    echo json_encode(["error" => "找不到資料"]);
}

$conn->close();
?>
