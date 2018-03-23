package manihacke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DAO {

	static String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
	static String dbName = "sql11226982";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "sql11226982"; 
	static String password = "4IltbjKGGQ";

		

	public static boolean insertCustomer(TargetCustomer customer) throws SQLException {
	    Connection conn = DriverManager.getConnection(url+dbName,userName,password);

	   
	    try {
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer VALUES (NULL, ?, ?, ?)");
	        ps.setInt(1, customer.getCID());
	        ps.setString(2,customer.getFirstName());
	        ps.setString(3,customer.getLastName());
	        ps.setString(4, customer.getAddress());
	        ps.setString(4, customer.getCountryCode());
	        ps.setFloat(6,customer.getStatus());

	        int i = ps.executeUpdate();
	      
	        if(i == 1) {
	        return true;
	      }
	        
	    } 
	    
	    catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	
	
	
		
}

	
