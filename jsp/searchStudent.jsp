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
	input[type=text] {
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
#studentTable {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

 #studentTable td, #studentTable th {
  border: 1px solid #ddd;
  padding: 8px;
}

 #studentTable tr:nth-child(even){background-color: #f2f2f2;}

 #studentTable tr:hover {background-color: #ddd;}

 #studentTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
#searchFormTable{
width:30%;
}
</style>
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