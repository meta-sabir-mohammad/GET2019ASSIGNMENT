<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
		<div>
			<ul>
				<li>
					<a href="../../LogoutServlet">Logout</a>
				</li>
				<li>
					<a href="../../ShowEmployeeDetailServlet">Home</a>
				</li>
			</ul>
		</div>
	</nav>
	<h1 align="center">Friend List</h1>
	<br/>
	<div>
		<table align="center">
			<tr>
				<th>
					<label>Employee Id</label>
				</th>
				<th>
					<label>Employee Name</label>
				</th>
				<th>
					<label>Employee Email</label>
				</th>
				<th>
					<label>Go To Profile</label>
				</th>
			</tr>

				<tr>
					<td>
						<label></label>
					</td>
					<td>
						<label></label>
					</td>
					<td>
						<label></label>
					</td>
					<td>
						<form action="../../ShowFriendDetailServlet" method="POST">
							<input type="hidden" name="email" value="">
							<input type="submit" value="Open Profile">
						</form>
					</td>
				</tr>

		</table>
	</div>
</body>
</html>