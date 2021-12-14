<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Post an ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

    <div class="container create-bg text-light mt-4 py-4 rounded">
        <h1 class="text-center">Post an Ad</h1>
        <form action="/cars/create" method="post">
            <div class="form-group">
                <label for="year">Year</label>
                <input id="year" name="year" class="form-control" type="text" pattern="\d{4}" maxlength="4" required>
            </div>
            <div class="form-group">
                <label for="make">Make</label>
                <input id="make" name="make" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="model">Model</label>
                <input id="model" name="model" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input id="price" name="price" class="form-control" type="text" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary" value="Submit">
        </form>
    </div>
</body>
</html>
