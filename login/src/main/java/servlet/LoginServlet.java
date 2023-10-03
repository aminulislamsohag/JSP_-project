package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doa.Database;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Database db = new Database();
        
        boolean isAuthenticated = false;
        isAuthenticated = db.checklogin(username, password);
        if(isAuthenticated) {
        	HttpSession session = request.getSession();
        	session.setAttribute("username", username);
        	response.sendRedirect("welcome.jsp");
        }
        else {
        	response.sendRedirect("login.jsp?error=true");
        }
		
	}

}
