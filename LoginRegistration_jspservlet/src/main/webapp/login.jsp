<!DOCTYPE html>
<html>
<body>
    <h1>Login</h1>
    <form action="login" method="post">
        <label>Username: </label><input type="text" name="username"><br>
        <label>Password: </label><input type="password" name="password"><br>
        <button type="submit">Login</button>
    </form>
    <p style="color: red;">${param.error}</p>
</body>
</html>
