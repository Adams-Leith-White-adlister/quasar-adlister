<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Edit Your Profile"/>
  </jsp:include></head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
<p>This is the edit profile jsp</p>
  <form action="/edit-profile" method="post">
    <div class="form-group">
      <label for="username">Name</label>
      <input id="username" name="username" class="form-control" type="text" value="${user.username}" required>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input id="email" name="email" class="form-control" type="email" value="${user.email}" required>
    </div>
    <div class="form-group">
      <label for="password">New Password</label>
      <input id="password" name="password" class="form-control" type="text" required>
    </div>
    <button type="submit" name="editId" value="${user.id}" class="btn btn-block btn-primary">Submit Changes</button>

  </form>

</div>

</body>
</html>
