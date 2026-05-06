<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="login-box">
    <h2>Login</h2>

    <c:if test="${param.error != null}">
        <p style="color:red;">Invalid username or password</p>
    </c:if>

    <c:if test="${param.logout != null}">
        <p style="color:green;">You have been logged out</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
        <!-- CSRF token -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <input type="text" name="username" placeholder="Username" required />
        <input type="password" name="password" placeholder="Password" required />
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>