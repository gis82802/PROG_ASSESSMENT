<!DOCTYPE HTML>
<html>
	<?php
		session_start();
		// 資料庫連線
		$conn = new mysqli("localhost", "root", "", "topic");
		if ($conn->connect_error) {
			$conn->close();
			header("Location: ../index.php");
			die("連線失敗: " . $conn->connect_error);
		}

		$classID = $_SESSION['selected_class_id'];

		$sql = "SELECT Name FROM classes WHERE ClassID = '$classID'";
		$result = $conn->query($sql);

		if ($result->num_rows === 1) {
			$row = $result->fetch_assoc();
			$ClassName = $row['Name']; 
		} else {
			$conn->close();
			header("Location: ../index.php");
		}

		$conn->close();
	?>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> <!--確保使用最新的渲染模式-->
		<title><?php echo $ClassName; ?></title>
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
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

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
							<li class="btn-cta"><a href="./student.php" ><span>返回</span></a></li>
							<!--<li class="btn-cta"><a href="javascript:void(0);" class="openModalBtn" data-modal="modal1"><span>查看總成績</span></a></li>-->
							<!--<li class="btn-cta"><a href="javascript:void(0);" class="openModalBtn" data-modal="modal2"><span>練習題</span></a></li>-->
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
				<?php include 'php/studenthomework.php'; ?>
			</div>
		</div>
	</div>
	
	<!-- 這是彈跳視窗 -->


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

