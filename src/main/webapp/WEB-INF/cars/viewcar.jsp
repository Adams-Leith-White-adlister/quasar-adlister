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
                    <h4 class="card-title">${car.year} ${car.make} ${car.model}</h4>
                    <h5 class="card-subtitle mb-1">$${car.price}</h5>
                    <p class="card-text">${car.description}</p>
                    <p class="card-text text-muted small">Created by: ${user.username} | Posted on: ${car.creationDate}</p>
                    <button type="button" onclick="history.back()">Back</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
