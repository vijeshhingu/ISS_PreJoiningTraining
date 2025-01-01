<!DOCTYPE html>
<html>
<body>
    <h1>Register</h1>
    <form action="register" method="post">
        <label>Username: </label><input type="text" name="username"><br>
        <label>Password: </label><input type="password" name="password"><br>
        <button type="submit">Register</button>
    </form>
    <p style="color: red;">${param.error}</p>
</body>
</html>
