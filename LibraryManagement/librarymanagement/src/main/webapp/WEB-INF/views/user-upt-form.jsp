<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>User Form for ${mode}</title>
</head>
<body>
	<div class="container">
		<h3>User Form for ${mode}</h3>
		<hr>

		<p class="h4 mb-4">Enter User</p>
		<form action="/users/saveUser" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="userId" value="${user.userid}" />
			<div class="form-inline">
				<input type="text" name="username" value="${user.username}"
					class="form-control mb-4 col-4" placeholder="enter username">
			</div>
			<div class="form-inline">
				<input type="text" name="password" value="${user.password}"
					class="form-control mb-4 col-4" placeholder="enter password">
			</div>
			<select name="roles" style="width: 200px;">
				<!--<c:forEach items="${user.roles}" var="roles">
					<option value="${roles.name}">${roles.name}</option>
				</c:forEach>-->
				<option value="ADMIN">ADMIN</option>
				<option value="USER">USER</option>
			</select><br>
			<br>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<hr>
		<a href="list">Back to Users List</a>
	</div>
</body>
</html>