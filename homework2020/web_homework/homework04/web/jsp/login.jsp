<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 2020/4/14
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/homework04/checkUserServlet" method="post">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
    口 令：<input type="password" name="password" value="${cookie1.password.value}"><br/>
    <input type="submit" value="登录">
    自动登录<input type="radio" name="auto" value="YES">YES
</form>
</body>
</html>
