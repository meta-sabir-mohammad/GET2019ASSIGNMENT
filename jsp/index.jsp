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
	<h1 align="center">Student Management System</h1>
	<br />
	<%if(session.getAttribute("operation") != null){ %>
	<%if(session.getAttribute("operation").equals("add")){ %>
	<%if((boolean) session.getAttribute("message") == true){  %>
	<h4 align="center">Student registration successful</h4>
	<%}else{ %>
	<h4 align="center">Student registration failed</h4>
	<% }
		}else if(session.getAttribute("operation").equals("update")){ %>
	<%if((boolean) session.getAttribute("message") == true){  %>
	<h4 align="center">Student detail update successful</h4>
	<%}else{ %>
	<h4 align="center">Student detail update failed</h4>
	<% }
		}
		%>
	<%
		session.invalidate();
	}%>
	<div id="menu" align="center">
		<ol align="center">
			<li><a href="addStudent.jsp">Add Student</a></li>
			<li><a href="searchStudent.jsp">Search Student</a></li>
			<li><a href="../GetAllStudentDetailServlet">Show All
					Student's</a></li>
		</ol>
	</div>
</body>
</html>