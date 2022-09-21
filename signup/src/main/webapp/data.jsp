
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>





	<%
	Connection con = null;
	Statement smt = null;
	ResultSet rs = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "root");
		smt = con.createStatement();
		String sql = "select * from users";
		rs = smt.executeQuery(sql);

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	%>



	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">ALL DATA</h2>

						<form method="" action="">

							<table border="1">
								<tr>
									<td>ID</td>
									<td>User Name</td>
									<td>User Email</td>
									<td>User Mobile</td>

								</tr>
								<%
								try {

									while (rs.next()) {
								%>
								<tr>
									<td><%=rs.getString("id")%></td>
									<td><%=rs.getString("uname")%></td>
									<td><%=rs.getString("uemail")%></td>
									<td><%=rs.getString("umobile")%></td>

								</tr>
								<%
								}
								con.close();
								} catch (Exception e) {
								e.printStackTrace();
								}
								%>
							</table>


						</form>
						<br> <br> <a href="index.jsp" class="signup-image-link">Back
							to home page</a>

					</div>

				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">




</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>