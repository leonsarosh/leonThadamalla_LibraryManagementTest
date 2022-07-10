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
<title>User From for ${mode}</title>
</head>
<body>
	<div class="container">
		<h3>User From for ${mode}</h3>
		<hr>
		<p class="h4 mb-4">Enter User</p>
		<form action="saveUser" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${user.id}" />
			<div class="form-inline">
				<input type="text" name="username" value="${user.username}"
					class="form-control mb-4 col-4" placeholder="username">
			</div>
			<div class="form-inline">
				<input type="text" name="password" value="${user.password}"
					class="form-control mb-4 col-4" placeholder="password">
			</div>
			<div class="form-inline">
				<input type="text" name="role1" value="${user.roles}"
					class="form-control mb-4 col-4" placeholder="ADMIN/USER">
			</div>
			<!-- <h6>Select Roles:-</h6><br>
			<input type="checkbox" name="role1" id="role1" value="ADMIN">
			<label for="role1">ADMIN</label><br>
			<input type="checkbox" name="role2" id="role2" value="USER">
			<label for="role2">USER</label><br>-->
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<hr>
		<a href="list">Back to Users List</a>
	</div>
</body>
</html>