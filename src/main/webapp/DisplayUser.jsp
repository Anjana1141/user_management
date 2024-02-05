<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List userList =  (List)request.getAttribute("DisplayUser"); %>

	<table border="">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>phoneNumber</th>
			<th>company</th>
			<th>emailId</th>
			<th>address</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<% for (int i = 0; i < userList.size(); i += 6) { %>
		<tr>
			<td><%= userList.get(i) %></td>
			<td><%= userList.get(i + 1) %></td>
			<td><%= userList.get(i + 2) %></td>
			<td><%= userList.get(i + 3) %></td>
			<td><%= userList.get(i + 4) %></td>
			<td><%= userList.get(i + 5) %></td>

			<td><a href="UpdateUser?id=<%= userList.get(i) %>">Update</a></td>
			<td><a href="DeleteUser?id=<%= userList.get(i) %>">Delete</a></td>
			
		</tr>
		<% } %>
	</table>

	
</body>
</html>