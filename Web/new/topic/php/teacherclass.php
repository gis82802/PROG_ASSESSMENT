<!DOCTYPE html>
<html lang="zh-Hant">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>教師平台</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> 

    <style>
        /* 為所有帶有 'chart-canvas-border' class 的 canvas 元素添加外框線 */
        .chart-canvas-border {
            border: 1px solid #ddd; /* 邊框：1像素寬，實線，淺灰色 */
            border-radius: 8px;    /* 圓角：8像素，讓邊框看起來更柔和 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 輕微的陰影，增加立體感 */
            padding: 10px;         /* 內邊距：圖表內容與邊框之間的距離 */
            background-color: #fff; /* 背景色：如果canvas有透明部分，會看到這個顏色 */
        }
    </style>

</head>
<body>
    <?php
    // 只有在會話尚未啟動時才啟動會話
    if (session_status() === PHP_SESSION_NONE) {
        session_start();
    }

    $teacherID = $_SESSION['UserID'] ?? null; // 使用 null 合併運算符安全地獲取 UserID

    // 檢查 $teacherID 是否存在，如果沒有則導向登入頁面
    if (empty($teacherID)) {
        header("Location: ../index.php"); // 假設登入頁在上一級目錄的 index.php
        exit();
    }

    // 資料庫連線
    $conn = new mysqli("localhost", "root", "", "topic");

    // 檢查連線是否成功
    if ($conn->connect_error) {
        // 顯示更友善的錯誤訊息，在正式環境中應記錄日誌而非直接顯示給使用者
        die("資料庫連線失敗，請稍後再試。錯誤: " . $conn->connect_error);
    }

    // 查詢老師開設的課程 - 使用預處理語句以提高安全性
    $sql = "SELECT ClassID, Name FROM classes WHERE TeacherID = ?";
    $stmt = $conn->prepare($sql);

    if ($stmt === false) {
        die("SQL 預處理失敗: " . $conn->error);
    }

    $stmt->bind_param("s", $teacherID); // "s" 表示 teacherID 是字串類型
    $stmt->execute();
    $result = $stmt->get_result();

    // 檢查是否有課程資料
    if ($result->num_rows > 0) {
        // 遍歷每門課程
        while ($row = $result->fetch_assoc()) {
            $classID = $row['ClassID']; // 獲取當前課程的 ClassID

            // --- 開始獲取並處理該課程的學生的平均分數數據以繪製直方圖 ---
            // 定義分數區間的標籤
            $chartLabels = ['0-59', '60-69', '70-79', '80-89', '90-99', '100'];
            // 初始化每個分數區間的人數計數，索引對應 $chartLabels
            $scoreBins = array_fill(0, count($chartLabels), 0);

            // *** 修改後的 SQL 查詢：計算每個學生的平均成績 ***
            $sqlClassScores = "SELECT AVG(r.Score) AS AverageScore 
                            FROM results r
                            JOIN student s ON r.StudentID = s.StudentID
                            WHERE s.ClassID = ?
                            GROUP BY s.StudentID"; // 按學生分組，計算平均分
            
            $stmtClassScores = $conn->prepare($sqlClassScores);
            if ($stmtClassScores === false) {
                // 在生產環境中應記錄錯誤而不是終止
                error_log("SQL 預處理失敗 (課程平均分數查詢): " . $conn->error);
                // 繼續執行但圖表數據為空
                $scoreBins = array_fill(0, count($chartLabels), 0); 
            } else {
                $stmtClassScores->bind_param("s", $classID);
                $stmtClassScores->execute();
                $resultClassScores = $stmtClassScores->get_result();

                if ($resultClassScores->num_rows > 0) {
                    while ($scoreRow = $resultClassScores->fetch_assoc()) {
                        // *** 這裡現在獲取的是 AverageScore ***
                        $score = (int)$scoreRow['AverageScore']; // 將平均分數轉換為整數

                        // 根據分數將其歸類到對應的 bin
                        if ($score >= 0 && $score <= 59) {
                            $scoreBins[0]++; // 0-59
                        } elseif ($score >= 60 && $score <= 69) {
                            $scoreBins[1]++; // 60-69
                        } elseif ($score >= 70 && $score <= 79) {
                            $scoreBins[2]++; // 70-79
                        } elseif ($score >= 80 && $score <= 89) {
                            $scoreBins[3]++; // 80-89
                        } elseif ($score >= 90 && $score <= 99) {
                            $scoreBins[4]++; // 90-99
                        } elseif ($score == 100) {
                            $scoreBins[5]++; // 100
                        }
                        // 忽略無效分數
                    }
                }
                $stmtClassScores->close(); // 關閉分數查詢的預處理語句
            }
            // --- 結束獲取並處理分數數據 ---

            echo '<div class="col-lg-4 col-md-4">';
            echo '  <div class="fh5co-blog animate-box">';
            
            // 替換圖片為 Chart.js 的 Canvas 元素
            // 為每個班級的圖表創建一個獨特的 ID，並加上 class 以便 CSS 樣式
            $canvasId = "classScoreDistChart_" . $classID; 
            echo "<canvas id='$canvasId' class='chart-canvas-border' width='300' height='200'></canvas>"; // 這裡設定了圖表的寬高

            // 輸出 Chart.js 的 JavaScript 程式碼
            echo "<script>
                document.addEventListener('DOMContentLoaded', function() {
                    const ctx = document.getElementById('$canvasId').getContext('2d');
                    new Chart(ctx, {
                        type: 'bar', // 設定圖表類型為長條圖（直方圖常用）
                        data: {
                            labels: " . json_encode($chartLabels) . ", // X 軸標籤（分數區間）
                            datasets: [
                                {
                                    label: '學生人數', // 資料集標籤
                                    data: " . json_encode($scoreBins) . ", // 各區間的人數數據
                                    backgroundColor: 'rgba(54, 162, 235, 0.6)', // 長條背景色
                                    borderColor: 'rgba(54, 162, 235, 1)', // 長條邊框色
                                    borderWidth: 1 // 邊框寬度
                                }
                            ]
                        },
                        options: {
                            responsive: true, // 讓圖表響應式調整大小
                            maintainAspectRatio: false, // 允許手動設定寬高，不自動維持比例
                            plugins: {
                                legend: {
                                    display: false // 如果只有一個數據集，可以選擇不顯示圖例
                                },
                                title: {
                                    display: true, // 顯示圖表標題
                                    // 注意標題變更為「平均成績分佈」
                                    text: '" . htmlspecialchars($row['Name']) . " - 平均成績分佈' 
                                }
                            },
                            scales: {
                                x: { // X 軸設定
                                    title: {
                                        display: true, // 顯示 X 軸標題
                                        text: '平均分數區間' // X 軸標題文字變更
                                    }
                                },
                                y: { // Y 軸設定
                                    beginAtZero: true, // Y 軸從 0 開始
                                    ticks: {
                                        precision: 0, // 刻度值不顯示小數點
                                        stepSize: 1 // 刻度步進為 1，適合顯示人數
                                    },
                                    title: {
                                        display: true, // 顯示 Y 軸標題
                                        text: '人數', // Y 軸標題文字
                                        font: {
                                            size: 14 // Y 軸標題字體大小
                                        }
                                    }
                                }
                            }
                        }
                    });
                });
                </script>";

            echo '    <div class="blog-text">';
            echo '      <h3><a href="#">' . htmlspecialchars($row['Name']) . '</a></h3>';
            echo '      <span class="posted_on">學生數:</span>';
            
            // 查詢該課程的學生數 - 仍然使用預處理語句
            $sql1 = "SELECT COUNT(*) AS student_count FROM student WHERE ClassID = ?";
            $stmt1 = $conn->prepare($sql1);

            if ($stmt1 === false) {
                error_log("SQL 預處理失敗 (學生數查詢): " . $conn->error);
                $studentCount = 0; // 預設為0
            } else {
                $stmt1->bind_param("s", $row['ClassID']);
                $stmt1->execute();
                $result1 = $stmt1->get_result();
                $studentCount = 0;
                if ($result1->num_rows > 0) {
                    $countRow = $result1->fetch_assoc();
                    $studentCount = $countRow['student_count'];
                }
                $stmt1->close(); // 關閉學生數的預處理語句
            }

            echo '      <span class="comment"><a href="#">' . $studentCount . ' <i class="icon-man"></i></a></span>';
            echo '      <p></p>';
            echo '      <a href="./php/selectclass.php?class_id=' . urlencode($row['ClassID']) . '" class="btn btn-primary">進入課程</a>';
            echo '    </div>';
            echo '  </div>';
            echo '</div>';
        }
    } else {
        echo '<p>目前沒有課程。</p>'; // 如果沒有課程，則顯示此訊息
    }

    $stmt->close(); // 關閉課程查詢的預處理語句
    $conn->close(); // 關閉資料庫連線
    ?>
</body>
</html>

