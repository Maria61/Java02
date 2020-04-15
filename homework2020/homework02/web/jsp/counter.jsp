<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int i=0;
	synchronized(application){
		if(application.getAttribute("time")==null)
			i=1;
		else{
			
			i=Integer.parseInt((String)application.getAttribute("time"));
			i++;
		}
		application.setAttribute("time", Integer.toString(i));
	}
%>
<table>
	<tr>
		<td align="center" style="color: green">欢迎访问</td>
	</tr>
	<tr>
		<td>您是第<font color="red" size="10px"><%=i %></font>位访问本网站顾客</td>
	</tr>
</table>
</body>
</html>