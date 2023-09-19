package doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {
	
	//Variable declare
	private String jdbcURL = "jdbc:mysql://localhost:3306/customers?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	

	private static final String SELECT_USER_PASS = "SELECT * FROM users WHERE username = ? AND password = ?";
	
	
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
	
	//Select USER and password
	  public boolean checkuser(String uname, String upass){
		 try (
				Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_PASS);){
			 
			 preparedStatement.setString(1, uname);
			 preparedStatement.setString(2, upass);
			ResultSet rs = preparedStatement.executeQuery();
			
			//if(rs.next()) {
			//	return true;
			//}
			while (rs.next()) {
				String duname = rs.getString("username");
				String dupass = rs.getString("password");
				
				if(duname.equals(uname) && dupass.equals(upass)){	
					System.out.println("Mathch the password");
					
					return true;
				}
				
			}
			
		

		} 
		 catch (SQLException e) {
			 e.printStackTrace();
		}
 System.out.println("Wrong password");
		 return false;
	}
	
	
}
