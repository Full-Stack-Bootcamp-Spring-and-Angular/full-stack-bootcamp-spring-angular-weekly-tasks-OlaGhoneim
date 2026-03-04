<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body class="bg-light">

<div class="container py-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="font-weight-bold mb-0">Products Data</h2>
        <form:form action="${pageContext.request.contextPath}/showAddProduct">
            <input type="submit" class="btn btn-success" value="+ Add new Product"/>
        </form:form>
    </div>

    <div class="card shadow">
        <div class="card-body p-0">
            <table class="table table-hover mb-0">
                <thead class="thead-dark">
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Show Details</th>
                    <th>Add/Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productsList}" var="item">
                    <tr>
                        <td class="align-middle text-muted">${item.id}</td>
                        <td class="align-middle font-weight-bold">${item.name}</td>
                        <td class="align-middle">
                            <form:form action="${pageContext.request.contextPath}/showProductDetails" method="post">
                                <input type="hidden" name="id" value="${item.id}"/>
                                <input type="submit" class="btn btn-primary btn-sm" value="View Details"/>
                            </form:form>
                        </td>
                        <td class="align-middle">
                            <form:form action="${pageContext.request.contextPath}/showUpdateProduct" method="post">
                                <input type="hidden" name="id" value="${item.id}"/>
                                <input type="submit" class="btn btn-warning btn-sm" value="Add/update Details"/>
                            </form:form>
                        </td>
                        <td class="align-middle">
                            <form:form action="${pageContext.request.contextPath}/deleteProduct" method="post">
                                <input type="hidden" name="id" value="${item.id}"/>
                                <input type="submit" class="btn btn-danger btn-sm" value="Delete"/>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>