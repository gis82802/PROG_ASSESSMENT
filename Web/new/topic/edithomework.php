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
							<li class="btn-cta"><a href="teacherclass.php"><span>返回</span></a></li>
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
        <h2 class="mb-4">作業編輯</h2>
        <p></p>
        <?php
        if (isset($_SESSION['error'])) {
            echo '<p style="color:red; text-align:center;">' . $_SESSION['error'] . '</p>';
            unset($_SESSION['error']);
        }

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
		?>
		<form action="./php/updatehomework.php" method="post">

		<label for="HomeworkName">作業名稱：</label>
		<input type="text" name="HomeworkName" id="HomeworkName" value="<?php echo htmlspecialchars($row['HomeworkName']); ?>" required><br><br>

		<label for="Deadline">繳交期限：</label>
		<input type="datetime-local" name="Deadline" id="Deadline" value="<?php echo date('Y-m-d\TH:i', strtotime($row['Deadline'])); ?>" required><br><br>

		<div id="questionsContainer">
			<?php
			$classID = $_SESSION['selected_class_id'];
			$questionFolder = "./data/" . $classID . "/". $homeworkID . "/homework_texts";
			for ($i = 1; $i <= $row['QuestionSum']; $i++) {
				echo "<h3>第 $i 題題目</h3>";
				$questionFile = "$questionFolder/Q$i.txt";
				if (file_exists($questionFile)) {
					$questionText = file_get_contents($questionFile);
					echo "<textarea name='question_$i' rows='5' style='width:100%;'>" . htmlspecialchars($questionText) . "</textarea>";
				} else {
					echo "<textarea name='question_$i' rows='5' style='width:100%;'>（找不到題目檔案）</textarea>";
				}
			}
			?>
		</div>
		<input type="hidden" name="QuestionCount" id="QuestionCount" value="<?php echo $row['QuestionSum']; ?>">

		<button type="button" id="addQuestion" class="btn btn-success">題數增加</button>
		<button type="button" id="removeQuestion" class="btn btn-danger">題數減少</button>
		<button type="submit" class="btn btn-primary">儲存修改</button>
	</form>
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
	<script>
	document.addEventListener("DOMContentLoaded", () => {
		let count = <?php echo $row['QuestionSum']; ?>;
		const box = document.getElementById("questionsContainer");
		const questionCountInput = document.getElementById("QuestionCount");

		document.getElementById("addQuestion").onclick = () => {
			count++;
			questionCountInput.value = count;
			box.insertAdjacentHTML("beforeend",
				`<div class='question-block'><h3>第 ${count} 題題目</h3>
				<textarea name='question_${count}' rows='5' style='width:100%;'></textarea></div>`);
		};

		document.getElementById("removeQuestion").onclick = () => {
			if (count > 1) {
				box.removeChild(box.lastElementChild);
				count--;
				questionCountInput.value = count;
			} else alert("至少要有一題題目！");
		};
	});
</script>
</body>
</html>
