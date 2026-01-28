<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration Successful</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<div class="container">
    <h2 class="success">Registration completed successfully!</h2>

    <div class="card">

        <p><span>username:</span> ${user.username}</p>
        <p><span>Email:</span> ${user.email}</p>


    </div>
</div>

</body>
</html>
