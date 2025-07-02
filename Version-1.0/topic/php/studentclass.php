<?php

$studentID = $_SESSION['UserID']; 

$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

// 取得學生所有加入的班級
$sql = "SELECT ClassID FROM student WHERE StudentID = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $studentID);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $classID = $row['ClassID'];

        // 查詢該班級詳細資料
        $sql1 = "SELECT * FROM classes WHERE ClassID = ?";
        $stmt1 = $conn->prepare($sql1);
        $stmt1->bind_param("s", $classID);
        $stmt1->execute();
        $result1 = $stmt1->get_result();

        if ($result1 && $result1->num_rows > 0) {
            while ($row1 = $result1->fetch_assoc()) {
                echo '<div class="col-lg-4 col-md-4">';
                echo '  <div class="fh5co-blog animate-box">';
                echo '    <a href="#"><img class="img-responsive" src="images/project-4.jpg" alt=""></a>';
                echo '    <div class="blog-text">';
                echo '      <h3><a href="#">' . htmlspecialchars($row1['Name']) . '</a></h3>';

                // 查詢教師姓名
                $teacherID = $row1['TeacherID'];
                $sql2 = "SELECT FirstName, LastName FROM users WHERE UserID = ?";
                $stmt2 = $conn->prepare($sql2);
                $stmt2->bind_param("s", $teacherID);
                $stmt2->execute();
                $result2 = $stmt2->get_result();

                if ($result2 && $teacher = $result2->fetch_assoc()) {
                    echo '      <p>教師名稱: ' . htmlspecialchars($teacher['FirstName'] . '' . $teacher['LastName']) . '</p>';
                } else {
                    echo '      <p>教師資料查無</p>';
                }

                echo '      <a href="./php/selectclass1.php?class_id=' . urlencode($row1['ClassID']) . '" class="btn btn-primary">進入課程</a>';
                echo '    </div>';
                echo '  </div>';
                echo '</div>';
            }
        } else {
            echo "<p>查無班級資料 (ClassID: " . htmlspecialchars($classID) . ")</p>";
        }
    }
} else {
    echo "<p>你尚未加入任何課程。</p>";
}

$conn->close();
?>
