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
		
Table {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-top:1%;
}

 td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

 tr:nth-child(even){background-color: #f2f2f2;}

 tr:hover {background-color: #ddd;}

  th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}
td{
 text-align: center;
}
input[type=submit]{
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 32px;
  text-decoration: none;
  margin: 2px 2px;
  cursor: pointer;
}
a{
	text-decoration : none;
	padding : 1%;
	background-color : #4CAF50;
	color: white;
	border: none;
	}
</style>
</head>
<body>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="com.sms.dto.Student"%>

	<h1 align="center">Student's Detail</h1>
	
	<a href="../GetAllStudentDetailServlet" >Refresh</a>
	<br/>
	<table align="center">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Father's Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
			<th>Update</th>
		</tr>
		<%
	if(session.getAttribute("studentList") != null){
	ArrayList<Student> studentList = (ArrayList<Student>) session.getAttribute("studentList");
%>
		<%
	for(Student student : studentList){
	%>
		<tr>
			<td><label id="id"><%=student.getId() %></label></td>
			<td><label id="firstName"><%=student.getFirstName() %></label></td>
			<td><label id="lastName"><%=student.getLastName() %></label></td>
			<td><label id="fatherName"><%=student.getFatherName() %></label>
			</td>
			<td><label id="email"><%=student.getEmail() %></label></td>
			<td><label id="class"><%=student.getStudentClass() %></label></td>
			<td><label id="age"><%=student.getAge() %></label></td>
			<td>
				<form action="../RedirectToUpdatePageServlet" method="POST">
				<input type="hidden" name="id" value="<%=student.getId()%>">
				<input type="submit" value="Update">
				</form>
			</td>
		</tr>
		<%}
	session.invalidate();
	}%>
	</table>
	
</body>
</html>