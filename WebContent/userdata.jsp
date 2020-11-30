<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
<link rel="stylesheet" href="login.css" type="text/css">
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
					<td>
					<br>
					<label for="file-upload" class="custom-file-upload">
    					Custom Upload
					</label>
					<input id="file-upload" type="file" name="data"/></td> 
				</tr>
			</table>
			<br>
			<button type="submit" value="Submit" >Submit</button>
		</form>
	</div>
</body>
</html>