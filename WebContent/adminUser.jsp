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
<div class="container">
  <div class="header"><a href="login.jsp">校园闲置物品交换平台</a> </div><!-- end .header --></div>
<div class="sidebar1">
    <ul class="nav">
      <li><a href="admin.jsp">查找物品</a></li>
      <li><a href="adminRecord">记录管理</a></li>
      <li><a href="listUser">查看用户</a></li>
  </ul>
  <!-- end .sidebar1 --></div>
<div class="content" >
	 <br/>
      <c:if test="${hasResult == 1}">
    <table style="text-align:center">
    	<tr>
    		<td>
    			昵称
    		</td>
        	<td>
            	账户名
            </td>
            <td>
            	邮箱
            </td>
            <td>
            	密码
         	</td>
         </tr>
    	<c:forEach var="user" items="${userList}">
        	<tr>
      			<td>
       			${user.name}
      			</td>
      			<td>
       			${user.account}
      			</td>
      			<td>
       		     ${user.email} 	
      			</td>
                <td>
                 ${user.password} 	
            	</td>
     		</tr>
        </c:forEach>
    </table>
    </c:if >
  <!-- end .content --></div>
 


</body>
</html>