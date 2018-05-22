<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>File Upload Widget Flat Resposive Website Template | Home :: w3layouts</title>
<link href="/SchoolTrade/css/uploadItem/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="/SchoolTrade/css/uploadItem/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="/SchoolTrade/js/uploadItem/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="File Upload Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

</head>
<body>

<h1>校园闲置物品交换平台</h1>

<div class="upload">
			<h3>发布你的闲置物品</h3>
		<div class="login-form">
			<form method="post" action="uploadServlet" enctype="multipart/form-data">
				<div>
					<span>闲置名称</span>
						<input type="text" name="name" class="title" />
				</div>
				<div>
					<span>价格</span>
						<input type="text" name="price" class="title" />
				</div>
				<div>
					<span>填写你对它的描述</span>
						<input type="text" name="description" class="describe" />
				</div>
				<div id="drop">
				<a>Upload</a>
				<input type="file" name="photo" multiple />
			   </div>
				<ul>
				<!-- The file uploads will be shown here -->
				</ul>
				<input type="submit" value="发布闲置">
			</form>
		</div>
			
	<!-- JavaScript Includes -->
		<script src="/SchoolTrade/js/jquery.knob.js"></script>
	<!-- JavaScript Includes -->

	<!-- jQuery File Upload Dependencies -->
		<script src="/SchoolTrade/js/uploadItem/jquery.ui.widget.js"></script>
		<script src="/SchoolTrade/js/uploadItem/jquery.iframe-transport.js"></script>
		<script src="/SchoolTrade/js/uploadItem/jquery.fileupload.js"></script>
	<!-- jQuery File Upload Dependencies -->
		
	<!-- Main JavaScript file -->
		<script src="/SchoolTrade/js/uploadItem/script.js"></script>
	<!-- Main JavaScript file -->
	
</div>

	
</body>
</html>