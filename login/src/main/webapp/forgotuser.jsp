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
                        <h3>Search User Name</h3>
                    </div>
                    <div class="card-body">
                        <p>Enter your email address below to see user name.</p>
                        <form action="PasswordReset" method="Get">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            
                            <button type="submit" class="btn btn-primary">See UserName</button>
                        </form>
                   <%-- Display user id --%>
                        <c:if test="${not empty username}">
                            <div class="alert alert-success mt-3" role="alert">
                            	Email : ${email}
                            	<br>
                                This Username is : ${username}
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