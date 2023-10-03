package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doa.Database;
import model.SingUpEntity;


public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=null;
		try {
		String email = request.getParameter("email");
		Database db = new Database();
		boolean isAuthenticatedemail = false;
        isAuthenticatedemail = db.checkemail(email);
        
        if(isAuthenticatedemail) {
        	SingUpEntity useid = new SingUpEntity(email);
        	userid = db.useridfind(useid);
        	System.out.println(userid);
        	request.setAttribute("email", email);
        	request.setAttribute("username", userid);
        	request.getRequestDispatcher("forgotuser.jsp").forward(request, response);
			//response.sendRedirect("forgotuser.jsp"); 	
        }
        else {
        	response.sendRedirect("signup.jsp?usernmnot=false");
        }
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
        
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		String email = request.getParameter("email");
		String newpassword = request.getParameter("newpassword");
        Database db = new Database();
        
        boolean isAuthenticatedemail = false;
        isAuthenticatedemail = db.checkemail(email);
        if(isAuthenticatedemail) {
        	SingUpEntity np = new SingUpEntity(newpassword, email);
				db.resetpass(np);
			response.sendRedirect("login.jsp?rstpssuccess=true"); 	
        }
        else {
        	response.sendRedirect("forgotpassword.jsp?rstpssuccess=false");
        }	
		
			} catch (SQLException e) {
				e.printStackTrace();
		}
		
		
	}
	
	
	
}
