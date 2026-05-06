<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h1>Welcome to the Admin Page</h1>
<p>This page is accessible only to users with the ADMIN role.</p>



<!-- Security tags -->
<p>Logged in as: <strong><security:authentication property="name" /></strong></p>
<p>Your roles: <strong><security:authentication property="principal.authorities" /></strong></p>

<form action="${pageContext.request.contextPath}/logoutTheUser" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Logout</button>
</form>
</body>
</html>