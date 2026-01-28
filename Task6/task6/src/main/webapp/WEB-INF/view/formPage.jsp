<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Form</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <h2 class="text-center mb-4">Empolyee Registration Form</h2>

            <form:form
                    action="${pageContext.request.contextPath}/processForm"
                    modelAttribute="userModel"
                       class="p-4 border rounded bg-white shadow-sm">

                <div class="form-group mb-3">
                    <form:label path="username">username</form:label>
                    <form:input path="username"
                                placeholder="Enter Username"
                                class="form-control" />
                    <form:errors path="username" cssClass="text-danger"/>
                </div>
                  <br>
                <div class="form-group mb-3">
                    <form:label path="email">Email</form:label>
                    <form:input path="email"
                                type="email"
                                placeholder="example@email.com"
                                class="form-control" />
                    <form:errors path="email" cssClass="text-danger"/>
                </div>


                <br>
                <div class="form-group mb-3">
                    <form:label path="password">Password</form:label>
                    <form:input path="password"
                                type="password"
                                class="form-control" />
                    <form:errors path="password" cssClass="text-danger"/>
                </div>

                <br>
                <div class="form-group mb-3">
                    <form:label path="confirmPassword">Confirm Password</form:label>
                    <form:input path="confirmPassword"
                                type="password"
                                class="form-control" />
                    <form:errors path="confirmPassword" cssClass="text-danger"/>
                </div>

                <div class="form-group text-center">
                    <input type="submit"
                           value="Submit"
                           class="btn btn-danger w-100" />
                </div>

            </form:form>

        </div>
    </div>
</div>
</body>
</html>
