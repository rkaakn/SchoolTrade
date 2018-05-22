<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="/SchoolTrade/css/general/te.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改个人信息</title>
	 <link rel="stylesheet" href="/SchoolTrade/css/general/te.css">
	 <link rel="stylesheet" href="/SchoolTrade/css/general/style.css">
<style type="text/css">

<script language="javaScript">
function success()
{
   alert("个人信息修改成功");
}

</script>

</style></head>

<body>

  <div class="header" >
  		<div style="float:left"><a href="index">校园闲置物品交换平台</a> </div>
  		           <div style="float:right; margin-left:20px"> <a href="changeInfo.jsp">修改个人信息</a></div>
          <div style="float:right; margin-right:20px"> <a href="uploadItem.jsp">发布我的闲置</a></div>
          <div style="float:right; margin-right:20px"> <a href="showMyRoom" >我发布的闲置</a></div>
                    <div style="float:right; margin-right:20px"> <a href="logOut" >登出</a></div>
    <!-- end .header --></div>
<div class="login-container">
		<h1>编辑个人信息</h1>

      	
      	<form action="updateUserInfo" method="post">
		<div>
			<input type="text" name="name" class="phone_number" placeholder="输入新的昵称" autocomplete="off" id="number"/>
		</div>
		<div>
			<input type="email" name="email" class="email" placeholder="输入新的邮箱" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="password" placeholder="输入新的密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		
		<button id="submit" type="submit">提交</button>
		</form>
		</div>
  <script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script src="/SchoolTradejs/common.js"></script>
<!--背景图片自动更换-->
<script src="/SchoolTrade/js/supersized.3.2.7.min.js"></script>
<script src="/SchoolTrade/js/supersized-init.js"></script>
<!--表单验证-->
<script src="/SchoolTradd/js/jquery.validate.min.js?var1.14.0"></script>
</body>
</html>