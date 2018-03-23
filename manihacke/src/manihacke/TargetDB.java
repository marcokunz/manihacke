package manihacke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TargetDB {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
	//Target DB
	String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
	String dbName = "sql11226982";

	String driver = "com.mysql.jdbc.Driver";
	String userName = "sql11226982"; 
	String password = "4IltbjKGGQ";

	
	Class.forName(driver).newInstance();
    Connection conn = DriverManager.getConnection(url+dbName,userName,password);
    Statement stmt = conn.createStatement() ;
    boolean rs;
    
    //Customer Table
    String deleteTableCustomer = "DROP TABLE Customer;";
    String createTableCustomer = "CREATE TABLE Customer" + 
    		"(" + 
    		"CID VARCHAR(100)," + 
    		"FirstName VARCHAR(100)," + 
    		"LastName VARCHAR(100)," + 
    		"Address VARCHAR(100)," + 
    		"CountryCode VARCHAR(100)," + 
    		"Status VARCHAR(100)" + 
    		");";
    rs = stmt.execute(deleteTableCustomer);
    rs = stmt.execute(createTableCustomer);
	
    //Account Table
    String deleteTableAccount = "DROP TABLE Account";
    String createTableAccount = "CREATE TABLE Account" + 
    		"(" + 
    		"CID VARCHAR(100)," + 
    		"IBAN VARCHAR(100)," + 
    		"AccountBalance VARCHAR(100)," + 
    		"TypeOfAccount VARCHAR(100)" + 
    		");";
    rs = stmt.execute(deleteTableAccount);
    rs = stmt.execute(createTableAccount);
	
	}

}
