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
��ӭ��������IP��ַ��<%= request.getRemoteAddr() %>
<p>��Ӧ�ó���������������ҳ�汻������
    <font color="blue" ><%=application.getAttribute("count")%>
    </font>��<br>
</body>
</html>
