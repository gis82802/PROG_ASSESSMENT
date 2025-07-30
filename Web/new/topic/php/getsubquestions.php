<?php
session_start();

header('Content-Type: application/js'); // 指定回傳 JSON

$classID = $_GET['classid'] ?? '';
$homeworkID = $_GET['homeworkid'] ?? '';

$folderPath = "../data/$classID/$homeworkID";

// 確保資料夾存在
if (is_dir($folderPath)) {
    $files = scandir($folderPath);
    $files = array_diff($files, array('.', '..')); // 過濾特殊目錄
    echo json_encode(array_values($files));
} else {
    echo json_encode([]); // 如果資料夾不存在，回傳空陣列
}
?>
