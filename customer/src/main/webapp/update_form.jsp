<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>


<html>
<head>
<title>update form</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">

			<ul class="navbar-nav">
				<li><a href="List" class="nav-link">Back to See List</a></li>
			</ul>
		</nav>
	</header>
	
	
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="Edit" method="POST">


				<caption>
				<h2>  Edit Customer</h2>
				</caption>

				<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
				

				<fieldset class="form-group">
					<label>Customer Name</label> <input type="text"
						value="<c:out value='${customer.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Short name</label> <input type="text"
						value="<c:out value='${customer.sname}' />" class="form-control"
						name="sname">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Category</label> <input type="text"
						value="<c:out value='${customer.category}' />" class="form-control"
						name="category" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Country</label> <input type="text"
						value="<c:out value='${customer.country}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Update</button>	

				
				
				</form>
			</div>
		</div>
	</div>
</body>
</html>