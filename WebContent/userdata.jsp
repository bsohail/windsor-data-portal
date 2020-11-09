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
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Company</td>
     <td><input type="text" name="companyname" /></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><input type="text" name="description" /></td>
    </tr>
    <tr>
     <td>File</td>
     <td><input type="text" name="file" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>