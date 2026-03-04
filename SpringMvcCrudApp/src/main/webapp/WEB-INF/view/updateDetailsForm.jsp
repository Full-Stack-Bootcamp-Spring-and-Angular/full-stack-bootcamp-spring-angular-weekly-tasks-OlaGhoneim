<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body class="bg-light">
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">

                <div class="card-header bg-dark text-white">
                    <h4 class="mb-0">Update Product</h4>
                </div>

                <div class="card-body">
                    <form:form action="${pageContext.request.contextPath}/processUpdateProduct"
                               modelAttribute="product" method="post">

                        <form:input type="hidden" path="id"/>
                        <form:input type="hidden" path="product.id"/>

                        <div class="form-group">
                            <label>Product Name</label>
                            <form:input type="text" cssClass="form-control" path="name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label>Expiration Date</label>
                            <form:input type="text" cssClass="form-control" path="expirationDate" placeholder="yyyy-MM-dd"/>
                            <form:errors path="expirationDate" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label>Manufacturer</label>
                            <form:input type="text" cssClass="form-control" path="manufacturer"/>
                            <form:errors path="manufacturer" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label>Price</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">$</span>
                                </div>
                                <form:input type="text" cssClass="form-control" path="price"/>
                            </div>
                            <form:errors path="price" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label>Availability</label>
                            <form:input type="text" cssClass="form-control" path="available" placeholder="true or false"/>
                            <form:errors path="available" cssClass="error"/>
                        </div>

                        <div class="d-flex justify-content-between mt-4">
                            <a href="${pageContext.request.contextPath}" class="btn btn-secondary">
                                &larr; Cancel
                            </a>
                            <input type="submit" class="btn btn-dark" value="Save Changes"/>
                        </div>

                    </form:form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>