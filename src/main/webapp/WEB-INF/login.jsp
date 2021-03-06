<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container create-bg text-light mt-4 py-4 rounded">
        <h1 class="text-center">Please Log In</h1>
        <form action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" <c:if test="${not empty userNameError}"> placeholder="${userNameError}" </c:if>>
            </div>
            <div class="form-group">
                <label for="password" data-error="error">Password</label>
                <input id="password" name="password" class="form-control" type="password" <c:if test="${not empty error}"> placeholder="${error}" </c:if>>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
            <br>
            <p>Not a member?
            <a class="btn btn-primary" href="/register">Register here!</a></p>
        </form>
    </div>

</body>
</html>
