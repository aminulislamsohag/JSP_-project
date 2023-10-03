<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>Customer Home Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #3e4145">


			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/List"
					class="nav-link">Show Customer list</a></li>
				<li><a href="new_form.jsp" class="nav-link">Add Customer</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li><a href="<%=request.getContextPath()%>/Logout"
					class="nav-link">LOGOUT</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Welcome ${username}</h3>
			<br>
		</div>
	</div>




</body>
</html>