package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.CustomerDatabase;
import model.CustomerEntity;

@WebServlet("/Insert")
public class InsertSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String name = request.getParameter("name");
		String sname = request.getParameter("sname");
		String category = request.getParameter("category");
		String country = request.getParameter("country");
		
		CustomerEntity nc = new CustomerEntity(name, sname, category, country);
		System.out.println(nc);
		CustomerDatabase cdoa = new CustomerDatabase();
		cdoa.insertCustomer(nc);
		response.sendRedirect("List");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
