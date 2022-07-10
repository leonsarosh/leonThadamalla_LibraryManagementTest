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
<title>Books Directory</title>
</head>
<body>
	<div class="container">
		<h3>Books Directory</h3>
		<hr>
		<!-- Add a search form -->
		<form action="search" class="form-inline">
			<!-- Add a button -->
			<a href="/books/showFormForAdd" class="btn btn-primary btn-sm mb-3"> Add
				Book </a> <input type="search" name="title" placeholder="Title"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="author" placeholder="Author" class="form-control-sm mr-2 mb-3" />
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
			<a href="/logout" class="btn btn-primary btn-sm mb-3 mx-auto">Logout</a>
		</form>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.category}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/books/showFormForUpdate?bookId=${book.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/books/delete?bookId=${book.id}" class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">
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