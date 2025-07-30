<?php
$classID = $_SESSION['selected_class_id'];
$studentID = $_SESSION['UserID'];

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗：" . $conn->connect_error);
}

$sql = "SELECT * FROM homeworkslist WHERE ClassID = '$classID' ORDER BY Deadline ASC";
$result = $conn->query($sql);

$now = new DateTime();
$upcoming_homeworks = [];
$expired_homeworks = [];

if ($result->num_rows > 0) {
    while ($hw = $result->fetch_assoc()) {
        $deadline = new DateTime($hw['Deadline']);
        if ($deadline >= $now) {
            $upcoming_homeworks[] = $hw;
        } else {
            $expired_homeworks[] = $hw;
        }
    }

    // 渲染函式
    function renderHomeworkCard($hw, $studentID, $conn, $now) {
        $hwID = $hw['HomeworkID'];
        $hwName = $hw['HomeworkName'];
        $deadline = new DateTime($hw['Deadline']);
        $formattedDeadline = $deadline->format('Y-m-d H:i');
        $hwsum = $hw['QuestionSum'];

        $sql1 = "SELECT COUNT(DISTINCT Question) AS question_count FROM results WHERE HomeworkID = '$hwID' AND StudentID = '$studentID'";
        $result1 = $conn->query($sql1);
        $questionCount = 0;
        if ($result1 && $row1 = $result1->fetch_assoc()) {
            $questionCount = $row1['question_count'];
        }

        echo '<div class="col-lg-4 col-md-4">';
        echo '  <div class="fh5co-blog animate-box">';
        if ($now < $deadline) {
            echo '    <a href="./php/selecthomework.php?homework_id=' . urlencode($hwID) . '"><img class="img-responsive" src="images/project-4.jpg" alt=""></a>';
            echo '    <div class="blog-text">';
            echo '      <h3><a href="./php/selecthomework.php?homework_id=' . urlencode($hwID) . '">' . htmlspecialchars($hwName) . '</a></h3>';
            echo '      <span class="posted_on">繳交題目數</span> ' . $questionCount . '/' . $hwsum . ' <i class="icon-open-book"></i>';
            echo '      <p>期限：' . $formattedDeadline . '</p>';
            echo '      <a href="./php/selecthomework.php?homework_id=' . urlencode($hwID) . '" class="btn btn-primary">上傳作業</a>';
            echo '      <a href="./php/selecthomework2.php?homework_id=' . urlencode($hwID) . '" class="btn btn-primary">查看分數與回饋</a>';


        }else {
            echo '    <a href="./php/selecthomework2.php?homework_id=' . urlencode($hwID) . '"><img class="img-responsive" src="images/project-4.jpg" alt=""></a>';
            echo '    <div class="blog-text expired">';
            echo '      <h3><a href="./php/selecthomework2.php?homework_id=' . urlencode($hwID) . '">' . htmlspecialchars($hwName) . '</a></h3>';
            echo '      <span class="posted_on">繳交題目數</span> ' . $questionCount . '/' . $hwsum . ' <i class="icon-open-book"></i>';
            echo '      <p>期限：' . $formattedDeadline . '</p>';
            echo '      <a href="./php/selecthomework2.php?homework_id=' . urlencode($hwID) . '" class="btn btn-primary">查看分數與回饋</a>';

        }
        echo '    </div>';
        echo '  </div>';
        echo '</div>';
    }

    // 渲染未過期作業
    // 渲染未過期作業
    echo '<h2>未過期作業</h2>';
    if (empty($upcoming_homeworks)) {
        echo "<p>無作業。</p>";
    } else {
        foreach ($upcoming_homeworks as $hw) {
            renderHomeworkCard($hw, $studentID, $conn, $now);
        }
    }

    // 渲染已過期作業
    echo '<h2>已過期作業</h2>';
    if (empty($expired_homeworks)) {
        echo "<p>無作業。</p>";
    } else {
        foreach ($expired_homeworks as $hw) {
            renderHomeworkCard($hw, $studentID, $conn, $now);
        }
    }


} else {
    echo "<p>尚未建立作業。</p>";
}

$conn->close();
?>
