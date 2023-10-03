package doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SingUpEntity;


public class Database {
	
	//Variable declare
	private String jdbcURL = "jdbc:mysql://localhost:3306/customers?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	

	private static final String SELECT_USER_PASS = "SELECT * FROM users WHERE username = ? AND password = ?";
	private static final String INSERT_CUSTOMER_SQL = "INSERT INTO users" + "  (username, password, email) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER = "SELECT * FROM users WHERE username = ?";
	private static final String SELECT_EMAIL = "SELECT * FROM users WHERE email = ?";
	private static final String RRESTPASS = "UPDATE users set password = ? where email = ?";
	private static final String FIND_USR = "SELECT * FROM users WHERE email = ?";
	
	//Default constructor 
	public Database() {
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
	
	//login authentication password----------------------------------------------------------
	  public boolean checklogin(String uname, String upass){
		 try (
				Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_PASS);){
			 
			 preparedStatement.setString(1, uname);
			 preparedStatement.setString(2, upass);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
			System.out.println("Match password");		
				return true;
			}
			
		} 
		 catch (SQLException e) {
			 e.printStackTrace();
		}
		 System.out.println("Wrong password");
		 return false;
	}
	  
		//sign up authentication----------------------------------------------------------
	  public boolean checkuser(String uname){
		 try (
				Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);){
			 
			 preparedStatement.setString(1, uname);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
			System.out.println("User exist !!");		
				return false;
			}
			
		} 
		 catch (SQLException e) {
			 e.printStackTrace();
		}
		 System.out.println("New user");
		 return true;
	}
	  
	//------------------Signup data insert------------------------------------------------------------  
		public void insertsignup(SingUpEntity si) throws SQLException {
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);) {
			// Step 2: pass parameter
				preparedStatement.setString(1, si.getUsername());
				preparedStatement.setString(2, si.getPassword());
				preparedStatement.setString(3, si.getEmail());
				preparedStatement.executeUpdate();
			} 
			 catch (SQLException e) {
				 e.printStackTrace();
			}
		} 
	//------------------------------password rest email verification----------
		public boolean checkemail(String email){
			 try (
					Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMAIL);){
				 
				 preparedStatement.setString(1, email);
				ResultSet rs = preparedStatement.executeQuery();
				
				if(rs.next()) {
				System.out.println("User exist !!");		
					return true;
				}
				
			} 
			 catch (SQLException e) {
				 e.printStackTrace();
			}
			 System.out.println("User not exist");
			 return false;
		}
		
		public boolean resetpass(SingUpEntity npu) throws SQLException {
			// Step 1: Establishing a Connection
			boolean rowUpdated;
			try (
				Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(RRESTPASS);) {
			// Step 2: pass parameter
				preparedStatement.setString(1,  npu.getPassword());
				preparedStatement.setString(2, npu.getEmail());
				
				rowUpdated = preparedStatement.executeUpdate() > 0;
				return rowUpdated;
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
			return false;
		}
		
//------------------------------Find user ----------	
		
		public String useridfind(SingUpEntity eml) throws SQLException {
			// Step 1: Establishing a Connection
			String userid= null;
			try (
				Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_USR);) {
				
			// Step 2: pass parameter
				preparedStatement.setString(1, eml.getEmail());
				ResultSet rs = preparedStatement.executeQuery();
				
				if(rs.next()) {
					userid = rs.getString("username");
				}
				
		}
			catch (SQLException e) {
			 e.printStackTrace();
		}
			return userid;	
	 }		
	
}
