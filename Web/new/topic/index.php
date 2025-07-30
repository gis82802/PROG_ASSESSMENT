<?php
session_start();
$teacherID = $_SESSION['UserID'] ?? "";
//$_SESSION['UserID']="";

// 資料庫連線
$conn = new mysqli("localhost", "root", "", "topic");
if ($conn->connect_error) {
    die("連線失敗: " . $conn->connect_error);
}

// 查詢學生數量 (UserID 第一碼為 0)
$sql_students = "SELECT COUNT(*) AS studentCount FROM users WHERE UserID LIKE '0%'";
$result_students = $conn->query($sql_students);
$studentCount = 0;
if ($result_students && $result_students->num_rows > 0) {
    $row = $result_students->fetch_assoc();
    $studentCount = $row['studentCount'];
}

// 查詢教師數量 (UserID 第一碼為 1)
$sql_teachers = "SELECT COUNT(*) AS teacherCount FROM users WHERE UserID LIKE '1%'";
$result_teachers = $conn->query($sql_teachers);
$teacherCount = 0;
if ($result_teachers && $result_teachers->num_rows > 0) {
    $row = $result_teachers->fetch_assoc();
    $teacherCount = $row['teacherCount'];
}

// 查詢課程數量
$sql_courses = "SELECT COUNT(*) AS courseCount FROM classes";
$result_courses = $conn->query($sql_courses);
$courseCount = 0;
if ($result_courses && $result_courses->num_rows > 0) {
    $row = $result_courses->fetch_assoc();
    $courseCount = $row['courseCount'];
}

$conn->close();
?>

<!DOCTYPE HTML>
<html>

	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge"> <!--確保使用最新的渲染模式-->
	<title>首頁</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"> <!--適配不同裝置的螢幕寬度-->

	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
	
	<link rel="stylesheet" href="css/animate.css">

	<link rel="stylesheet" href="css/icomoon.css">

	<link rel="stylesheet" href="css/bootstrap.css">

	<link rel="stylesheet" href="css/magnific-popup.css">

	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<link rel="stylesheet" href="css/style.css">

	<script src="js/modernizr-2.6.2.min.js"></script>

	</head>
	<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-xs-1">
						<a href="index.php"><img src="./images/NFU_Logo.png" alt="LOGO" style="height: 50px;"></a>
					</div>
					<div class="col-xs-11 text-right menu-1">
						<ul>
							<li class="btn-cta"><a href="login.php"><span>登入</span></a></li>
							<li class="btn-cta"><a href="signup.php"><span>註冊</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-cover" role="banner"
			style="background-image: url(images/img_bg_1.jpg); height: 500px;" data-stellar-background-ratio="0.5">
		<div class="overlay" style="background: rgba(0, 0, 0, 0.3); position: absolute; top: 0; bottom: 0; left: 0; right: 0;"></div>
		<div class="container" style="position: relative; z-index: 2;">
			<div class="row">
			<div class="col-md-8 col-md-offset-2 text-center">
				<div class="display-tc animate-box" data-animate-effect="fadeIn" style="margin-top: 55px;">
				<h1 style="color: white; text-shadow: 1px 1px 5px rgba(0,0,0,0.5);">
					基於大語言模型之<br>程式作業自動評分與建議回饋系統
				</h1>
				</div>
			</div>
			</div>
		</div>
	</header>

	<div id="fh5co-counter" class="fh5co-counters">
		<div class="container">
			<div class="row">
				<div class="col-md-4 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="<?php echo $studentCount; ?>" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label"><p>學生</p></span>
				</div>
				<div class="col-md-4 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="<?php echo $courseCount; ?>" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label"><p>課程</p></span>
				</div>
				<div class="col-md-4 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="<?php echo $teacherCount; ?>" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label"><p>教師</p></span>
				</div>
			</div>
		</div>
	</div>

	<div id="fh5co-explore" class="fh5co-bg-section">
		<!--
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>介紹</h2>
					<p>可以對作業程式碼進行評分與回饋 </p>
				</div>
			</div>
		</div>	
		-->
			<div class="col-md-12 text-center">
				<p>
					<small class="block">by 翁慧霖 </small> 
					<small class="block">張宇光</small> 
			<br>
					<small class="block">國立虎尾科技大學 資工系</small> 
				</p>
			</div>

		</div>
	</footer>
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

	</body>
</html>

