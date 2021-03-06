package manihacke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


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
	    finally{
	    	conn.close();
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
	    finally{
	    	conn.close();
	    }
	    return false;
		}
		else return false;
	   
	}
	
	//Funktion checkt, ob customer bereits in DB vorhanden ist (Vorname && Nachname)
	public static boolean duplicateCustomerCheck(TargetCustomer customer) throws SQLException {
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
				System.out.println("Customer Insert für "+data_firstname.get(i) + " " + data_lastname.get(i) + " wurde übersprungen da Duplikat!");
				break;
			}
			
		}
		statementFirstname.close();
		statementLastname.close();
		rsFirstname.close();
		rsLastname.close();
		conn.close();

		
		return returnValue;
		
	}
	
	//findCIDbyName
	public static int getCIDbyName(String firstName, String lastName) throws SQLException{
		
		Connection conn = DriverManager.getConnection(url+dbName, userName, password);
		PreparedStatement stmt = conn.prepareStatement("SELECT CID FROM customer WHERE FIRSTNAME ='"+firstName+"' AND LASTNAME ='"+lastName+"';");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			
		return rs.getInt(1);}
		else{
		
			return 404;
		}
		
	
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
	    finally{
	    	conn.close();
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
	    
	    finally{
	    	conn.close();
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
			conn.close();
			stmt.close();
			resultset.close();
		    return max+1;
		    
		    
			
		}
		
	//Umlaute in Strings ergänzen (ue --> ü usw.) - ausgenommen die ersten beiden Buchstaben würden ein Umlaut bilden 	
		  public static String replaceUmlaut(String input) {

			  if(input != null && !input.isEmpty()){ 
				//split String in firstLetter and rest
			    String firstLetter = input.substring(0,1);
				String rest = input.substring(1);
			 	
			     //replace umlauts
			     String output = rest.replace("ü", "ue")
			                          .replace("ö", "oe")
			                          .replace("ä", "ae")
			                          .replace("ß", "ss");
			     
			     //concatenate Strings an return
			     return firstLetter+output;}
			  else{
			  return input;}
			
			
		  }
		  
		  
		  public static void cleanUp() throws SQLException{
			  	Connection conn = DriverManager.getConnection(url+dbName, userName, password);
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer");
				ResultSet rs = stmt.executeQuery();
				
				try{
				
				//two-dimensional arraylist with customer table data	
				ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

					while(rs.next()){
						ArrayList <String> inner = new ArrayList <String>();
						inner.add(rs.getString(1));
						inner.add(rs.getString(2));
						String s = (rs.getString(3).replaceAll("von", ""));
						if(s.substring(0, 1).equals(" ")) {
							inner.add(s.substring(1, s.length()));
							System.out.println(inner.get(2));
						}
						else {
							inner.add(s);
						}
						inner.add(rs.getString(3));
						inner.add(rs.getString(4));
						data.add(inner);
						//System.out.println(inner.get(2));
						}
				
							//iterate through arrayLists and compare each row with each other row		
							for (int i = 0; i< data.size(); i++){
								String CID = data.get(i).get(0);
								String firstName = data.get(i).get(1);
								String lastName = data.get(i).get(2);
								String address = data.get(i).get(3);
								
									for (int y = i; y < data.size();y++){
										String CID2 = data.get(y).get(0);
										String firstName2 = data.get(y).get(1);
										String lastName2 = data.get(y).get(2);
										String address2 = data.get(y).get(3);
										
										
										//update if firstname & lastname are mixed up
										if(firstName.equals(lastName2) && lastName.equals(firstName2)&& !CID.equals(CID2)){
											PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM customer WHERE FIRSTNAME ='"+firstName2+"';");
											stmt1.execute();
											PreparedStatement stmt2 = conn.prepareStatement("UPDATE account SET CID = '"+CID+"' WHERE CID='"+CID2+"';");
											stmt2.execute();
											stmt1.close();
											stmt2.close();	
											System.out.println("possible duplicate! CID "+CID+" seems similar to CID "+CID2+", please check Database");
										}
										
										//update if first char of firstnames is the same && lastnames are the same
										if(firstName.substring(0, 1).equals(firstName2.substring(0, 1)) && lastName.equals(lastName2) && !CID.equals(CID2)) {
											
											if(firstName.length()<firstName2.length()) {
												PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM customer WHERE CID ='"+CID+"';");
												stmt3.execute();
												PreparedStatement stmt4 = conn.prepareStatement("UPDATE account SET CID = '"+CID2+"' WHERE CID='"+CID+"';");
												stmt4.execute();
												}
												
											else {
													PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM customer WHERE CID ='"+CID2+"';");
													stmt3.execute();
													PreparedStatement stmt4 = conn.prepareStatement("UPDATE account SET CID = '"+CID+"' WHERE CID='"+CID2+"';");
													stmt4.execute();
													
												}
												
											}
										
										if(firstName.substring(0, 1).equals(firstName2.substring(0, 1)) && lastName.contains(lastName2) && !lastName.equals(lastName2) && !CID.equals(CID2)){
											PreparedStatement stmt5 = conn.prepareStatement("DELETE FROM customer WHERE CID ='"+CID+"';");
											stmt5.execute();
											PreparedStatement stmt6 = conn.prepareStatement("UPDATE account SET CID = '"+CID2+"' WHERE CID='"+CID+"';");
											stmt6.execute();
											PreparedStatement stmt7 = conn.prepareStatement("UPDATE customer SET COUNTRYCODE = 'DE' WHERE CID='"+CID2+"';");
											stmt7.execute();
											
										}
									
										
										
											
											
										}
										
										
										
									
									}		
							
			  	}
				
			  	catch (SQLException sqle) { 
			  	  System.out.println(sqle);  
			  	  
			  	} 
				
				finally{
				conn.close();
				stmt.close();
				rs.close();
				}
				
		  }
			
		  public static void StatusChecker() throws SQLException {
				Connection conn = DriverManager.getConnection(url+dbName, userName, password);
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account");
				ResultSet rs = stmt.executeQuery();
				
				//two-dimensional arrayList with account table data	
				ArrayList<Integer> data = new ArrayList<Integer>();

					while(rs.next()){
						data.add(Integer.parseInt(rs.getString(1)));
						}
					
				stmt.close();
				rs.close();
				System.out.println("STATUSUPDATE:");
				int max = Collections.max(data);
				for(int i=1; i<= max; i++){
					PreparedStatement stmt1 = conn.prepareStatement("SELECT SUM(ACCOUNTBALANCE) FROM account WHERE CID =" +i+";");
					ResultSet rs1 = stmt1.executeQuery();
					if(rs1.next()) {
					int newAccountBalance = rs1.getInt(1);
					stmt1.close();
					rs1.close();
					String Ausgabe;
						if(newAccountBalance > 1000000) {
							Ausgabe = "Gold";
							PreparedStatement stmt2 = conn.prepareStatement("UPDATE customer SET STATUS = 'Gold' WHERE CID =" +i+";");
							stmt2.execute();
							stmt2.close();
						}
						else if (newAccountBalance > 500000) {
							Ausgabe = "Silver";
							PreparedStatement stmt2 = conn.prepareStatement("UPDATE customer SET STATUS = 'Silver' WHERE CID =" +i+";");
							stmt2.execute();
							stmt2.close();
						}
						else {
							Ausgabe = "Bronze";
							PreparedStatement stmt2 = conn.prepareStatement("UPDATE customer SET STATUS = 'Bronze' WHERE CID =" +i+";");
							stmt2.execute();
							stmt2.close();
						}
						
					System.out.println("CID: "+i+" hat den Status: "+Ausgabe);
					}
					
					
					
				}
					

				
				
				
			  
			  
			  
		  }
		
}
		  
		 


	

