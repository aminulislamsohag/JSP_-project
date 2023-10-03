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
                        <h3>Forgot Password</h3>
                    </div>
                    <div class="card-body">
                        <p>Enter your email address below to reset your password.</p>
                        <form action="PasswordReset" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">New Password:</label>
                                <input type="password" class="form-control" id="newpassword" name="newpassword" required>
                            </div>
                            
                            <button type="submit" class="btn btn-primary">Reset Password</button>
                        </form>
                        
             <%-- Display Password not rest email not match --%>
                        <c:if test="${param.rstpssuccess == 'false'}">
                            <div class="alert alert-danger mt-3" role="alert">
                                Wrong Email Id. Please try again.
                            </div>
                        </c:if>
                        
                        
                    </div>
                    <div class="card-footer">
                        <a href="login.jsp">Back to Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>