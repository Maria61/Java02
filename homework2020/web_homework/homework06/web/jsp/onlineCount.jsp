<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 2020/5/13
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" %>
<html>
<head><title>Listener test</title>
</head>
<body>
欢迎您，您的IP地址是<%= request.getRemoteAddr() %>
<p>自应用程序启动以来，该页面被访问了
    <font color="blue" ><%=application.getAttribute("count")%>
    </font>次<br>
</body>
</html>
