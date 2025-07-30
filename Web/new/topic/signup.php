<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>註冊</title>

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
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-right">
						
					</div>
				</div>
			</div>
		</div>
		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-xs-1">
						<a href="index.php"><img src="./images/NFU_Logo.png" alt="LOGO" style="height: 50px;"></a>
					</div>
					<div class="col-xs-11 text-right menu-1">
						<ul>
							<li><a href="index.php">主頁</a></li>
							<li class="btn-cta"><a href="login.php"><span>登入</span></a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-bgs" role="banner" style="background-image:url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
		
	</header>

	<div id="fh5co-contact">
		<div class="container">
			<div class="row">
				<div class="col-md-3 animate-box">
				</div>
				<div class="col-md-6 animate-box text-center">
					<h3>註冊</h3>
					<form action="./php/signup.php" method="POST">
						<div class="row form-group">
							<div class="col-md-6">
								<!-- <label for="fname">First Name</label> -->
								<input type="text" id="fname" name="firstname" class="form-control" placeholder="姓">
							</div>
							<div class="col-md-6">
								<!-- <label for="lname">Last Name</label> -->
								<input type="text" id="lname" name="lastname" class="form-control" placeholder="名">
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="email">Email</label> -->
								<input type="text" id="email" name="email" class="form-control" placeholder="電子信箱(帳號)">
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="subject">Subject</label> -->
								<input type="text" id="subject" name="password" class="form-control" placeholder="輸入密碼">
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<!-- <label for="subject">Subject</label> -->
								<input type="text" id="subject" name="repassword" class="form-control" placeholder="再次輸入密碼">
							</div>
						</div>

						<label class="radio-container">
							<input type="radio" name="job" value="0"  required>
							學生
						</label>

						<label class="radio-container">
							<input type="radio" name="job" value="1" >
							老師
						</label>

						<?php
							session_start();
							if (isset($_SESSION['error'])) {
								echo '<p style="color:red; text-align:center;">' . $_SESSION['error'] . '</p>';
								unset($_SESSION['error']); // 清除錯誤訊息
							}
						?>

						<div class="form-group">
							<input type="submit" value="註冊" class="btn btn-primary">
						</div>

					</form>		
				</div>
			</div>
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

