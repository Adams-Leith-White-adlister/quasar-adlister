<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Results"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="container">
        <h1 class="text-center mt-2">Here are your search results for "<c:out value="${userSearch}"/>"</h1>
        <c:choose>
            <c:when test="${cars.isEmpty()}">
                <h1 class="text-center">No results found</h1>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <c:forEach var="car" items="${cars}">
                        <div class="col-12 col-sm-6 col-lg-4 text-center">
                            <div class="card mb-3 shadow border-danger">
                                <div class="bg-dark text-light rounded-lg">
                                    <h4 class="card-header"><c:out value="${car.year} ${car.make} ${car.model}"/></h4>
                                    <div class="card-body">
                                        <h5 class="card-title">$<f:formatNumber type="number" pattern="0.00" value="${car.price}"/></h5>
                                        <span class="text-muted">Description: </span>
                                        <p class="card-text"><c:out value="${car.description}"/></p>
                                        <a href="${pageContext.request.contextPath}/view-car/?carId=${car.id}" class="btn btn-outline-danger card-link">View
                                            Car</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
