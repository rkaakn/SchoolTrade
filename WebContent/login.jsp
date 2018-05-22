<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<title>登录页面</title>
<link rel="stylesheet" href="/SchoolTrade/css/login/new_style.css" />

<script type="text/javascript">
	function updateValidateCode(width, height) {
	8
		check();

		if ("" >= 3) {
			document.getElementById('validateCodeImage').innerHTML = '<a href="#"><img id="validateCodeImg" onclick="updateValidateCode(75,26)" border="0" style="cursor:hand;width:'
					+ width
					+ ';height:'
					+ height
					+ ';"  src="createCode.do?random='
					+ Math.random()
					+ '" alt="如果看不清验证码，请点图片刷新" /></a>';
		}
		;
	};
	function check() {
		if (parent != window) {
			parent.location = "http://sso.jwc.whut.edu.cn/";
		}
	}
</script>
</head>
<body onload="updateValidateCode(75,26)" background="http://localhost:8080/SchoolTrade/images/login/header_bg.png">
	<div class="wrap_1200 zk-style">
	    
		<div class="logo">
			<img src="http://localhost:8080/SchoolTrade/images/login/logo.png" />
		</div>
		<div class="login-wrap">
			<div class="title"></div>
			<form class="form" id="loginForm" name="loginForm" method="post"
				action="login">
				<div class="row">
					<label>账&nbsp;&nbsp;&nbsp;号：</label> <!-- <i class="fa fa-user"> </i> -->
					<input name="account" type="text" class="login_input"
						id="textfield" value="" />
				</div>
				<div class="row">
					<label>密&nbsp;&nbsp;&nbsp;码：</label>
					<!-- <i class="fa fa-mm"> </i> -->
					<input name="password" type="password" class="login_input"
						id="textfield2" />
				</div>

	
				<div class="row">
					<button type="button" onclick="this.form.submit();">
						<span>登录</span>
					</button>
				</div>
				<div class="row clear">

					<a style="color: #333; float: left;" href="forgetPassword.jsp">
						忘记密码</a> 
					<a style="color: #333; float: right;"
						href="register.jsp">还没有账号？</a>
				</div>
			</form>
		</div>
		<div class="whut-copy">版权所有：武汉理工大学计算机学院 Email:computer@whut.edu.cn</div>
	</div>
	
</body>
</html>