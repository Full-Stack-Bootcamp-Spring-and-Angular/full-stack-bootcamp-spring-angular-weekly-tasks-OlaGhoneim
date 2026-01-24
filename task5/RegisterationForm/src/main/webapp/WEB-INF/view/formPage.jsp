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

            <h2 class="text-center mb-4">User Profile Form</h2>

            <form:form
                    action="${pageContext.request.contextPath}/processForm"
                    modelAttribute="userModel"
                       class="p-4 border rounded bg-white shadow-sm">

                <div class="form-group mb-3">
                    <form:input path="firstName"
                                placeholder="First Name"
                                class="form-control" />
                </div>

                <div class="form-group mb-3">
                    <form:input path="lastName"
                                placeholder="Last Name"
                                class="form-control" />
                </div>

                <div class="form-group mb-3">
                    <form:input path="email"
                                type="email"
                                placeholder="Email"
                                class="form-control" />
                </div>

                <div class="form-group mb-3">
                    <form:input path="dateOfBirth"
                                type="date"
                                class="form-control" />
                </div>

                <div class="form-group mb-3">
                    <form:select path="city" class="form-control">
                        <form:option value="" label="-- Select City --"/>
                        <form:option value="Cairo" label="Cairo"/>
                        <form:option value="Alexandria" label="Alexandria"/>
                        <form:option value="Giza" label="Giza"/>
                        <form:option value="Aswan" label="Aswan"/>
                        <form:option value="Luxor" label="Luxor"/>
                        <form:option value="Mansoura" label="Mansoura"/>
                        <form:option value="Tanta" label="Tanta"/>
                        <form:option value="Zagazig" label="Zagazig"/>
                        <form:option value="Ismailia" label="Ismailia"/>
                        <form:option value="Suez" label="Suez"/>
                    </form:select>
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
