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
	<div align="center">
		<h1>Student Registration Form</h1>
		<br />
		<form action="../AddStudentServlet" method="POST" onSubmit="validateAge()">
			<table>
				<tr>
					<td><label>First Name : </label></td>
					<td><input type="text" name="firstName" id="firstName"
						placeholder="Enter your first name" pattern="[a-zA-Z]+" minlength="2" maxlength="45" required></td>
				</tr>
				<tr>
					<td><label>Last Name : </label></td>
					<td><input type="text" name="lastName" id="lastName"
						placeholder="Enter your last name" pattern="[a-zA-Z]+" minlength="2" maxlength="45" required></td>
				</tr>
				<tr>
					<td><label>Father's Name : </label></td>
					<td><input type="text" name="fatherName" id="fathertName"
						placeholder="Enter your father's name" pattern="[a-z A-Z]+" minlength="2" maxlength="45" required></td>
				</tr>
				<tr>
					<td><label>Email : </label></td>
					<td><input type="email" name="email" id="email"
						placeholder="Enter your email" maxlength="45" required></td>
				</tr>
				<tr>
					<td><label>Class : </label></td>
					<td><input type="number" name="class" id="class"
						placeholder="Enter your class" pattern="[0-9]+" min="1" max="12" required></td>
				</tr>
				<tr>
					<td><label>Age : </label></td>
					<td><input type="text" name="age" id="age"
						placeholder="Enter your age" pattern="[0-9]+" maxlength="2" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">

	function vaildateAge(){
		var age = document.getElementById('age').value;
		if(age > 25 || age < 1){
			return false;
		}else{
			return true;
		}
	}
</script>
</body>
</html>