<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System Page</title>
</head>
<body>
<h1>Welcome to the System Page</h1>
<p>This page is accessible to System Rules.</p>

<form action="${pageContext.request.contextPath}/logoutTheUser" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Logout</button>
</form>
</body>
</html>