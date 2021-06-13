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
<title>Student Details</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #fcba03;">
			<div class="container-fluid">
				<a class="navbar-brand h1" href="studentList">Student management application</a>
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


			<div class="h1">Student Details</div>
			<form:form action="/showStudents" method="POST"
				modelAttribute="student">
			
				Name:
				<form:input class="form-control" path="name" />
				
				Division:
			  	<form:select class="form-control" path="division.division">
					<form:option value="A" label="A" />
					<form:option value="B" label="B" />
					<form:option value="C" label="C" />
					<form:option value="D" label="D" />
				</form:select> 
				
				Age
				<form:input type="number" class="form-control" path="age" />
				<div class="h3"> Scores : </div>
				<div class="container w-50">
					Physics :
					<form:input type="number" class="form-control"
						path="marks.physicsScore" />
					
					Chemistry :
					<form:input type="number" class="form-control"
						path="marks.chemistryScore" />
					
					Maths :
					<form:input type="number" class="form-control"
						path="marks.mathScore" />
				
				</div>


				<input class="btn mt-2" style="background-color: #d4cf72;" type="submit" value="Submit" />
			</form:form>
		</div>
	</section>
</body>
</html>