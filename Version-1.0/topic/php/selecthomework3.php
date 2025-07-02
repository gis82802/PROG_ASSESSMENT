<?php
session_start();

if (isset($_GET['homework_id'])) {
    $_SESSION['selected_homework_id'] = $_GET['homework_id'];
    header("Location: ../homeworkscoresedit.php"); // 轉向到顯示課程內容的頁面
    exit();
} else {
    echo "未指定課程 ID";
}
?>