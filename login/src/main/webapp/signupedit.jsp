<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3>Sign Up</h3>
                    </div>
                    <div class="card-body">
                        <form action="Signup" method="POST">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" value="${username}" class="form-control" id="username" name="username" autofocus required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" value="${password}" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" value="${email}" class="form-control" id="email" name="email" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Sign Up</button>
                        </form>
                        
              <%-- Display already user exist --%>
                        <c:if test="${param.success == 'false'}">
                            <div class="alert alert-success mt-3" role="alert">
                                Already User Exists...Please try again
                            </div>
                        </c:if> 
                        
                        
                    </div>
                    <div class="card-footer">
                        <p>Already have an account? <a href="login.jsp">Login</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
