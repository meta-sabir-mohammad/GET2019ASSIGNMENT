<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
	font-size : 20px;
	}
	input[type=text],[type=email] {
  	width: 100%;
  	padding: 12px 20px;
  	margin: 4px 0;
  	box-sizing: border-box;
	}
	input[type=text]:focus {
  border: 1px solid #4CAF50;
}
input[type=submit]{
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
table{
width: 30%;
}
</style>
</head>
<body>
<%@ page import="com.sms.dto.Student" %>

<h1 align="center">Update Student Detail</h1>

<%
	if(session.getAttribute("studentDetail")!= null){
		Student student = (Student) session.getAttribute("studentDetail");
		%>
		<div align="center">
		<form action="../UpdateStudentDetailServlet" method="POST">
			<table>
				<tr>
					<td>
					<label>Id : </label>
					</td>
					<td>
						<input type="text" name="id" id="id" value="<%=student.getId()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>
					<label>First Name : </label>
					</td>
					<td>
						<input type="text" name="firstName" id="firstName" value="<%=student.getFirstName()%>" placeholder="Enter first name">
					</td>
				</tr>
				<tr>
					<td>
					<label>Last Name : </label>
					</td>
					<td>
						<input type="text" name="lastName" id="lastName" value="<%=student.getLastName()%>">
					</td>
				</tr>
				<tr>
					<td>
					<label>Father's Name : </label>
					</td>
					<td>
						<input type="text" name="fatherName" id="fatherName" value="<%=student.getFatherName()%>">
					</td>
				</tr>
				<tr>
					<td>
					<label>Email : </label>
					</td>
					<td>
						<input type="email" name="email" id="email" value="<%=student.getEmail()%>">
					</td>
				</tr>
				<tr>
					<td>
					<label>Class : </label>
					</td>
					<td>
						<input type="text" name="class" id="class" value="<%=student.getStudentClass()%>">
					</td>
				</tr>
				<tr>
					<td>
					<label>Age : </label>
					</td>
					<td>
						<input type="text" name="age" id="age" value="<%=student.getAge()%>">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Update">
					</td>
				</tr>
			</table>
		</form>
	</div>
<%		
	}else{
		response.sendRedirect("index.jsp");
	}
%>
</body>
</html>