<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>

    <!-- Bootstrap (optional) -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<div style="width: 300px; margin: 100px auto; text-align: center;">

    <h2>Login</h2>

    <!--  Error message -->
    <c:if test="${param.error != null}">
        <p style="color:red;">
            Invalid username or password
        </p>
    </c:if>

    <!-- 🟢 Logout message -->
    <c:if test="${param.logout != null}">
        <p style="color:green;">
            You have been logged out
        </p>
    </c:if>

    <!-- 🔐 Login Form -->
    <form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

        <div>
            <input type="text" name="username" placeholder="Username" required />
        </div>

        <br/>

        <div>
            <input type="password" name="password" placeholder="Password" required />
        </div>

        <br/>

        <div>
            <input type="submit" value="Login" />
        </div>

    </form>

</div>

</body>
</html>