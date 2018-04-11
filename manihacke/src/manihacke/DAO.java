package manihacke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {

	static String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
	static String dbName = "sql11228437";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "sql11228437"; 
	static String password = "YGfgE5q4J9";

	
	
	//Inhalte des customer tables löschen (struktur bleibt bestehen)
	public static boolean emptyCustomerTable() throws SQLException{
		Connection conn = DriverManager.getConnection(url+dbName,userName,password);

		   
	    try { PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE customer");
	      
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
		

	//customer table mit customer objekt befüllen
	public static boolean insertCustomer(TargetCustomer customer) throws SQLException {
	   Connection conn = DriverManager.getConnection(url+dbName,userName,password);

	   
	    try {
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO customer (CID, FIRSTNAME, LASTNAME, ADDRESS, COUNTRYCODE, STATUS) VALUES (?, ?, ?, ?, ?, ?)");
	        ps.setInt(1, customer.getCID());
	        ps.setString(2,customer.getFirstName());
	        System.out.println("schreib");
	        ps.setString(3,customer.getLastName());
	        ps.setString(4, customer.getAddress());
	        ps.setString(5, customer.getCountryCode());
	        ps.setString(6,customer.getStatus());

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
	
	
	//account table mit account objekt befüllen
	public static boolean insertAccount(TargetAccount account) throws SQLException {
	   Connection conn = DriverManager.getConnection(url+dbName,userName,password);

	   
	    try {
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO account (CID, IBAN, ACCOUNTBALANCE, TYPEOFACCOUNT) VALUES (?, ?, ?, ?)");
	        ps.setInt(1, account.getCID());
	        ps.setString(2,account.getIBAN());
	        ps.setDouble(3,account.getAccountBalance());
	        ps.setString(4, account.getTypeOfAccount());
	        

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
	
	//Inhalte des account tables löschen (struktur bleibt bestehen)
	public static boolean emptyAccountTable() throws SQLException{
		Connection conn = DriverManager.getConnection(url+dbName,userName,password);

		   
	    try { PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE account");
	      

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
	
	//Höchste CID + 1 zurückgeben
		public static int getNewCID() throws SQLException{
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = conn.createStatement();
			
			ResultSet resultset = stmt.executeQuery("SELECT MAX(CID) FROM customer");
			resultset.next(); // exactly one result so allowed
			int max = resultset.getInt(1); // use indexed retrieval since the column has no name
		    return max+1;
			
		}
	
	
	
		
}

	

