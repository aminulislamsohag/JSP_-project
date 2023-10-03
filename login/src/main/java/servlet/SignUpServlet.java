package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doa.Database;
import model.SingUpEntity;



public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");
	        Database db = new Database();
	        
	        boolean isAuthenticateduser = false;
	        isAuthenticateduser = db.checkuser(username);
	        if(isAuthenticateduser) {
	        	SingUpEntity s = new SingUpEntity(username,password,email);
				System.out.println(s);				
				db.insertsignup(s);
				response.sendRedirect("login.jsp?success=true");
	        }
	        else {
	        	request.setAttribute("username", username);
	        	request.setAttribute("password", password);
	        	request.setAttribute("email", email);
	        	request.getRequestDispatcher("signupedit.jsp?success=false").forward(request, response);
	        }
			
	        
				
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		
        
	}

}
