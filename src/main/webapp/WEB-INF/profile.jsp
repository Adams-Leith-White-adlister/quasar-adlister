<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, <c:out value="${sessionScope.user}"/>!</h1>
    <div class="row">
        <c:forEach var="car" items="${cars}">
        <div class="col-12 col-sm-6 col-lg-4">
            <div class="card mb-3 shadow border-danger">
                <div class="card-body bg-dark text-light rounded-bg">
                    <h2 class="card-title">${car.make}</h2>
                    <h2 class="card-subtitle mb-1">${car.model}</h2>
                    <h4 class="card-subtitle mb-1">${car.year}</h4>
                    <h3 class="card-subtitle">${car.price}</h3>
                    <p class="card-text">${car.description}</p>
                    <a href="${pageContext.request.contextPath}/edit-car/?carId=${car.id}">Edit Car</a>
                    <form action="/profile" method="post">
                        <button type="submit" name="carId" value="${car.id}" class="btn btn-block btn-primary">Delete</button>
                    </form>

                </div>
            </div>
        </div>
</c:forEach>
    </div>
</div>

</body>
</html>
