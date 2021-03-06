<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${car.year} ${car.make} ${car.model}"/>
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <div class="row mt-4">
        <div class="col-12" id="card-container">
            <div class="card mb-2 shadow border-danger h-100 text-center">
                <div class="card-body bg-dark text-light rounded-lg">
                    <h1 class="card-title mt-4"><c:out value="${car.year} ${car.make} ${car.model}"/></h1>
                    <h2 class="card-subtitle mt-1">$<f:formatNumber type="number" pattern="0.00" value="${car.price}"/></h2>
                    <p class="card-text"><c:out value="${car.description}"/></p>
                    <p class="card-text text-muted small">Created by: <c:out value="${user.username}"/> | Posted
                        on: ${car.creationDate}</p>
                    <button type="button" class="btn btn-outline-danger" onclick="history.back()">Back</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
