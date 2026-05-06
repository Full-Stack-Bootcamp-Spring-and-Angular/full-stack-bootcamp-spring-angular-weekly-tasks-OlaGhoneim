<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<h1>Access Denied</h1>
<p>Sorry, <strong><security:authentication property="principal.username" /></strong>,
    you don't have permission to access this page.</p>

<a href="${pageContext.request.contextPath}/">Go to Home</a>
</body>
</html>