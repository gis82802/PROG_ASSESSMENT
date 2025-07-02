<?php
session_start();
// 確保登入狀態
if (!isset($_SESSION['UserID'])) {
    echo "<h3 style='color:red;'>請先登入才能申請課程。</h3>";
    exit();
}

$studentID = $_SESSION['UserID'];

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $classid = trim($_POST['classid']);

    if (empty($classid)) {
        echo "<h3 style='color:red;'>請輸入課程代碼。</h3>";
    } else {
        $conn = new mysqli("localhost", "root", "", "topic");
        if ($conn->connect_error) {
            die("連線失敗: " . $conn->connect_error);
        }

        $stmt1 = $conn->prepare("SELECT * FROM student WHERE ClassID = ? AND StudentID = ?");
        $stmt1->bind_param("ss", $classid, $studentID);
        $stmt1->execute();
        $result1 = $stmt1->get_result();
        if ($result1->num_rows > 0) {
            echo "<h3 style='color:red;'>已是課程成員。</h3>";
            exit();
        }
        // 檢查是否已經申請過
        $stmt = $conn->prepare("SELECT * FROM waitjoinclass WHERE ClassID = ? AND StudentID = ?");
        $stmt->bind_param("ss", $classid, $studentID);
        $stmt->execute();
        $result = $stmt->get_result();
        if ($result->num_rows > 0) {
            echo "<h3 style='color:red;'>已經申請過此課程，請勿重複申請。</h3>";
        } else {
            // 取得課程老師 ID
            $stmt2 = $conn->prepare("SELECT * FROM classes WHERE ClassID = ?");
            $stmt2->bind_param("s", $classid);
            $stmt2->execute();
            $result2 = $stmt2->get_result();

            if ($row = $result2->fetch_assoc()) {
                $teacherID = $row['TeacherID'];
                $classname = $row['Name'];

                // 插入申請資料
                $stmt3 = $conn->prepare("INSERT INTO waitjoinclass (StudentID, TeacherID, ClassID) VALUES (?, ?, ?)");
                $stmt3->bind_param("sss", $studentID, $teacherID, $classid);

                if ($stmt3->execute()) {
                    echo "<h3 style='color:green;'>已成功申請課程：{$classname}</h3>";
                } else {
                    echo "<h3 style='color:red;'>申請失敗，請稍後再試。</h3>";
                }
            } else {
                echo "<h3 style='color:red;'>課程不存在，請確認課程代碼。</h3>";
            }
        }

        $conn->close();
    }
}
?>
