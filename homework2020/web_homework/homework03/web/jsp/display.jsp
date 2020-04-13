<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/13
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.beans.UserBean" %>
<jsp:useBean id="user" class="com.beans.UserBean">
    <jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
UserName:<%=user.getUserName()%><br/>
Password:<%=user.getPassword()%><br/>
Email:<%=user.getEmail()%>
</body>
</html>
