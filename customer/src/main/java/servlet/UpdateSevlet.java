package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerEntity;
import doa.CustomerDatabase;


@WebServlet("/Edit")
public class UpdateSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDatabase cdoa = new CustomerDatabase();
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerEntity existingCustomer = cdoa.selectCustomer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update_form.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sname = request.getParameter("sname");
		String category = request.getParameter("category");
		String country = request.getParameter("country");
		
		CustomerEntity uc = new CustomerEntity(id, name, sname,category, country);
		System.out.println(uc);
		CustomerDatabase cdoa = new CustomerDatabase();
		cdoa.updateCustomer(uc);
		response.sendRedirect("List");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
