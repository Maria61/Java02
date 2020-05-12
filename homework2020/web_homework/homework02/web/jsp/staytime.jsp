<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示停留时间</title>

<script language="javascript">
 var second=0;
 var minute=0;
 var hour=0;
 window.setTimeout("interval();",1000);
 function interval()
 {
	 second++;
	 if(second==60){
		 second=0;
		 minute++;
	 }
	 if(minute==60){
		 minute=0;
		 hour+=1;
	 }
	 document.form.text.value=hour+"时"+minute+"分"+second+"秒";
	 window.setTimeout("interval();",1000);
 }
</script>
</head>
<body>
<form name="form" method="post">
	<center>
		<p><font size="5" >在本站已停留</font></p>
		<p><input name="text" type="text"></p>
	</center>
</form>
</body>
</html>