<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login Page</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3>Login</h3>
                    </div>
                    <div class="card-body">
                        <form action="Login" method="POST">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name="username" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
				<%-- Display wrong password message if the "error" request parameter is present --%>
                        <c:if test="${param.error == 'true'}">
                            <div class="alert alert-danger mt-3" role="alert">
                                Wrong password. Please try again.
                            </div>
                        </c:if>
                       
                <%-- Display successful signup --%>
                        <c:if test="${param.success == 'true'}">
                            <div class="alert alert-success mt-3" role="alert">
                                Sign Up Successful...Please Login
                            </div>
                        </c:if>
                <%-- Display successful reset password --%>
                        <c:if test="${param.rstpssuccess == 'true'}">
                            <div class="alert alert-success mt-3" role="alert">
                                Password Rest Successful...Please Login
                            </div>
                        </c:if>
                               
                        
                    </div>
                    <div class="card-footer">
                        <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
                        <p><a href="forgotpassword.jsp">Forgot Password?</a></p>
                        <p><a href="forgotuser.jsp">Forgot UserName?</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>