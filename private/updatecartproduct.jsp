<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@ page import="dto.Product" %>
	<%if(session.getAttribute("product") != null){
		Product product =(Product) session.getAttribute("product");
		%>
	<form action="../../UpdateCartProductServlet" method="POST">
	<table align="center">
		<tr>
			<td>
			<label>Product Name : </label>
			</td>
			<td>
			<input type="hidden" name="id" value="<%=product.getProductCode()%>" readonly>
			<label><%=product.getName()%></label>
			</td>
		</tr>
		<tr>
			<td>
			<label>Product Price : </label>
			</td>
			<td>
			<label><%=product.getPrice()%></label>
			</td>
		</tr>
		<tr>
			<td>
			<label>Product Quantity : </label>
			</td>
			<td>
			<input type="number" name="quantity" value="<%=product.getQuantity()%>" min="1" max="10" placeholder="Enter quantity">
			</td>
		</tr>
			<td align="center">
				<input type="submit" value="Update Quantity" onclick="form.action='../../UpdateCartProductServlet'">
			</td>
			<td>
				<input type="submit" value="Remove Product" onclick="form.action='../../RemoveProductFromCartServlet'">
			</td>
		</tr>
	</table>
	</form>
	<%} %>

</body>
</html>