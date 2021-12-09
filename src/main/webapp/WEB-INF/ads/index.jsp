<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the cars!</h1>

    <c:forEach var="car" items="${cars}">
        <div class="col-md-6">
            <h2>${car.title}</h2>
            <p>${car.description}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
