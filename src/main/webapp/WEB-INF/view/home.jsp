<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Welcome to the Home Page</h1>
<p>This page is accessible to all users.</p>

<!-- REPLACE your old form with this -->
<form action="${pageContext.request.contextPath}/logoutTheUser" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Logout</button>
</form>
</body>
</html>