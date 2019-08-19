<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/basic.css">
    <link rel="stylesheet" href="css/login.css  ">
    <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css"/>
    <title>HRegister</title>
  
</head>
<body>
        <nav id="nav">
                <section class="cen">
                <h1 class="logo"></h1>
						   <ul class="link">
							<li class="active"><a href="UserManager.jsp">用户管理</a></li>	
                			<li><a href="HLogin.jsp">登录</a></li>
               				<li><a href="HRegister.jsp">注册</a></li>
						</ul>
                </section>
        </nav>
     <div class="container">
       
    </div>
     <div class="container">
       
    </div>
     <div class="container">
       
    </div>
        <c:if test="${empty requestScope.currentPage }">
					<c:redirect url="userManager"></c:redirect>
				</c:if>
        <form action="userManager" method="post">
					 <table border=1 style="background-color: bisque;width: 1100px;margin-left: 200px;">
                        <tr style="height: 50px;">
								<td style="padding-left: 50px;">用户ID</td>
								<td style="padding-left: 50px;">用户名</td>
								<td style="padding-left: 50px;">用户密码</td>
								<td style="padding-left: 50px;">用户状态</td>
								<td style="padding-left: 50px;">用户邮箱</td>
								<td style="padding-left: 50px;">操作</td>
							</tr>
						<c:forEach var="user" items="${requestScope.userList}"
							varStatus="i" step="1">
							<tr>
								<td style="padding-left: 50px;">${user.uId}</td>
								<td style="padding-left: 50px;">${user.uName}</td>
								<td style="padding-left: 50px;">******</td>
								<td style="padding-left: 50px;">
								<c:if test="${user.uStatus==0}">待审核</c:if>
								<c:if test="${user.uStatus!=0}">已审核</c:if>
								</td>
								<td style="padding-left: 50px;">${user.uEmail }</td>
								<td style="padding-left: 50px;">
								<a href="updateUser?id=${user.uId}">审核</a>
								<a href="updateUserpass?id=${user.uId}">重置</a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="10" align="center">
						
							<c:if test="${requestScope.currentPage==1 }">
									<a href="userManager?currentPage=${currentPage-1}">
										<button class="pageBottom">下一页</button></a>
								</c:if> <c:if test="${requestScope.currentPage!=totalPage }">
									<a href="userManager?currentPage=${currentPage+1}">
										<button class="pageBottom">上一页</button></a>
								</c:if>
							</td>
						</tr>
					</table>
				</form>
  </body>
</html>
