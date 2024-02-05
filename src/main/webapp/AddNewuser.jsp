<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add User Details</title>
</head>
<body>
    <h2>Add User Details</h2>

    <form action="AddNewuser" method="post" id="userForm">
    
        <label for="Id">Id:</label>
        <input type="number" id="Id" name="Id" required>
        <br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>

        <label for="phone">Phone Number:</label>
        <input type="number" id="phone" name="phoneNumber" required>
        <br><br>

        <label for="company">Company:</label>
        <input type="text" id="company" name="company" required>
        <br><br>

        <label for="email">Email ID:</label>
        <input type="email" id="email" name="emailId" required>
        <br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
        <br><br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>
