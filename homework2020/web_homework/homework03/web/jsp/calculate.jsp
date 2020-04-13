<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/13
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--    SimpleCalculator 不可以直接放在src目录下，必须再包一层  --%>
<jsp:useBean id="calculator" class="com.beans.SimpleCalculator">
    <jsp:setProperty name="calculator" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>我的简易计算器</title>
</head>
<body>
<%
    try
    {
        float first=calculator.getFirst();
        float second=calculator.getSecond();
        String  op=calculator.getOperator();
        out.print("计算结果为："+calculator.getFirst()+calculator.getOperator()+calculator.getSecond()+"="
                +calculator.calculate(first, second, op));
    }catch(Exception e)
    {
        e.printStackTrace();

    }

%>
<br/>
<form action="calculate.jsp" method="post">
    第一个操作数：<input type="text" name="first">
    第二个操作数：<input type="text" name="second"><br/>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="计算" >
</form>
</body>
</html>
