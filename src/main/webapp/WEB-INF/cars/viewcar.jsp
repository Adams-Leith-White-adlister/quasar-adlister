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

<div class="container">
    <p>this page will show one car. <c:out value="${car.getMake()}"/></p>

        <p>${carMake}</p>
        <p>${carModel}</p>


<%--    <c:forEach var="car" items="${car}">--%>
<%--         <div class="col-md-6">--%>
<%--            <h2>${car.make}</h2>--%>
<%--            <h2>${car.model}</h2>--%>
<%--            <h3>${car.price}</h3>--%>
<%--            <p>${car.description}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

<%--    <p>${car.make}</p>--%>
<%--    <p>${car.model}</p>--%>
<%--    <p><c:out value="${car.price}"/></p>--%>
<%--    <p><c:out value="${car.description}"/></p>--%>


</div>


</body>
</html>
