<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #fcba03;">
			<div class="container-fluid">
				<a class="navbar-brand h1" href="#">Student management application</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="studentForm">Add Marks</a></li>
						<li class="nav-item"><a class="nav-link active" href="divisions">Ranklist</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<section>
		<div class="container w-50 mt-5">
			<div class="h1">Student List</div>
			<table class="table">
				<thead style="background-color: #fcba03;">
					<tr>
						<th>No</th>
						<th>Name</th>
						<th>Age</th>
						<th>Division</th>
						<th>Total marks</th>
					</tr>
				</thead>

				<c:forEach var="student" items="${students}">
						<tr>
							<td></td>
							<td>${student.name}</td>
							<td>${student.age}</td>
							<td>${student.division.division}</td>
							<td>${student.marks.physicsScore + student.marks.chemistryScore + student.marks.mathScore}</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	<style>
		table {
			counter-reset: rowNumber;
		}
		
		table tbody tr {
			counter-increment: rowNumber;
		}
		
		table tbody tr td:first-child::before {
			content: counter(rowNumber);
			min-width: 1em;
			margin-right: 0.5em;
		}
	</style>
</body>
</html>