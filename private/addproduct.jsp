<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="dto.Product" %>
	<%if(session.getAttribute("product") != null){
		Product product =(Product) session.getAttribute("product");
		%>
	<form action="../../AddProductServlet" method="POST">
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
			<input type="number" name="quantity" value="1" min="1" max="5" placeholder="Enter quantity">
			</td>
		</tr>
			<td colspan="2" align="center">
			<input type="submit" value="Add">
			</td>
		</tr>
	</table>
	</form>
	<%} %>
</body>
</html>