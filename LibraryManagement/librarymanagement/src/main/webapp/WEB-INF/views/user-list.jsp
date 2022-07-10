<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Users List</title>
</head>
<body>
	<div class="container">
		<h3>Users List</h3>
		<hr>
		<!-- Add a search form -->
		<form action="search" class="form-inline">
			<!-- Add a button -->
			<a href="showFormForAdd" class="btn btn-primary btn-sm mb-3"> Add
				User </a> <input type="search" name="username" placeholder="username"
				class="form-control-sm ml-5 mr-2 mb-3" /> 
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
			<a href="/logout" class="btn btn-primary btn-sm mb-3 mx-auto">Logout</a>
		</form>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Sr.No.</th>
					<th>Username</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.username}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="showFormForUpdate?userId=${user.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="delete?userId=${user.id}" class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<a href="/">Back to Home Page</a>
	</div>
</body>
</html>