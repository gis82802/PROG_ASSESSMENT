<?php
$classID = $_SESSION['selected_class_id']; // 當前課程ID
$teacherID = $_SESSION['UserID'];

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗：" . $conn->connect_error);
}


// 查詢該課程下所有作業
$sql = "SELECT * FROM homeworkslist WHERE ClassID = '$classID' ORDER BY HomeworkID DESC";
$result = $conn->query($sql);

$sql1 = "SELECT * FROM student WHERE ClassID = '$classID'";
$result1 = $conn->query($sql1);

if ($result->num_rows > 0) {
    while ($hw = $result->fetch_assoc()) {
        $hwID = $hw['HomeworkID'];
        $hwName = $hw['HomeworkName'];
        $deadline = $hw['Deadline'];
        $formattedDeadline = (new DateTime($deadline))->format('Y-m-d H:i');
        
        // 顯示作業資料
        echo '<div class="col-lg-4 col-md-4">';
        echo '  <div class="fh5co-blog animate-box">';
        echo '    <a href="#"><img class="img-responsive" src="images/project-4.jpg" alt=""></a>';
        echo '    <div class="blog-text">';
        echo '      <h3><a href="#">' . htmlspecialchars($hwName) . '</a></h3>';
        echo '      <span class="posted_on">繳交數</span>';
        $sql2 = "SELECT COUNT(DISTINCT StudentID) AS student_count FROM results WHERE HomeworkID = '$hwID'";
        $result2 = $conn->query($sql2);

        if ($result2 && $row2 = $result2->fetch_assoc()) {
            $studentCount = $row2['student_count'];
        }
        // 取得該課程學生數量
        if ($result1->num_rows > 0) {
            echo '      <span class="comment"><a href="#"> '.$row2['student_count'].' / ' . $result1->num_rows . ' <i class="icon-user"></i></a></span>';
        }

        echo '      <p>期限：' . $formattedDeadline . '</p>';
        echo '      <a href="./php/selecthomework3.php?homework_id=' . urlencode($hwID) . '" class="btn btn-primary">作業分數</a>';
        echo '      <a href="./php/selecthomework4.php?homework_id=' . urlencode($hwID) . '" class="btn btn-primary">編輯作業</a>';
        echo '      <a href="./php/selecthomework5.php?homework_id=' . urlencode($hwID) . '" class="btn btn-primary">編輯測資</a>';
        echo '    </div>';
        echo '  </div>';
        echo '</div>';
    }
} else {
    echo "<p>尚未建立作業。</p>";
}
$conn->close();
?>
