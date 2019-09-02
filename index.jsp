<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="../LoginServlet" method="POST">
			<table>
				<tr>
					<td><lable>User Name :</lable></td>
					<td><input type="text" name="userName" pattern="[a-zA-Z]+" minlength="5" maxlength="10" 
						placeholder="Enter user name"></td>
				</tr>

				<tr>
					<td><label>Password : </label></td>
					<td><input type="password" name="password" pattern="[a-zA-Z0-9]+" minlength="5" maxlength="10"
						placeholder="Enter password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Login"></td>
				</tr>
				<tr>
					<td colspan="2">
						<% if (session.getAttribute("error") != null) { %> <label
						style="color: red"><%=session.getAttribute("error")%></label> <% session.removeAttribute("error"); }%>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>