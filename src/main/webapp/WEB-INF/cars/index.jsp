<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Cars" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here are all the cars!</h1>

    <c:forEach var="car" items="${cars}">
       <a href="${pageContext.request.contextPath}/viewcar/?carId=${car.id}"> <div class="col-md-6">
            <h2>${car.make}</h2>
            <h2>${car.model}</h2>
            <h3>${car.price}</h3>
            <p>${car.description}</p>
        </div>
       </a>
    </c:forEach>
</div>

</body>
</html>
