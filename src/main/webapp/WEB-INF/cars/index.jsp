<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Cars"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Here are all the cars!</h1>

    <div class="row">
        <c:forEach var="car" items="${cars}">
            <div class="col-12 col-sm-6 col-lg-4">
                <div class="card mb-3 shadow border-danger">
                    <div class="card-body bg-dark text-light rounded-lg">
                        <h4 class="card-title"><c:out value="${car.year} ${car.make} ${car.model}"/></h4>
                        <h5 class="card-subtitle">$<c:out value="${car.price}"/></h5>
                        <p class="card-text"><c:out value="${car.description}"/></p>
                        <a href="${pageContext.request.contextPath}/viewcar/?carId=${car.id}" class="card-link">View
                            Car</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
