package doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CustomerEntity;

public class CustomerDatabase {

	//Variable declare
	private String jdbcURL = "jdbc:mysql://localhost:3306/customers?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customertb" + "  (name, sname, category, country) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_ALL_CUSTOMER = "select * from customertb";
	private static final String DELETE_CUSTOMER_SQL = "delete from customertb  where id = ?;";
	private static final String SELECT_CUSTOMER_BY_ID = "select id,name,sname,category,country from customertb where id =?";
	private static final String UPDATE_CUSTOMER_SQL = "update customertb set name = ?,sname= ?, category= ?, country =? where id = ?;";
	
	//Default constructor 
	public CustomerDatabase() {
	}
	
	//create connection to database 
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		} 	
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//Add new customer in data base
	public void insertCustomer(CustomerEntity cust) throws SQLException {
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
		// Step 2: pass parameter
			preparedStatement.setString(1, cust.getName());
			preparedStatement.setString(2, cust.getSname());
			preparedStatement.setString(3, cust.getCategory());
			preparedStatement.setString(4, cust.getCountry());
			preparedStatement.executeUpdate();
		} 
		 catch (SQLException e) {
			 printSQLException(e);
		}
	}
	
	//show all customers in jsp page
		 public List<CustomerEntity> selectAllCustomer() {
			 //Create ArrayList
			 List<CustomerEntity> customer = new ArrayList<>();
			
			   // Step 1: Establishing a Connection
			 try (Connection connection = getConnection();
			   // Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
			   // Step 3: Execute the query and return preparedStatement ResultSet that store in rs 
				ResultSet rs = preparedStatement.executeQuery();
			   // Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String sname = rs.getString("sname");
					String category = rs.getString("category");
					String country = rs.getString("country");
					customer.add(new CustomerEntity(id, name, sname, category, country));
				 }
			 }
			 catch (SQLException e) {
				 printSQLException(e);
			}
			return customer;
		}

		 //Delete Customer by id
		  public boolean deleteCustomer(int id) throws SQLException {
			boolean rowDeleted;
			// Step 1: Establishing a Connection
			  try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
			// Step 3: pass parameter by id	
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			 }
			return rowDeleted;
		}
			 
		//Select customer by id to show update jsp page
		  public CustomerEntity selectCustomer(int id) {
			     CustomerEntity customer = null;
			 // Step 1: Establishing a Connection
			 try (Connection connection = getConnection();
			 // Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
			 // Step 3: pass parameter by id	
				 preparedStatement.setInt(1, id);
			 // Step 4: Execute the query and return preparedStatement ResultSet that store in rs
				ResultSet rs = preparedStatement.executeQuery();
			 // Step 5: Process the ResultSet object.
				while (rs.next()) {
					String name = rs.getString("name");
					String sname = rs.getString("sname");
					String category = rs.getString("category");
					String country = rs.getString("country");
					customer = new CustomerEntity(id, name, sname, category, country);
				}
			} 
			 catch (SQLException e) {
				printSQLException(e);
			}
			return customer;
		}	 
		  
 //Update Customer
		  public boolean updateCustomer(CustomerEntity customer) throws SQLException {
			boolean rowUpdated;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
				statement.setString(1, customer.getName());
				statement.setString(2, customer.getSname());
				statement.setString(3, customer.getCategory());
				statement.setString(4, customer.getCountry());
				statement.setInt(5, customer.getId());
				
				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
		  
		    
	//Exception handle
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	

}
