<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="/SchoolTrade/css/showItem/te.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>详细信息</title>
<link rel="stylesheet" href="/SchoolTrade/css/showItem/style.css">

<link rel="stylesheet" type="text/css" href="/SchoolTrade/css/showItem/b13.css"/>
	<style>
		*{margin:0; padding:0;}
		body,html{width:100%; height:100%;}
		#wrap{
			position: auto;
			overflow: hidden;
			top:0; left:0; right:0; bottom:0;
			margin:auto;
			width: 1000px;
			height: 828px;
		}
		#wrap > ul{
			width: 120%;
			list-style: none;
		}
		#wrap > ul > li{
			float: left;
			width: 100px;
			height: 400px;
			cursor: pointer;
		}
		#wrap > ul > li:nth-child(1){
			background: url('/SchoolTrade/uploaddata/${item.pic}') no-repeat center/cover;
		}
		#wrap > ul > li > .text{
			width: 100px;
			height: 100%;
			background: #000;
			opacity: .5;
		}
		#wrap > ul > li > .text p{
			padding: 20px 40px;
			font-family: 'Microsoft yahei';
			color: #fff;
		}
	</style>
</head>
<body>
<div class="container">
  <div class="header"><a href="index" style="float: left;">校园闲置物品交换平台</a> 
              <div style="float:right; margin-left:20px"> <a href="changeInfo.jsp">修改个人信息</a></div>
          <div style="float:right; margin-right:20px"> <a href="uploadItem.jsp">发布我的闲置</a></div>
          <div style="float:right; margin-right:20px"> <a href="showMyRoom" >我发布的闲置</a></div>
      <div style="float:right; margin-right:20px"> <a href="logOut" >登出</a></div>
    
</div><!-- end .header --></div>
	<div class="bg bg-box-1"></div>
	<div id="wrap">
		<ul>
			<li>
				
			</li>
			<li>
				
			</li>
			<li>
				
			</li>
			<li class="curr">
				
			</li>
		</ul>
	<img src="/SchoolTrade/images/showItem/line.jpg" style="margin-left:170px"/>
	<div class="col-md-6" data-reactid="579">
	
	<div class="bottom-spacing-2" data-reactid="585">
	<div data-reactid="586" ><font face="微软雅黑" font size="5">闲置的名字：</font>
	<strong data-reactid="584">${item.name}</strong></div></div>
	
	<div class="bottom-spacing-2" data-reactid="585">
	<div data-reactid="586"><font face="微软雅黑" font size="5">闲置的描述：</font><strong data-reactid="589">${item.description}</strong></div></div>
	
	<div class="bottom-spacing-2" data-reactid="585">
	<div data-reactid="586"><font face="微软雅黑" font size="5">闲置的价格：</font><strong data-reactid="589">${item.price}</strong></div></div>
	
	</div>
	
	<br/>
	<br/>
	<br/>
	<br />
	<form action="buy" method="post">
		<button id="submit" type="submit" style="background:#sec4d1c; width:250px;text-decoration: blink;">收入囊中</button>
	</form>
	<br />
	</div>
	
  
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script>
	(function(){
		$('#wrap li').mouseover(function(){
			if(!$(this).hasClass('curr')){
				$('#wrap li').removeClass('curr');
				$(this).addClass('curr');

				// 切换背景
				$('#wrap li').each(function(index){
					if($(this).hasClass('curr')){
						$('.bg').fadeOut(300);
						$('.bg:eq(' + index + ')').fadeIn(500);
					}
				});

				$('.curr').stop().animate({
					width: 700
				}, 500, 'linear');
				$('#wrap li').not('.curr').stop().animate({
					width: 100
				}, 500, 'linear');
			}
		});
	})()
	</script>
</body>
</html>