<!DOCTYPE HTML>
<html>
	<?php
        session_start();

        // 檢查是否有成功訊息
        if (isset($_SESSION['success'])) {
            echo "<script>alert('" . $_SESSION['success'] . "');</script>";
            unset($_SESSION['success']);  // 顯示完後刪除訊息
        }

        // 檢查是否有錯誤訊息
        if (isset($_SESSION['error'])) {
            echo "<script>alert('" . $_SESSION['error'] . "');</script>";
            unset($_SESSION['error']);  // 顯示完後刪除訊息
        }

        // --- 資料庫連線 (只連接一次，並處理錯誤) ---
        $conn = new mysqli("localhost", "root", "", "topic");
        if ($conn->connect_error) {
            header("Location: ../index.php"); // 連線失敗，導向首頁
            die("連線失敗: " . $conn->connect_error);
        }

        // --- 初始化變數 (避免未定義警告) ---
        $ClassName = "";
        $fullname = "";
        $resultStudents = null; // 初始化為 null，以便後續檢查

        // --- 1. 獲取班級名稱 (ClassID 來自 session) ---
        if (isset($_SESSION['selected_class_id'])) {
            $classID = $_SESSION['selected_class_id'];
            $sql_class_name = "SELECT Name FROM classes WHERE ClassID = ?";
            $stmt_class_name = $conn->prepare($sql_class_name);

            if ($stmt_class_name) {
                $stmt_class_name->bind_param("s", $classID);
                $stmt_class_name->execute();
                $result_class_name = $stmt_class_name->get_result();

                if ($result_class_name->num_rows === 1) {
                    $row = $result_class_name->fetch_assoc();
                    $ClassName = $row['Name'];
                } else {
                    $_SESSION['error'] = "班級資訊錯誤，請重新選擇。";
                    $conn->close();
                    header("Location: ../index.php");
                    exit(); // 停止腳本執行
                }
                $stmt_class_name->close();
            } else {
                $_SESSION['error'] = "資料庫準備語句失敗：獲取班級名稱。";
                $conn->close();
                header("Location: ../index.php");
                exit();
            }
        } else {
            $_SESSION['error'] = "未選擇班級，請返回主頁選擇。";
            $conn->close();
            header("Location: ../index.php");
            exit();
        }

        // --- 2. 抓取該班級成員資料 (使用 $resultStudents 變數) ---

		$sql_students = "
			SELECT u.FirstName, u.LastName, u.UserID AS StudentID, u.Email
			FROM student s
			JOIN users u ON s.StudentID = u.UserID
			WHERE s.ClassID = ?
			ORDER BY u.Email ASC
		";
        $stmt_students = $conn->prepare($sql_students);

        if ($stmt_students) {
            $stmt_students->bind_param("s", $classID);
            $stmt_students->execute();
            $resultStudents = $stmt_students->get_result(); // 將結果存入 $resultStudents
            $stmt_students->close();
        } else {
            $_SESSION['error'] = "資料庫準備語句失敗：獲取班級成員。";
            // 這裡不立即停止，讓頁面繼續載入但學生列表可能為空
        }

        // --- 3. 獲取登入使用者名稱 (UserID 來自 session) ---
        if (isset($_SESSION['UserID'])) {
            $userid = $_SESSION['UserID'];
            $sql_user_name = "SELECT FirstName, LastName FROM users WHERE UserID = ?";
            $stmt_user_name = $conn->prepare($sql_user_name);

            if ($stmt_user_name) {
                $stmt_user_name->bind_param("s", $userid);
                $stmt_user_name->execute();
                $result_user_name = $stmt_user_name->get_result();

                if ($result_user_name->num_rows === 1) {
                    $row = $result_user_name->fetch_assoc();
                    $fullname = $row['FirstName'] . $row['LastName'];
                } else {
                    $_SESSION['error'] = "使用者資訊錯誤，請重新登入。";
                    $conn->close();
                    header("Location: ../index.php");
                    exit();
                }
                $stmt_user_name->close();
            } else {
                $_SESSION['error'] = "資料庫準備語句失敗：獲取使用者名稱。";
                $conn->close();
                header("Location: ../index.php");
                exit();
            }
        } else {
            $_SESSION['error'] = "未登入，請先登入。";
            $conn->close();
            header("Location: ../index.php");
            exit();
        }

        // --- 所有資料庫操作完成後，關閉連接 ---
        $conn->close();
	?>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> <!--確保使用最新的渲染模式-->
		<title><?php echo $ClassName; ?></title>
		<meta name="viewport" content="width=device-width, initial-scale=1"> <!--適配不同裝置的螢幕寬度-->
  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="fh5co-loader"><div class="loader-text">作業批改中，請稍候...</div></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-right">
                        <p class="num"><?php echo htmlspecialchars($fullname); ?></p>
						<ul class="fh5co-social">
							<li><a href="index.php">登出</i></a></li>
						</ul>
						<!--<p class="course-id">課程代號: <?php echo $classID; ?></p>-->
					</div>
				</div>
			</div>
		</div>

		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-xs-1">
						<a href="teacher.php"><img src="./images/NFU_Logo.png" alt="LOGO" style="height: 50px;"></a>
					</div>
					<div class="col-xs-11 text-right menu-1">
                        <ul>
                            <li class="has-dropdown active">
                                <a href="#">成員管理</a>
                                <ul class="dropdown">
                                    <li><a href="javascript:void(0);" data-modal="modal0">班級成員</a></li>
                                    <li><a href="javascript:void(0);" class="openModalBtn" data-modal="modal1">成員匯入</a></li>
                                    <li><a href="./joinpass.php">成員審核</a></li>
                                </ul>
							</li>
							<li class="btn-cta"><a href="javascript:void(0);" class="openModalBtn" data-modal="modal4"><span>建立作業</span></a></li>
							<li class="btn-cta"><a href="javascript:void(0);" class="openModalBtn" data-modal="modal5"><span>匯入作業</span></a></li>
							<li class="btn-cta"><a href="./php/outputscorecsv.php"><span>匯出分數</span></a></li>
							<li class="btn-cta"><a href="./teacher.php"><span>返回</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-bgm" role="banner" style="background-image:url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
		
	</header>

	<div id="fh5co-blog">
		<div class="container">
			<div class="row">
				<?php include 'php/teacherhomework.php'; ?>
			</div>
		</div>
	</div>
	
	<!-- 這是彈跳視窗 -->
    <div id="modal0" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>班級成員</h2>
        <div class="scrollable-table-container"> <table class="table table-striped">
                <thead>
                    <tr>
                        <th>姓名</th>
						<th>學號</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    if ($resultStudents instanceof mysqli_result && $resultStudents->num_rows > 0) {
                        while ($row = $resultStudents->fetch_assoc()): ?>
                            <tr>
                                <td><?php echo htmlspecialchars($row['FirstName'] . $row['LastName']); ?></td>
								<td><?php
										$studentID_full = htmlspecialchars($row['Email']);
										// 找到 '@' 符號的位置
										$atPos = strpos($studentID_full, '@');
										if ($atPos !== false) {
											// 如果找到 '@'，則取 '@' 之前的部分
											echo substr($studentID_full, 0, $atPos);
										} else {
											// 如果沒有 '@'，則顯示完整學號
											echo $studentID_full;
										}
									?>
								</td>
                            </tr>
                        <?php
                        endwhile;
                    } else {
                        echo "<tr><td colspan='2'>目前沒有班級成員。</td></tr>";
                    }
                    ?>
                </tbody>
            </table>
        </div>
	</div>
	</div>

	<div id="modal1" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>成員匯入</h2>
			<p>請下載此.csv檔案，並填入對應資料後上傳</p>
			<a href="php/generate_csv.php" class="btn btn-primary">下載範本</a>
			<br><br>
			<form action="php/import_members.php" method="post" enctype="multipart/form-data">
				<p>上傳 .csv 檔案：</p>
				<input type="file" name="csv_file" accept=".csv" required>
                <input type="hidden" name="classID" value="<?php echo htmlspecialchars($classID); ?>">
				<input type="submit" value="上傳" class="btn btn-primary">
			</form>

		</div>
	</div>

	<div id="modal2" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>作業詳細資料</h2>
			<p>這裡是作業的完整說明～</p>
		</div>
	</div>

	<div id="modal3" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>分數分析</h2>
			<p>所有做業平均折線圖</p>
		</div>
	</div>

	<div id="modal4" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>建立作業</h2>

			<form action="php/createhomework.php" method="POST">
				<label for="title">作業名稱：</label>
				<input type="text" id="title" name="title" required><br><br>

				<label for="deadline">繳交期限：</label>
				<input type="datetime-local" id="deadline" name="deadline" required><br><br>

				<label>小題設定：</label><br>
				<div id="subQuestionsContainer"></div>
				<button type="button" onclick="addSubQuestion()">➕ 新增小題</button>

				<div id="subQuestionsContainer"></div>

				<br><input type="submit" value="送出" class="btn btn-primary">
				<input type="hidden" id="subCount" name="subCount" value="0">
			</form>
		</div>
	</div>

	<div id="modal5" class="modal" style="display: none;">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>作業匯入</h2>
			<form action="php/import_homework.php" method="post" enctype="multipart/form-data">
			<p>上傳作業壓縮檔（僅限 .zip）：</p>
			<input type="file" name="homeworkZip" accept=".zip" required><br><br>
			<input type="submit" value="上傳" class="btn btn-primary">
			</form>
		</div>
	</div>

	<div id="modalclass" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal()">&times;</span>
			<h2>修改題目</h2>

			<!-- 顯示所有小題數量 -->
			<label for="questionSelect">選擇小題：</label>
			<select id="questionSelect" onchange="loadSubQuestion()" required>
				<option value="">-- 請選擇小題 --</option>
			</select>

			<!-- 編輯小題內容 -->
			<div id="editSubQuestionBlock" style="margin-top: 15px;">
				<label for="subQuestionText">小題內容：</label>
				<textarea id="subQuestionText" name="subQuestionText" rows="3" style="width:100%;"></textarea>
				<input type="hidden" name="subQuestionIndex" id="subQuestionIndex">
			</div>

			<br>

			<form method="POST" action="updateQuestion.php"> 
				<input type="submit" value="更新作業" class="btn btn-primary">
			</form>

			<form method="POST" action="updateQuestion.php"> 
				<input type="submit" value="刪除作業" class="btn btn-primary">
			</form>
		</div>
	</div>

	<script>
		document.addEventListener("DOMContentLoaded", function () {
			// 對所有表單綁定 submit 事件
			document.querySelectorAll("form").forEach(function (form) {
				form.addEventListener("submit", function () {
					// 顯示 loader 畫面
					document.querySelector(".fh5co-loader").style.display = "block";
					document.body.classList.add("loading");

					// 鎖定這個表單裡的按鈕，避免多次點擊
					const button = form.querySelector("button[type='submit']");
					if (button) button.disabled = true;
				});
			});
		});
	</script>


	<div class="col-md-12 text-center">
		<p>
			<small class="block">by 翁慧霖 </small> 
			<small class="block">張宇光</small> 
			<br>
			<small class="block">國立虎尾科技大學 資工系</small> 
		</p>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
	<script src="js/modal.js"></script>
	<script src="js/addhomework.js"></script>
	<script src="js/edithomework.js"></script>
	</body>
</html>

<script>
    // Modal 打開關閉 JS 代碼
    document.querySelectorAll('[data-modal]').forEach(el => {
        el.addEventListener('click', function(e){
            e.preventDefault();
            const modalId = this.getAttribute('data-modal');
            const modal = document.getElementById(modalId);
            if (modal) modal.style.display = 'block';
        });
    });

    document.querySelectorAll('.modal .close').forEach(el => {
        el.addEventListener('click', function(){
            this.closest('.modal').style.display = 'none';
        });
    });

    window.addEventListener('click', function(e){
        document.querySelectorAll('.modal').forEach(modal => {
            if (e.target === modal) {
                modal.style.display = 'none';
            }
        });
    });
</script>
</body>
</html>