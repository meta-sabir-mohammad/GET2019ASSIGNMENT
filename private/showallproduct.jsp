<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,td,th{
text-align: center;
border: 1px solid black;
}
</style>
</head>
<body>
<%@ page import="java.util.List"%>
<%@ page import="dto.Product"%>

<h1 align="center">All Products</h1>
<br/>
<table align="center">
	<%if(session.getAttribute("message")!= null){ %>
		<h3 style="color:red" align="center"><%= session.getAttribute("message")%></h3>
	<% session.removeAttribute("message");
		} %>
	
	<%if(session.getAttribute("productsList") != null){ %>
	<% List<Product> productsList = (List<Product>) session.getAttribute("productsList");%>
	
	<tr>
		<th>
			<label>Product Name</label>
		</th>
		<th>
			<label>Product Price</label>
		</th>
		<th>
			<label>Add</label>
		</th>
	</tr>
	
	<%for(Product product : productsList){ %>
		<tr>
			<td><label><%= product.getName()%></label></td>
			<td><label><%= product.getPrice()%></label></td>
			<td>
			<form action="../../RedirectToAddProductPage" method="POST">
			<input type="hidden" name="id" value="<%=product.getProductCode()%>">
			<input type="hidden" name="name" value="<%=product.getName()%>">
			<input type="hidden" name="price" value="<%=product.getPrice()%>">
			<input type="submit" value="Add">
			</form>
		</tr>

		<%} 
		}%>
	</table>
</body>
</html>