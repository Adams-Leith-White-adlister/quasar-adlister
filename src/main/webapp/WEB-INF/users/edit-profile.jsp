<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Edit Your Profile"/>
  </jsp:include></head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
  <button type="button" class="btn btn-outline-danger mt-4" onclick="history.back()">Back</button>
</div>
<div class="container create-bg text-light mt-4 py-4 rounded">
  <h1 class="text-center">Edit Profile</h1>
  <form action="/edit-profile" method="post">
    <div class="form-group">
      <label for="username">Name</label>
      <input id="username" name="username" class="form-control" type="text" minlength="4" value="${user.username}" required>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input id="email" name="email" class="form-control" type="email" value="${user.email}" required>
    </div>
    <div class="form-group">
      <label for="password">New Password</label>
      <input id="password" name="password" class="form-control" minlength="8" type="text" required>
    </div>
    <button type="submit" name="editId" value="${user.id}" class="btn btn-block btn-primary">Submit Changes</button>

  </form>
  <a href="/delete-profile" class="btn btn-danger">Delete Profile</a>
</div>

</body>
</html>
