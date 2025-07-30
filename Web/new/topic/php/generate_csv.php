<?php
session_start();

$classID = $_SESSION['selected_class_id'];

header('Content-Type: text/csv; charset=UTF-8');
header('Content-Disposition: attachment; filename="import_template.csv"');

// 送出 UTF-8 BOM，避免 Excel 開啟時亂碼
echo "\xEF\xBB\xBF";

$output = fopen("php://output", "w");
fputcsv($output, ['StudentID', 'FirstName', 'LastName']);
fputcsv($output, ['', '', '']);

fclose($output);
exit;
?>
