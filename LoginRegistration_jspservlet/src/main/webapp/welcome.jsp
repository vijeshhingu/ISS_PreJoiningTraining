<%@ page session="true" %>
<!DOCTYPE html>
<html>
<body>
    <h1>Welcome, ${sessionScope.username}</h1>
    <form action="logout.jsp" method="post">
        <button type="submit">Logout</button>
    </form>
</body>
</html>
