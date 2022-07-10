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
<title>Book Form for ${mode}</title>
</head>
<body>
	<div class="container">
		<h3>Book Form for ${mode}</h3>
		<hr>
		<p class="h4 mb-4">Enter Book</p>
		<form action="/books/save" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${book.id}" />
			<div class="form-inline">
				<input type="text" name="title" value="${book.title}"
					class="form-control mb-4 col-4" placeholder="Title">
			</div>
			<div class="form-inline">
				<input type="text" name="author" value="${book.author}"
					class="form-control mb-4 col-4" placeholder="Author">
			</div>
			<div class="form-inline">
				<input type="text" name="category" value="${book.category}"
					class="form-control mb-4 col-4" placeholder="Category">
			</div>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<hr>
		<a href="list">Back to Books List</a>
	</div>
</body>
</html>