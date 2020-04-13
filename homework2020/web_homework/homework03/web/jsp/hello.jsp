<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/13
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
输入你的名字：<input type="text" id="id" name="username"/><br/>
<input type="submit" value="确定"/>
<br/>
<%@ include file="response.jsp"%>
<%=request.getParameter("username")%>
</body>
</html>
