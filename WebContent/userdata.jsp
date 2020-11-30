<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
<style>
body {background-color: white;background-repeat: no-repeat;background-position: center;}
h1   {color: blue;}
p    {color: red;}
tr   {color:red}
h1	{margin: 100px}
form   { margin: 200px;}

</style>
</head>
<body>
	<div align="center">
		<h1>Windsor Data Portal</h1>
		<form action="<%= request.getContextPath() %>/request" method="post"
			enctype="multipart/form-data">
			<h2>User request</h2>
			<table style="with: 80%" >
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