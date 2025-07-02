<!DOCTYPE html>
<html lang="zh-Hant">
    <?php
		session_start();
		// 資料庫連線
		$conn = new mysqli("localhost", "root", "", "topic");
		if ($conn->connect_error) {
			$conn->close();
			header("Location: ../index.php");
			die("連線失敗: " . $conn->connect_error);
		}

		$homeworkID = $_SESSION['selected_homework_id'];

		$sql = "SELECT HomeworkName FROM homeworkslist WHERE HomeworkID = '$homeworkID'";
		$result = $conn->query($sql);

		if ($result->num_rows === 1) {
			$row = $result->fetch_assoc();
			$homeworkName = $row['HomeworkName']; 
		} else {
			$conn->close();
			header("Location: ../index.php");
		}

		$conn->close();
	?>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<title><?php echo $homeworkName; ?></title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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
</head>
<body>
    <?php
		// 資料庫連線
		$conn = new mysqli("localhost", "root", "", "topic");
		if ($conn->connect_error) {
			header("Location: ../index.php");
			die("連線失敗: " . $conn->connect_error);
		}

		$userid = $_SESSION['UserID'];

		// 查詢該 UserID 對應的姓名
		$sql = "SELECT FirstName, LastName FROM users WHERE UserID = '$userid'";
		$result = $conn->query($sql);

		$fullname = "";
		if ($result->num_rows === 1) {
			$row = $result->fetch_assoc();
			$fullname = $row['FirstName'] . $row['LastName']; // 姓在前
		} else {
			header("Location: ../index.php");
		}

		$conn->close();
	?>
    <div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-right">
						<p class="num"><?php echo $fullname; ?></p>
						<ul class="fh5co-social">
							<li><a href="index.php">登出</i></a></li>
						</ul>
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
							<li class="btn-cta"><a href="studentclass.php"><span>返回</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-bgm" role="banner" style="background-image:url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
		
	</header>
	<div class="container center-container">
    <div class="upload-box text-center">
        <h2 class="mb-4">LLM評分</h2>
		<p></p>
        <?php

        // 顯示錯誤訊息
        if (isset($_SESSION['error'])) {
            echo '<p style="color:red; text-align:center;">' . $_SESSION['error'] . '</p>';
            unset($_SESSION['error']);
        }

        // 連接資料庫
        $conn = new mysqli("localhost", "root", "", "topic");
        if ($conn->connect_error) {
            die("連線失敗: " . $conn->connect_error);
        }

        $homeworkID = $_SESSION['selected_homework_id'] ?? null;
        if (!$homeworkID) {
            echo "<p style='color:red;'>找不到作業 ID</p>";
            exit;
        }

        $sql = "SELECT * FROM homeworkslist WHERE HomeworkID = '$homeworkID'";
        $result = $conn->query($sql);
        if (!$result || $result->num_rows === 0) {
            echo "<p style='color:red;'>查無此作業</p>";
            exit;
        }

        $row = $result->fetch_assoc();
        for ($i = 1; $i <= $row['QuestionSum']; $i++) {
			echo '<div style="text-align:left; white-space:pre-wrap; line-height:1.2;">';
			echo "<h3>第 $i 題</h3>";

			// 取得當前學生該題的分數
			$sql = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$i' AND LLM = '0'";
			$resultScore = $conn->query($sql);

			if ($resultScore && $resultScore->num_rows > 0) {
				$rowScore = $resultScore->fetch_assoc();
				$currentScore = $rowScore['score'];
				echo "<p>Gemini 分數：$currentScore</p>";

				// 查詢同一題所有學生的分數
				$sqlAll = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND Question = '$i' AND LLM = '0'";
				$resultAll = $conn->query($sqlAll);

				if ($resultAll && $resultAll->num_rows > 1) {
					$scores = [];
					while ($rowAll = $resultAll->fetch_assoc()) {
						$scores[] = floatval($rowAll['score']);
					}

					$total = count($scores);
					$lower = 0;
					foreach ($scores as $s) {
						if ($s < $currentScore) {
							$lower++;
						}
					}
					if($lower == 0){
						$lower = 1;
					}
					$pr = ($lower / $total) * 100;
					$pr = round($pr, 2); // 四捨五入至小數第2位
					echo "<p>PR 值：$pr</p>";
				} else {
					echo "<p>無法計算 PR 值（沒有其他學生資料）</p>";
				}

			} else {
				echo "<p>Gemini 分數：尚未評分</p>";
			}

			$sql = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$i' AND LLM = '1'";
			$resultScore = $conn->query($sql);

			if ($resultScore && $resultScore->num_rows > 0) {
				$rowScore = $resultScore->fetch_assoc();
				$currentScore = $rowScore['score'];
				echo "<p>Mistral 分數：$currentScore</p>";

				// 查詢同一題所有學生的分數
				$sqlAll = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND Question = '$i' AND LLM = '1'";
				$resultAll = $conn->query($sqlAll);

				if ($resultAll && $resultAll->num_rows > 1) {
					$scores = [];
					while ($rowAll = $resultAll->fetch_assoc()) {
						$scores[] = floatval($rowAll['score']);
					}

					$total = count($scores);
					$lower = 0;
					foreach ($scores as $s) {
						if ($s < $currentScore) {
							$lower++;
						}
					}
					if($lower == 0){
						$lower = 1;
					}
					$pr = ($lower / $total) * 100;
					$pr = round($pr, 2); // 四捨五入至小數第2位
					echo "<p>PR 值：$pr</p>";
				} else {
					echo "<p>無法計算 PR 值（沒有其他學生資料）</p>";
				}

			} else {
				echo "<p>Mistral 分數：尚未評分</p>";
			}

			echo "</div><hr>";
		}


		
        $conn->close();
        ?>
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


    </div>
</div>

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
</body>
</html>

