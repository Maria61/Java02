<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.maria.*" %>
<%@ page import="com.maria.model.GoodsItem" %>
<%@ page import="com.maria.model.Product" %>
<%@ page import="com.maria.model.ShoppingCart" %>
<html>
<head><title>用户购物车信息</title></head>
<body>
<center>
<%
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    ArrayList<GoodsItem> items = new ArrayList<GoodsItem>(cart.getItems());
%>
<p>您的购物车信息</p>
<table>
<tr><td style='width:50px'>数量</td>
    <td style='width:80px'>商品</td>
    <td style='width:80px'>价格</td>
    <td style='width:80px'>小计</td>
    <td style='width:80px'>是否删除</td>
</tr>
<%
  // 显示购物车中每件商品信息
  for (GoodsItem goodsItem : items) {
    Product product = goodsItem.getProduct();
%> 
  <tr><td><%=goodsItem.getQuantity() %></td>
  <td><%=product.getPname() %></td>
  <td><%=product.getPrice() %></td>
  <td><%=((int)(product.getPrice() * goodsItem.getQuantity()*100+0.5))/100.00 %></td>
  <td><a href="deleteItem.jsp?id=<%=product.getId() %>">删除</a></td>
 </tr>
<%
    }
%> 
  <tr><td colspan='4' style='text-align:right'>总计:<%=cart.getTotal() %></td></tr>
</table>
<a href="index.jsp">返回继续购物</a>
</center>
</body>
</html>
