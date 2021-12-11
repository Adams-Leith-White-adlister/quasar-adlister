<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Here are your search results!</h1>

    <div class="row">
        <c:forEach var="car" items="${cars}">
            <div class="col-12 col-sm-6 col-lg-4">
                <div class="card mb-2">
                    <div class="card-body">
                        <h2 class="card-title">${car.make}</h2>
                        <h3 class="card-subtitle mb-1">${car.model}</h3>
                        <h4 class="card-subtitle mb-1">${car.year}</h4>
                        <h4 class="card-subtitle">${car.price}</h4>
                        <p class="card-text">${car.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
