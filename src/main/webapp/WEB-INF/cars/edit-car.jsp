<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Car"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container create-bg text-light mt-4 py-4 rounded">
    <h1 class="text-center">Edit Car:</h1>
    <form action="/edit-car/*" method="post">
        <div class="form-group">
            <label for="year">Year</label>
            <input id="year" name="year" class="form-control" type="text" value="${car.year}" required>
        </div>
        <div class="form-group">
            <label for="make">Make</label>
            <input id="make" name="make" class="form-control" type="text" value="${car.make}" required>
        </div>
        <div class="form-group">
            <label for="model">Model</label>
            <input id="model" name="model" class="form-control" type="text" value="${car.model}" required>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" name="price" class="form-control" id="price"
                   pattern="[0-9]+([\.,][0-9]+)?" step="0.01"
                   title="This should be a number with up to 2 decimal places." value="${car.price}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" maxlength="280"
                      required>${car.description}</textarea>
        </div>
        <button type="submit" name="editId" value="${car.id}" class="btn btn-block btn-primary">Submit Changes</button>
        <a class="btn btn-primary mt-2" href="/profile">Back to profile</a>
    </form>
</div>
</body>
</html>
