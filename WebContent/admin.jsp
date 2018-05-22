<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administor后台</title>


<link rel="stylesheet" type="text/css" href="/SchoolTrade/css/admin/te.css">
</head>
<body>
<SCRIPT LANGUAGE=javascript> 
function del() { 
 var msg = "您真的确定要删除吗？\n\n请确认！"; 
 if (confirm(msg)==true){ 
  return true; 
 }else{ 
  return false; 
 } 
} 
</SCRIPT> 

<div class="container">
  <div class="header"><a href="login.jsp">校园闲置物品交换平台</a> </div><!-- end .header --></div>
<div class="sidebar1">
    <ul class="nav">
      <li><a href="admin.jsp">查找物品</a></li>
      <li><a href="AdminfindDelRecord">记录管理</a></li>
      <li><a href="listUser">查看用户</a></li>
  </ul>
  <!-- end .sidebar1 --></div>
<div class="content" >
  		    <form  action="adminFindItem" method="post">
		    <center>
                 <input style="font-size:24px; height:30px" type="text" name="name"/>
      
    <input style="font-size:24px" type="submit" value="搜索"/>
     </center>
	</form>
	
	 <br/>
      <c:if test="${hasResult == 1}">
    <table style="text-align:center">
    	<tr>
    		<td>
    			Id
    		</td>
        	<td>
            	物品
            </td>
            <td>
            	价格
         	</td>
         </tr>
    	<c:forEach var="item" items="${itemList}">
        	<tr>
      			<td>
       			${item.itemId}
      			</td>
      			<td>
       			${item.name}
      			</td>
                <td>
                 ${item.price} 	
            	</td>
     		</tr>
        </c:forEach>
    </table>
    </c:if >
  <!-- end .content --></div>
 


</body>
</html>