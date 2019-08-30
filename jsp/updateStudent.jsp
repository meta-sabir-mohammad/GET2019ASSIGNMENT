<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel = "stylesheet" type = "text/css" href = "../css/main.css" />
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
			<table id="upateFormTable">
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
						<input type="text" name="firstName" id="firstName" value="<%=student.getFirstName()%>" pattern="[a-zA-Z]+" minlength="2" maxlength="45" placeholder="Enter first name" required>
					</td>
				</tr>
				<tr>
					<td>
					<label>Last Name : </label>
					</td>
					<td>
						<input type="text" name="lastName" id="lastName" value="<%=student.getLastName()%>" pattern="[a-zA-Z]+" minlength="2" maxlength="45" placeholder="Enter your last name" required>
					</td>
				</tr>
				<tr>
					<td>
					<label>Father's Name : </label>
					</td>
					<td>
						<input type="text" name="fatherName" id="fatherName" value="<%=student.getFatherName()%>" pattern="[a-z A-Z]+" minlength="2" maxlength="45" placeholder="Enter your father name" required>
					</td>
				</tr>
				<tr>
					<td>
					<label>Email : </label>
					</td>
					<td>
						<input type="email" name="email" id="email" value="<%=student.getEmail()%>"  maxlength="45" placeholder="Enter your email" required>
					</td>
				</tr>
				<tr>
					<td>
					<label>Class : </label>
					</td>
					<td>
						<input type="number" name="class" id="class" value="<%=student.getStudentClass()%>" pattern="[0-9]+" min="1" max="12" placeholder="Enter your class" required>
					</td>
				</tr>
				<tr>
					<td>
					<label>Age : </label>
					</td>
					<td>
						<input type="number" name="age" id="age" value="<%=student.getAge()%>" pattern="[0-9]+" min="1" max="99" placeholder="Enter your age" required>
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