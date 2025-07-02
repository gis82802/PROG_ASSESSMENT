<?php
session_start();
header('Content-Type: text/csv');
header('Content-Disposition: attachment; filename="students_scores.csv"');

// 加上 UTF-8 BOM，解決 Excel 顯示亂碼問題
echo "\xEF\xBB\xBF";

$classid = $_SESSION['selected_class_id'];

$conn = new mysqli("localhost", "root", "", "topic");
$conn->set_charset("utf8"); // 設定連線編碼

if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

// 取得所有作業 ID 與名稱
$homeworkList = []; // e.g., [id => name]
$sql_homeworks = "SELECT HomeworkID, HomeworkName FROM homeworkslist WHERE ClassID = ?";
$stmt = $conn->prepare($sql_homeworks);
$stmt->bind_param("s", $classid);
$stmt->execute();
$result = $stmt->get_result();
while ($row = $result->fetch_assoc()) {
    $homeworkList[$row['HomeworkID']] = $row['HomeworkName'];
}
$stmt->close();

// 取得所有學生 ID
$students = [];
$sql_students = "SELECT StudentID FROM student WHERE ClassID = ?";
$stmt = $conn->prepare($sql_students);
$stmt->bind_param("s", $classid);
$stmt->execute();
$result = $stmt->get_result();
while ($row = $result->fetch_assoc()) {
    $students[] = $row['StudentID'];
}
$stmt->close();

// 建立 CSV 檔案
$output = fopen('php://output', 'w');

// 輸出表頭
$headers = ['StudentID', 'FullName'];
foreach ($homeworkList as $hwid => $hwname) {
    $headers[] = $hwname; // 用作業名稱當作表頭
}
fputcsv($output, $headers);

// 輸出每位學生資料與成績
foreach ($students as $sid) {
    // 取得學生 Email, 姓名
    $sql_user = "SELECT Email, FirstName, LastName FROM users WHERE UserID = ?";
    $stmt_user = $conn->prepare($sql_user);
    $stmt_user->bind_param("s", $sid);
    $stmt_user->execute();
    $result_user = $stmt_user->get_result();
    $user = $result_user->fetch_assoc();
    $stmt_user->close();

    $fullName = trim(($user['FirstName'] ?? '') . ' ' . ($user['LastName'] ?? ''));

    // 只保留 @ 前面的 Email
    $email = $user['Email'] ?? '';
    $emailBeforeAt = explode('@', $email)[0];

    $row = [
        $emailBeforeAt,
        $fullName
    ];

    // 每份作業的成績
    foreach ($homeworkList as $hwid => $hwname) {
        $sql_score = "SELECT Score FROM final WHERE StudentID = ? AND HomeworkID = ?";
        $stmt_score = $conn->prepare($sql_score);
        $stmt_score->bind_param("ss", $sid, $hwid);
        $stmt_score->execute();
        $result_score = $stmt_score->get_result();
        $score_row = $result_score->fetch_assoc();
        $row[] = $score_row['Score'] ?? '';
        $stmt_score->close();
    }

    fputcsv($output, $row);
}

fclose($output);
$conn->close();
exit();
?>
