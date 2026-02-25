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
                    <h4 class="mb-0">${product.name}
                        <small class="text-muted float-right"># ${product.id}</small>
                    </h4>
                </div>
                <div class="card-body">
                    <table class="table table-bordered mb-0">
                        <tr><th>Expiration Date</th><td>${product.expirationDate}</td></tr>
                        <tr><th>Manufacturer</th><td>${product.manufacturer}</td></tr>
                        <tr><th>Price</th><td class="test font-weight-bold">$${product.price}</td></tr>
                        <tr>
                            <th>Availability</th>
                            <td>
                                <c:choose>
                                    <c:when test="${product.available}">
                                        <span class="badge badge-success">In Stock</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-danger">Out of Stock</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="card-footer">
                    <a href="${pageContext.request.contextPath}" class="btn btn-dark">
                        &larr; Back to Products
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>