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

		$sql = "SELECT * FROM homeworkslist WHERE HomeworkID = '$homeworkID'";
		$result = $conn->query($sql);

		if ($result->num_rows === 1) {
			$row = $result->fetch_assoc();
			$homeworkName = $row['HomeworkName']; 
			$homeworkdeadline = $row['Deadline']; 
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
  	<!-- Facebook and 
	  integration -->
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
						<a href="student.php"><img src="./images/NFU_Logo.png" alt="LOGO" style="height: 50px;"></a>
					</div>
					<div class="col-xs-11 text-right menu-1">
						<ul>
							<?php
								$now = new DateTime();
								if ($now < $homeworkdeadline) {
									echo '      <li class="btn-cta"><a href="./php/selecthomework.php?homework_id=' . urlencode($homeworkID) . '" class="btn btn-primary"><span>繳交作業</span></a></li>';
								}
							?>
							<li class="btn-cta"><a href="studentclass.php"><span>返回</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-bgm" role="banner" style="background-image:url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
		
	</header>
	<style>
	.feedback-box {
		line-height: 1.3;
		font-size: 14px;
		margin-top: 5px;
	}
	.feedback-sidebar {
		max-height: 600px;
		overflow-y: auto;
		border-right: 1px solid #ccc;
		padding-right: 10px;
	}
	.feedback-sidebar ul {
		list-style-type: none;
		padding: 0;
	}
	.feedback-sidebar li {
		padding: 6px 10px;
		cursor: pointer;
	}
	.feedback-sidebar li:hover {
		background-color: #f0f0f0;
	}
	</style>

	<div class="container">
		<div class="row">
			<!-- 左側選單 -->
			<div class="col-md-3 feedback-sidebar">
				<ul>
					<?php
					$conn = new mysqli("localhost", "root", "", "topic");
					if ($conn->connect_error) die("連線失敗: " . $conn->connect_error);

					$homeworkID = $_SESSION['selected_homework_id'] ?? null;
					$userid = $_SESSION['UserID'] ?? null;
					if (!$homeworkID || !$userid) {
						echo "<p style='color:red;'>找不到作業 ID 或學生 ID</p>";
						exit;
					}

					$sql = "SELECT * FROM homeworkslist WHERE HomeworkID = '$homeworkID'";
					$result = $conn->query($sql);
					if (!$result || $result->num_rows === 0) {
						echo "<p style='color:red;'>查無此作業</p>";
						exit;
					}

					$sqlScore = "SELECT Score FROM final WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid'";
					$resultScore = $conn->query($sqlScore);

					if ($resultScore) {
						if ($resultScore->num_rows > 0) {
							$rowScore = $resultScore->fetch_assoc();
							echo "<h2>實際作業分數：{$rowScore['Score']}</h2>";
						} else {
							echo "<h2>實際作業分數：教師尚未評分</h2>";
						}
					} else {
						echo "<h4>SQL 查詢錯誤: " . $conn->error . "</h4>";
					}
					

					echo"<h4>選擇題目與模型</h4>";
					$row = $result->fetch_assoc();
					for ($i = 1; $i <= $row['QuestionSum']; $i++) {
						foreach (["Gemini", "Mistral"] as $model) {
							$modelCode = ($model == "Gemini") ? 0 : 1;

							// 查詢該題該模型的分數
							$sqlScore = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$userid' AND Question = '$i' AND LLM = '$modelCode'";
							$resultScore = $conn->query($sqlScore);

							$scoreDisplay = "尚未評分";
							$prDisplay = "";

							if ($resultScore && $resultScore->num_rows > 0) {
								$rowScore = $resultScore->fetch_assoc();
								$currentScore = $rowScore['score'];
								$scoreDisplay = "模型評分：$currentScore";

								// PR 值計算
								$sqlAll = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND Question = '$i' AND LLM = '$modelCode'";
								$resultAll = $conn->query($sqlAll);

								if ($resultAll && $resultAll->num_rows > 1) {
									$scores = [];
									while ($rowAll = $resultAll->fetch_assoc()) {
										$scores[] = floatval($rowAll['score']);
									}
									$lower = count(array_filter($scores, fn($s) => $s < $currentScore));
									$lower = max(1, $lower); // 至少是 1
									$pr = round(($lower / count($scores)) * 100, 2);
									$prDisplay = "PR：$pr";
								}
							}

							echo "<li onclick=\"showFeedback('Q{$i}_{$model}')\">第 {$i} 題 - {$model}<br><small>$scoreDisplay<br>$prDisplay</small></li>";
						}
					}
					?>
				</ul>
			</div>

			<!-- 右側內容區 -->
			<div class="col-md-9">
				<h3><br>回饋與評分</h3>
				<?php
				for ($i = 1; $i <= $row['QuestionSum']; $i++) {
					foreach (["Gemini", "Mistral"] as $model) {
						$modelCode = ($model == "Gemini") ? 0 : 1;
						$fid = "Q{$i}_{$model}";
						$filepath = "C:/xampp/htdocs/topic/data/" . $row['ClassID'] . "/" . $homeworkID . "/feedback/" . $userid . "/Q{$i}_{$model}_feedback.txt";
						echo "<div id='content_{$fid}' class='feedback-box' style='display:none'>";
						echo "<h4>第 {$i} 題 - {$model} Feedback</h4>";
						if (file_exists($filepath)) {
							$content = file_get_contents($filepath);
							$pos = strpos($content, "1.");
							$feedback = ($pos !== false) ? substr($content, $pos + 2) : $content;
							echo '<pre style="white-space: pre-wrap;">' . htmlspecialchars($feedback) . '</pre>';
						} else {
							echo "<p>尚未繳交作業</p>";
						}
						echo "</div>";
					}
				}

				$conn->close();
				?>
			</div>

		</div>
	</div>

	<script>
	function showFeedback(id) {
		const boxes = document.querySelectorAll('.feedback-box');
		boxes.forEach(b => b.style.display = 'none');
		document.getElementById('content_' + id).style.display = 'block';
	}
	</script>

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

