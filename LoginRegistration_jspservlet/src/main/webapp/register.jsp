<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <h2>Register</h2>
    
    <form action="register" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br><br>

        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" name="confirmPassword" required><br><br>

        <input type="submit" value="Register">
    </form>

    <c:if test="${not empty errorMessage}">
        <div style="color: red;">
            <strong>${errorMessage}</strong>
        </div>
    </c:if>
</body>
</html>
