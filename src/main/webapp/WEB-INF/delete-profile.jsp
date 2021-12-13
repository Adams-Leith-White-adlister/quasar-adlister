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
	<h1>Are you sure?</h1>
	<p>This will delete your profile and ads.</p>
	<form action="/delete-profile" method="post">
		<button type="submit" name="editId" value="${user.id}" class="btn btn-block btn-danger">Delete</button>
	</form>
	<button type="submit" onclick="history.back()" class="btn btn-block btn-primary">Go Back</button>
</div>
</body>
</html>
