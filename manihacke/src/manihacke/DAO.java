package manihacke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
	   if(duplicateCustomerCheck(customer)) {
	   Connection conn = DriverManager.getConnection(url+dbName,userName,password);
       PreparedStatement ps = conn.prepareStatement("INSERT INTO customer (CID, FIRSTNAME, LASTNAME, ADDRESS, COUNTRYCODE, STATUS) VALUES (?, ?, ?, ?, ?, ?)");
       ps.setInt(1, customer.getCID());
       ps.setString(2,customer.getFirstName());
       ps.setString(3,customer.getLastName());
       ps.setString(4, customer.getAddress());
       ps.setString(5, customer.getCountryCode());
       ps.setString(6,customer.getStatus());
	   
	    try {
	    	
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
		else return false;
	}
	
	//Funktion checkt, ob customer bereits in DB vorhanden ist (Vorname && Nachname)
	private static boolean duplicateCustomerCheck(TargetCustomer customer) throws SQLException {
		Connection conn = DriverManager.getConnection(url+dbName, userName, password);
		PreparedStatement statementFirstname = conn.prepareStatement("SELECT FIRSTNAME FROM customer;");
		ResultSet rsFirstname = statementFirstname.executeQuery();
		PreparedStatement statementLastname = conn.prepareStatement("SELECT LASTNAME FROM customer;");
		ResultSet rsLastname = statementLastname.executeQuery();
		ArrayList data_firstname = new ArrayList();
		ArrayList data_lastname = new ArrayList();
        try {
            for (int counter = 1; rsFirstname.next();counter++) {
                    data_firstname.add(rsFirstname.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            for (int counter = 1; rsLastname.next();counter++) {
                    data_lastname.add(rsLastname.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean returnValue = true;
		for(int i = 0; i < data_firstname.size();i++) {
			if(data_firstname.get(i).equals(customer.getFirstName()) && data_lastname.get(i).equals(customer.getLastName())) {
				returnValue = false;
				System.out.println(data_firstname.get(i) + " " + data_lastname.get(i) + "wurde �bersprungen da Duplikat!");
				break;
			}
		}
		return returnValue;
		
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

	

