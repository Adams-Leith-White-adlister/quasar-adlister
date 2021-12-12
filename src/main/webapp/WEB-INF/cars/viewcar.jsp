<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--comment--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <div class="row mt-4">
        <div class="col-12 col-sm-6 col-lg-4">
            <div class="card mb-2 shadow border-danger">
                <div class="card-body bg-dark text-light rounded-lg">
                    <h2 class="card-title">${car.make}</h2>
                    <h3 class="card-subtitle mb-1">${car.model}</h3>
                    <h4 class="card-subtitle mb-1">${car.year}</h4>
                    <h4 class="card-subtitle mb-1">${car.price}</h4>
                    <p class="card-text">${car.description}</p>
                    <p class="card-text text-muted small">Created by: ${user.username}</p>
                    <a href="${pageContext.request.contextPath}/edit-car/?carId=${car.id}">Edit Car</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
