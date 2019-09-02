<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td, th{
text-align: center;
border: 1px solid black;
}
</style>
</head>
<body>

<%@ page import="dto.Cart" %>
<%@ page import="dto.Product"%>
<%@ page import="java.util.ArrayList" %>

<h1 align="center">Cart</h1>
<br/>
<%if(session.getAttribute("message")!= null){ %>
<h3 style="color: red" align="center"><%=session.getAttribute("message") %></h3>
<%
	session.removeAttribute("message");
	} %>
<%if(session.getAttribute("cart")!= null){ %>
<% Cart cart = (Cart)session.getAttribute("cart");%>
<table align="center">
<tr>
	<th>
		<label>Product Name</label>
	</th>
	<th>
		<label>Product Price</label>
	</th>
	<th>
		<label>Product Quantity</label>
	</th>
</tr>
 <%for(Product product : cart.getProducts()){ %>
	<tr>
		<td>
			<label><%=product.getName() %></label>
		</td>
		<td>
			<label><%=product.getPrice() %></label>
		</td>
		<td>
			<label><%=product.getQuantity() %></label>
		</td>
	</tr>
	<%} %>
	<tr>
		<td>
		</td>
		<td>
			<label>Total Price : </label>
		</td>
		<td>
			<label><%=cart.getTotal() %></label>
		</td>
	</tr>
</table>
<%
	session.removeAttribute("cart");
	} %>
</body>
</html>