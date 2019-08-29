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
	ol{
	list-style-type : none;
	}
	li{
	display : inline;
	}
	a{
	text-decoration : none;
	padding : 1%;
	margin : 5% 2% 0% 2%;
	background-color : #4CAF50;
	color: white;
	 border: none;
	}
	#menu{
	width : 600px;
	height : 100px;
	margin: auto;
	}
</style>
</head>
<body>
	<h1 align="center">Student Management System</h1>
	<br/>
	<%if(session.getAttribute("message")!= null){ %>
		<%if((boolean) session.getAttribute("message") == true){  %>
		<h2>Student registration successful</h2>
		<%}else{ %>
		<h2>Student registration failed</h2>
	<% }
		session.invalidate();
	}%>
	<div id="menu" align="center">
	<ol align="center">
		<li>
			<a href="addStudent.jsp">Add Student</a>
		</li>
		<li>
			<a href="searchStudent.jsp">Search Student</a>
		</li>
		<li>
			<a href="../GetAllStudentDetailServlet">Show All Student's</a>
		</li>
	</ol>
	</div>
</body>
</html>