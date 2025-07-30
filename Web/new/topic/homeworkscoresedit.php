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
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
							<li class="btn-cta"><a href="homeworkscores.php"><span>模型分數分析</span></a></li>
							<li class="btn-cta"><a href="teacherclass.php"><span>返回</span></a></li>
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
		input[type=number]::-webkit-inner-spin-button,
		input[type=number]::-webkit-outer-spin-button {
		-webkit-appearance: none;
		margin: 0;
		}

		input[type=number] {
		-moz-appearance: textfield;
		}
	</style>

	<div class="container">
		<div class="row">
			<!-- 左側學生清單 -->
			<div class="col-md-2 feedback-sidebar">
				<button class="btn btn-success mt-3" onclick="submitAllScores()">儲存分數</button>
				<ul>
					<?php
					$conn = new mysqli("localhost", "root", "", "topic");
					if ($conn->connect_error) die("連線失敗: " . $conn->connect_error);

					$homeworkID = $_SESSION['selected_homework_id'] ?? null;
					$userid = $_SESSION['UserID'] ?? null;
					$classID = $_SESSION['selected_class_id'] ?? null;

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
					$hwData = $result->fetch_assoc();

					$sql1 = "SELECT StudentID FROM student WHERE ClassID = '$classID'";
					$result1 = $conn->query($sql1);

					if ($result1->num_rows === 0) {
						echo "<p style='color:red;'>沒有成員</p>";
						exit;
					} else {
						echo "<h4><br>學生分數</h4>";
						$studentIDs = [];
						while ($row1 = $result1->fetch_assoc()) {
							$studentIDs[] = $row1['StudentID'];
						}
						foreach ($studentIDs as $studentID) {
							$sql3 = "SELECT FirstName, LastName FROM users WHERE UserID = '$studentID'";
							$result3 = $conn->query($sql3);
							$fullname = "";
							if ($result3 && $row3 = $result3->fetch_assoc()) {
								$fullname = $row3['FirstName'] . $row3['LastName'];
							}

							$sqlScore = "SELECT Score FROM final WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID'";
							$resultScore = $conn->query($sqlScore);

							if ($resultScore && $resultScore->num_rows > 0) {
								$rowScore = $resultScore->fetch_assoc();
								$placeholder = $rowScore['Score'];
							} else {
								$sqlavgScore = "SELECT AVG(score) AS avg_score FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$studentID'";
								$resultavgScore = $conn->query($sqlavgScore);
								$rowavgScore = $resultavgScore->fetch_assoc();
								$placeholder = intval($rowavgScore['avg_score']);
							}

							//echo "<li onclick=\"selectStudent('{$studentID}')\">{$fullname}
							echo "<li onclick=\"selectStudent('{$studentID}', this)\">{$fullname}
								<input type='number' min='0' max='100' step='1'
									class='form-control form-control-sm mt-1'
									style='width: 90px; font-size: 20px;'
									placeholder='$placeholder'
									onclick='event.stopPropagation();'
									onchange=\"saveScore('{$studentID}', this.value)\">
							</li>";
						}
						
					}
					?>
				</ul>
			</div>

			<!-- 中間 題號 + 模型 -->
			<div class="col-md-3 feedback-sidebar">
				<ul>
					<?php
					foreach ($studentIDs as $sid) {
						echo "<div id='content_{$sid}' class='question-list' style='display:none'>";
						echo "<h4><br>題號與模型</h4>";

						for ($i = 1; $i <= $hwData['QuestionSum']; $i++) {
							echo "<li onclick=\"showCode(currentStudentID, 'Q{$i}', this)\">第 {$i} 題 - 作業</li>";
							foreach (["Gemini", "Mistral"] as $model) {
								$fid = "Q{$i}_{$model}";
								$modelCode = ($model == "Gemini") ? 0 : 1;
								$sqlScorellm = "SELECT score FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$sid' AND Question = '$i' AND LLM = '$modelCode'";
								$resultScorellm = $conn->query($sqlScorellm);
								$scoreDisplay = "尚未評分";
								if ($resultScorellm && $resultScorellm->num_rows > 0) {
									$rowScorellm = $resultScorellm->fetch_assoc();
									$currentScore = $rowScorellm['score'];
									$scoreDisplay = "($currentScore)";
								}
								echo "<li onclick=\"showFeedback(currentStudentID, 'Q{$i}', '{$model}', this)\">第 {$i} 題 - {$model}回饋{$scoreDisplay}</li>";
							}
						}

						// 顯示該學生的平均分
						$sqlavgScore = "SELECT AVG(score) AS avg_score FROM results WHERE HomeworkID = '$homeworkID' AND StudentID = '$sid'";
						$resultavgScore = $conn->query($sqlavgScore);
						$rowavgScore = $resultavgScore->fetch_assoc();
						$avgscoreall = intval($rowavgScore['avg_score']);
						echo "<h4><br>模型平均分：{$avgscoreall}</h4>";

						echo "</div>"; // 移到這裡來正確關閉每位學生的區塊
					}

					?>
				</ul>
			</div>

			<!-- 右側 Feedback 顯示 -->
			<div class="col-md-7">
				<?php
				foreach ($studentIDs as $sid) {
					for ($i = 1; $i <= $hwData['QuestionSum']; $i++) {
						$codePath = "C:/xampp/htdocs/topicbee/data/" . $hwData['ClassID'] . "/$homeworkID/homework/$sid/Q{$i}/";
						$questionPath = "C:/xampp/htdocs/topicbee/data/" . $hwData['ClassID'] . "/$homeworkID/homework_texts/Q{$i}.txt";  

						if (file_exists($questionPath)) {
							$questionText = file_get_contents($questionPath);
						} else {
							$questionText = "無題目內容";
						}

						$sql3 = "SELECT FirstName, LastName FROM users WHERE UserID = '$sid'";
							$result3 = $conn->query($sql3);
							$fullname = "";
							if ($result3 && $row3 = $result3->fetch_assoc()) {
								$fullname = $row3['FirstName'] . $row3['LastName'];
							}

						echo "<div id='code_{$sid}_Q{$i}' class='feedback-box' style='display:none'>";
						echo "<br><h2>{$fullname} 的 第 {$i} 題 作業與題目</h2>";
						echo "<strong>題目：</strong><pre style='white-space: pre-wrap;'>" . htmlspecialchars($questionText) . "</pre>";

						$files = glob($codePath . "*.*");
						if ($files && file_exists($files[0])) {
							$code = file_get_contents($files[0]);
							echo "<strong>程式碼：</strong><pre style='background-color: #f9f9f9; padding:10px;'>" . htmlspecialchars($code) . "</pre>";
						} else {
							echo "<p>尚未繳交作業</p>";
						}
						echo "</div>";
					}
				}
				?>
				<?php
				foreach ($studentIDs as $sid) {
					for ($i = 1; $i <= $hwData['QuestionSum']; $i++) {
						foreach (["Gemini", "Mistral"] as $model) {
							$fid = "Q{$i}_{$model}";
							$modelCode = ($model == "Gemini") ? 0 : 1;
							$filepath = "C:/xampp/htdocs/topicbee/data/" . $hwData['ClassID'] . "/$homeworkID/feedback/$sid/{$fid}_feedback.txt";
							$sql3 = "SELECT FirstName, LastName FROM users WHERE UserID = '$sid'";
							$result3 = $conn->query($sql3);
							$fullname = "";
							if ($result3 && $row3 = $result3->fetch_assoc()) {
								$fullname = $row3['FirstName'] . $row3['LastName'];
							}

							echo "<div id='content_{$sid}_{$fid}' class='feedback-box' style='display:none'>";
							echo "<h3><br>回饋與評分</h3>";
							echo "<h4>{$fullname} 的 第 {$i} 題 - {$model} 回饋</h4>";

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
				}
				$conn->close();
				?>
			</div>
		</div>
	</div>

	<script>
		let currentStudentID = "";

		function selectStudent(studentID, element) {
			currentStudentID = studentID;

			document.querySelectorAll('.feedback-sidebar:nth-child(1) li').forEach(li => {
				li.classList.remove('active');
			});
			element.classList.add('active');

			// 顯示學生的題號列表
			document.querySelectorAll('.question-list').forEach(list => {
				list.style.display = 'none';
			});
			const questionList = document.getElementById(`content_${studentID}`);
			if (questionList) {
				questionList.style.display = 'block';
			}

			// 隱藏所有詳細回饋
			document.querySelectorAll('.feedback-box').forEach(box => {
				box.style.display = 'none';
			});

			// 清除中間欄 active
			document.querySelectorAll('.feedback-sidebar:nth-child(2) li').forEach(li => {
				li.classList.remove('active');
			});
		}

		function showFeedback(studentID, question, model, element) {
			if (!studentID) {
				alert("請先選擇一位學生！");
				return;
			}

			// 中間欄 active 狀態切換
			document.querySelectorAll('.feedback-sidebar:nth-child(2) li').forEach(li => {
				li.classList.remove('active');
			});
			element.classList.add('active');

			// 隱藏所有詳細回饋
			document.querySelectorAll('.feedback-box').forEach(box => {
				box.style.display = 'none';
			});

			// 顯示指定回饋
			const box = document.getElementById(`content_${studentID}_${question}_${model}`);
			if (box) {
				box.style.display = 'block';
			}
		}

		function showCode(studentID, question, element) {
			if (!studentID) {
				alert("請先選擇一位學生！");
				return;
			}

			document.querySelectorAll('.feedback-sidebar:nth-child(2) li').forEach(li => {
				li.classList.remove('active');
			});
			element.classList.add('active');

			// 隱藏所有詳細回饋
			document.querySelectorAll('.feedback-box').forEach(box => {
				box.style.display = 'none';
			});

			const box = document.getElementById(`code_${studentID}_${question}`);
			if (box) {
				box.style.display = 'block';
			}
		}


		function submitAllScores() {
			const inputs = document.querySelectorAll(".feedback-sidebar input[type='number']");
			let formData = new FormData();
			let hasData = false;

			inputs.forEach(input => {
				const studentID = input.closest('li').getAttribute('onclick').match(/'(.*?)'/)[1];
				let score = input.value.trim();

				if (score === "") {
					score = input.placeholder;
				}

				if (score !== "") {
					formData.append("scores[" + studentID + "]", score);
					hasData = true;
				}
			});

			if (!hasData) {
				alert("沒有可儲存的分數！");
				return;
			}

			fetch("save_all_scores.php", {
				method: "POST",
				body: formData
			})
			.then(res => res.text())
			.then(msg => {
				alert(msg);
			})
			.catch(err => {
				console.error(err);
				alert("儲存失敗，請稍後再試！");
			});
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

