<?php
session_start();

if (isset($_GET['class_id'])) {
    $_SESSION['selected_class_id'] = $_GET['class_id'];
    header("Location: ../studentclass.php"); // 轉向到顯示課程內容的頁面
    exit();
} else {
    echo "未指定課程 ID";
}
?>