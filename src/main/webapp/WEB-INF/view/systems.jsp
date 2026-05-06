<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Welcome to the Home Page</h1>
<p>This page is accessible to all users.</p>

<security:authorize access="isAuthenticated()">
    <p>Logged in as: <strong><security:authentication property="name" /></strong></p>
    <p>Your roles: <strong><security:authentication property="principal.authorities" /></strong></p>
    <form action="${pageContext.request.contextPath}/logoutTheUser" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Logout</button>
    </form>
</security:authorize>

<security:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}/showLoginPage">Login</a>
</security:authorize>

</body>
</html>