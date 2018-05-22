<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>校园闲置物品交换平台</title>
	 <link rel="stylesheet" href="/SchoolTrade/css/searchItem/te.css">
	 	<link rel="stylesheet" href="/SchoolTrade/css/searchItem/style.css">
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
	<link rel="stylesheet" href="/SchoolTrade/css/searchItem/baguetteBox.min.css">
	<link rel="stylesheet" href="/SchoolTrade/css/searchItem/thumbnail-gallery.css">

  
	
	<style>
		.jq22-demo{ text-align: center; margin-top: 30px; }
		.jq22-demo a{ padding-left: 20px; padding-right: 20px; }
	</style>
</head>
<body>


		  <div class="header" >
  		<div style="float:left"><a href="searchItem.jsp">校园闲置物品交换平台</a> </div>
           <div style="float:right; margin-left:20px"> <a href="changeInfo.jsp">修改个人信息</a></div>
          <div style="float:right; margin-right:20px"> <a href="uploadItem.jsp">发布我的闲置</a></div>
          <div style="float:right; margin-right:20px"> <a href="myUpload" >我发布的闲置</a></div>
          <div style="float:right; margin-right:20px"> <a href="logOut" >登出</a></div>
    <!-- end .header --></div>
		

	<c:if test="${hasResult == 1 }">
		    <div class="tz-gallery">

		        <div class="row">
				<c:forEach var="item" items="${uploadItemList}">
					<div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                        <img src="/SchoolTrade/uploaddata/${item.pic}"/>
		                </div>
		            </div>
        		</c:forEach>
		        </div>
		    </div>

	</c:if>
	
	<script type="text/javascript" src="js/baguetteBox.min.js"></script>
	<script type="text/javascript">
		baguetteBox.run('.tz-gallery');
	</script>
<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>
</body>
</html>