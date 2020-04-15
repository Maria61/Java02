<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%String username=(String)session.getAttribute("username");
	out.println("进入重定向:");
	%>
	<h4 style="color:blue">Hello,<%=username %>!!</h4>
	<br/>
	<a href="exit.jsp" >退出</a>
</body>
</html>