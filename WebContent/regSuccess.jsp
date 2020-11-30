<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.request.controller.Logout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Requests</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4753d6;
  color: white;
}
.button {
  background-color: #4753d6;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

</style>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/info"
        user="root" password="2512"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM data;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5" id="customers">
            <caption><h2>List of Requests</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Company Name</th>
                <th>Description</th>
                <th>File</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.companyname}" /></td>
                    <td><c:out value="${user.description}" /></td>
                    <td><c:out value="${user.file}" /></td>
                </tr>
            </c:forEach>
        </table>
        <a href=";/logout" class="button" >Logout</a>
    </div>
</body>
</html>