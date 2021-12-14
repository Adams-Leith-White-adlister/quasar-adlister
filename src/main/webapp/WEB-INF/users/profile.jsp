<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <h1 class="text-center mt-2">Welcome, <c:out value="${sessionScope.user}"/>!</h1>
   <div class="d-flex align-items-end flex-column bd-highlight mb-3">
       <a href="/edit-profile" class="btn btn-outline-danger" id="edit">Edit My Profile</a>
   </div>
    <div class="row">
        <c:forEach var="car" items="${cars}">
        <div class="col-12 col-sm-6 col-lg-4 text-center">
            <div class="card mb-3 shadow border-danger">
                <div class="bg-dark text-light rounded-lg">
                    <h4 class="card-header"><c:out value="${car.year} ${car.make} ${car.model}"/></h4>
                    <div class="card-body py-0 pt-2">
                        <h5 class="card-title">$<f:formatNumber type="number" pattern="0.00" value="${car.price}"/></h5>
                        <span class="text-muted">Description: </span>
                        <p class="card-text"><c:out value="${car.description}"/></p>
                        <a href="${pageContext.request.contextPath}/edit-car/?carId=${car.id}" class="btn btn-block btn-primary mb-2">Edit Car</a>
                        <form action="/profile" method="post">
                            <button type="submit" name="carId" value="${car.id}" class="btn btn-block btn-danger"><i class="bi bi-trash"></i></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</c:forEach>
    </div>
</div>

</body>
</html>
