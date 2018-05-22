<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<title>注册页面</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="keywords" content="Access Subscribe Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->

<!-- css files -->
<link rel="stylesheet" href="/SchoolTrade/css/register/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="/SchoolTrade/css/register/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->

<!-- web-fonts -->
<link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese" rel="stylesheet">
<!-- //web-fonts -->

</head>

<body background="/SchoolTrade/images/register/bg.jpg">

<div class="center-container">

	<!--header-->
	<div class="header-w3l">
		<h1>填写注册信息</h1>
	</div>
	<!--//header-->
	
	<!--main-->
	<div class="main-content-agile">
			<h2>欢迎注册！<i class="fa mail fa-envelope"></i></h2>
			<h3>在这里发现你需要的东西</h3>
		<div class="sub-main-w3">	
			<form action="register" method="post">
				<div class="field">
					<i class="fa fa-user"></i>
					<input placeholder="用户名" name="name" type="text" required="">
				</div>
				<div class="field">
					<i class="fa fa-user"></i>
					<input placeholder="账号" name="account" type="text" required="">
				</div>
				<div class="field">
					<i class="fa fa-envelope"></i>
					<input placeholder="邮箱" name="email" type="email" required="">
				</div>
				<div class="field">
					<i class="fa fa-phone"></i>
					<input  placeholder="密码" name="password" type="tel" required="">
				</div>
				<input type="submit" value="提交">
			</form>
		</div>
	</div>
</div>

</body>
</html>
