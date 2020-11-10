<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
</head>
<body>
	<div align="center">
		<h1>User request</h1>
		<form action="<%= request.getContextPath() %>/register" method="post"
			enctype="multipart/form-data">
			<table style="with: 80%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="username" required /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" required /></td>
				</tr>
				<tr>
					<td>Company</td>
					<td><input type="text" name="companyname" required /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td>File</td>
					<td><input type="file" name="data" required /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>