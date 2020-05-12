<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!String[][] info=new String[][]{{"xuexue","233333"},{"minmin","23333"},
	{"lulu","2333"}};%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
		
		boolean flag=false;
		for(int i=0;i<3;i++)
		{
			if(info[i][0].equals(username)&&info[i][1].equals(password)){
				session.setAttribute("username", username);
				flag=true;
	
			}
		}
		if(flag==true){
			response.sendRedirect("main.jsp");
		}
		else response.sendRedirect("login.jsp");
		
	%>
</body>
</html>