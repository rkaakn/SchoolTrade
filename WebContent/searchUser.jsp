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
  <div class="header"><a href="index">校园闲置物品交换平台</a> </div><!-- end .header --></div>
<div class="sidebar1">
    <ul class="nav">
      <li><a href="admin.jsp">查找物品</a></li>
      <li><a href="AdminfindDelRecord">记录管理</a></li>
      <li><a href="searchUser.jsp">用户查找</a></li>

  </ul>
  <!-- end .sidebar1 --></div>
<div class="content" >
  		    <form  action="adminFindUser" method="post">
		    <center>

       <label >  用户名<input style="font-size:24px; height:30px" type="text" name="username"/></label>
    <input style="font-size:24px" type="submit" value="搜索"/>
     </center>
	</form>
	
	 <br/>
	 <form  action="lendBook" method="post">
    <c:if test="${findUserResult==1}">
    <table style="text-align:center">
    	<tr>
        	<td>
            	用户名
            </td>
             <td>
            	姓名
         	</td>
            <td>
            	手机
            </td>
            <td>
            	邮箱
         	</td>
             
         </tr>
        	<tr>
      			<td>
       			 ${user.username}
      			</td>
      			<td>
       			${user.firstname}${user.lastname}
      			</td>
      			<td>
				${user.phonenum}
      			</td>
                <td>
				${user.email}
      			</td>
     		</tr>
    </table>
    </c:if >
    </form>
</div>
 


</body>
</html>