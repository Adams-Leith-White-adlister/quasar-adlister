<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--comment--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include></head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="flex-container">
    <div class="col-md-6">
        <h1>${user.username}</h1>
        <h2>${car.make}</h2>
        <h3>${car.model}</h3>
        <h4>${car.price}</h4>
        <p>${car.description}</p>
    </div>
</div>
</body>
</html>
