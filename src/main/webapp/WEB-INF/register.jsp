<%--comment--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register Account"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container create-bg text-light mt-4 py-4 rounded">
    <h1 class="text-center">Registration Form</h1>
    <form method="post" action="/register">
        <div class="form-group">
            <label for="username">Create Username</label>
            <input id="username" name="username" class="form-control" minlength="4" type="text" required>
        </div>
        <div class="form-group">
            <label for="email">Enter Email</label>
            <input id="email" name="email" class="form-control" type="email" required>
        </div>
        <div class="form-group">
            <label for="password">Create Password</label>
            <input id="password" name="password" class="form-control" minlength="8" type="password" required>
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Register">
    </form>
</div>
</body>
</html>