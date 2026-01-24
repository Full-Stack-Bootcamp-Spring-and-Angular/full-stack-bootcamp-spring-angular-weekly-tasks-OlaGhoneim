<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Submission Result</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<div class="container">
    <h2 class="success">Data submitted successfully</h2>

    <div class="card">
        <p><span>First Name:</span> ${user.firstName}</p>
        <p><span>Last Name:</span> ${user.lastName}</p>
        <p><span>Email:</span> ${user.email}</p>
        <p><span>Date of Birth:</span> ${user.dateOfBirth}</p>
        <p><span>City:</span> ${user.city}</p>
    </div>
</div>

</body>
</html>
