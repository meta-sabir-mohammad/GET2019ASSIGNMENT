<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%session.removeAttribute("userName"); %>
	<div align="center">
	<h1>Login</h1>
	<br/>
		<form action="../LoginServlet" method="POST">
			<table>
				<tr>
					<td><lable>User Name :</lable></td>
					<td><input type="text" name="userName" pattern="[a-zA-Z]+" minlength="5" maxlength="10" 
						placeholder="Enter user name" required></td>
				</tr>

				<tr>
					<td><label>Password : </label></td>
					<td><input type="password" name="password" pattern="[0-9]+" minlength="5" maxlength="10"
						placeholder="Enter password" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login"></td>
				</tr>
				<tr >
					<td colspan="2" align="center">
						<% if (session.getAttribute("error") != null) { %> <label
						style="color: red"><%=session.getAttribute("error")%></label> <% session.removeAttribute("error"); }%>
					</td>
				</tr>
			</table>
			<%if(session.getAttribute("message")!= null){ %>
			<h3 style="color: red"><%=session.getAttribute("message")%></h3>
			<%session.removeAttribute("message");} %>
		</form>
	</div>
</body>
</html>