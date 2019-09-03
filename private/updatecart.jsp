<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,td,th{
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
	<th>
		<label>Update</label>
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
		<td>
			<form action="../../RedirectToUpdateProductPage" method="POST">
				<input type="hidden" name="id" value="<%=product.getProductCode()%>">
				<input type="hidden" name="name" value="<%=product.getName()%>">
				<input type="hidden" name="price" value="<%=product.getPrice()%>">
				<input type="hidden" name="quantity" value="<%=product.getQuantity() %>">
				<input type="submit" value="Update">
			</form>
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