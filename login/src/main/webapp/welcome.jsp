<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
		<%
		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
		}
			
		%>

  <h2>Welcome ${username}</h2>
  
      <form action="Logout" >       
        <input type="submit" value="LOGOUT">
    </form>

</body>
</html>