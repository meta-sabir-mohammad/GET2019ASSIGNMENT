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

	<h1 align="center">Search Student</h1>
	<div align="center">
	<form action="../SearchStudentDetailServlet" method="POST">
	<table id="searchFormTable">
		<tr>
			<td>
				<label>First Name :</label>
			</td>
			<td>
				<input type="text" name="firstName" id="firstName" placeholder="Enter your first name" pattern="[a-zA-Z]+">
			</td>
		</tr>
		<tr>
			<td>
				<label>Last Name :</label>
			</td>
			<td>
				<input type="text" name="lastName" id="lastName" placeholder="Enter your last name" pattern="[a-zA-Z]+">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<label>Filter By Class :</label>&nbsp&nbsp&nbsp&nbsp
				<label><input type="radio" name="filterByClass" id="filterByClassNo" value="no" checked>No</label>&nbsp&nbsp&nbsp&nbsp
				<label><input type="radio" name="filterByClass" id="filterByClassYes" value="yes">Yes</label>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Search">
			</td>
		</tr>
		</table>
	</form>
	</div>
	
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="com.sms.dto.Student"%>

	<h1 align="center">Student's Detail</h1>
	<table align="center" id="studentTable">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Father's Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
		</tr>
		<%
	if(session.getAttribute("studentSearchList") != null){
	ArrayList<Student> studentSearchList = (ArrayList<Student>) session.getAttribute("studentSearchList");
%>
		<%
	for(Student student : studentSearchList){
	%>
		<tr>
			<td><label id="firstName"><%=student.getFirstName() %></label></td>
			<td><label id="lastName"><%=student.getLastName() %></label></td>
			<td><label id="fatherName"><%=student.getFatherName() %></label>
			</td>
			<td><label id="email"><%=student.getEmail() %></label></td>
			<td><label id="class"><%=student.getStudentClass() %></label></td>
			<td><label id="age"><%=student.getAge() %></label></td>
		</tr>
		<%}
	session.invalidate();
	}%>
	</table>
</body>
</html>