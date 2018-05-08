package manihacke;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BankVCT {
	
	private String customerID;
	private String customerName;
	private String streetName;
	private String ZIP;
	private String town;
	private String state;
	private String typeOfCustomer;
	private String accountNumber;
	private String total;
	private String clearing;
	
	

public BankVCT(String customerID, String customerName, String streetName, String ZIP, String town, String state,String typeOfCustomer, String accountNumber, String total, String clearing) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.streetName = streetName;
		this.ZIP = ZIP;
		this.town = town;
		this.state = state;
		this.typeOfCustomer = typeOfCustomer;
		this.accountNumber = accountNumber;
		this.total = total;
		this.clearing = clearing;
	}




//toString

@Override
public String toString() {
	return "BankVCT [customerID=" + customerID + ", customerName=" + customerName + ", streetName=" + streetName
			+ ", ZIP=" + ZIP + ", town=" + town + ", state=" + state + ", typeOfCustomer=" + typeOfCustomer
			+ ", accountNumber=" + accountNumber + ", total=" + total + ", clearing=" + clearing + "]";
}


//getters & setters

public String getCustomerID() {
	return customerID;
}

public void setCustomerID(String customerID) {
	this.customerID = customerID;
}


public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}


public String getStreetName() {
	return streetName;
}

public void setStreetName(String streetName) {
	this.streetName = streetName;
}


public String getZIP() {
	return ZIP;
}

public void setZIP(String zIP) {
	ZIP = zIP;
}


public String getTown() {
	return town;
}

public void setTown(String town) {
	this.town = town;
}


public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}


public String getTypeOfCustomer() {
	return typeOfCustomer;
}

public void setTypeOfCustomer(String typeOfCustomer) {
	this.typeOfCustomer = typeOfCustomer;
}


public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}


public String getTotal() {
	return total;
}

public void setTotal(String total) {
	this.total = total;
}


public String getClearing() {
	return clearing;
}

public void setClearing(String clearing) {
	this.clearing = clearing;
}









public static void launch() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
	
		// Source DB
		String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
		String dbName = "sql11226963";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "sql11226963"; 
		String password = "A6DJWbxVgN";

		Class.forName(driver).newInstance();
		    Connection conn = DriverManager.getConnection(url+dbName,userName,password);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    
		    rs = stmt.executeQuery("SELECT * FROM Account");
		    System.out.println("BANK VCT");
		    System.out.println();
			while (rs.next()) {
				
				// create new BankVCT object and print
				BankVCT vctEntry = new BankVCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));
				System.out.println("SourceEntry: "+vctEntry);
				
				
				//only run code below here if type of customer is privat(e)
				if(vctEntry.getTypeOfCustomer().equals("Privat") || vctEntry.getTypeOfCustomer().equals("Private")){

				
				//create new, empty TargetCustomer & set CID
				TargetCustomer tCustomer = new TargetCustomer();
						
				

				
				//get parameters from BankVCT, manipulate them, and add to TargetCustomer
				
				
				//Ranking
				float totalVCT = Float.parseFloat(vctEntry.getTotal());
				if(totalVCT>1000000){
					tCustomer.setStatus("Gold");
				}
				else if(totalVCT>500000){
					tCustomer.setStatus("Silver");
				}
				else if(totalVCT<=500000){
					tCustomer.setStatus("Bronze");
				}
				
				//state
				String state = vctEntry.getState();
				if(state.contains("Switzerland") ||state.contains("Schweiz")==true){
					tCustomer.setCountryCode("CH");
				}
				else if(state.contains("Germany") ||state.contains("Deutschland") ==true){
					tCustomer.setCountryCode("DE");
				}
				else if(state.contains("The Netherlands")==true){
					tCustomer.setCountryCode("NL");
				}
				else {
					tCustomer.setCountryCode("no country detected");
				}
				
				
				
				//address
				String address = vctEntry.getStreetName()+", "+vctEntry.getZIP()+" "+vctEntry.getTown();
				tCustomer.setAddress(address);
				
				//name
				String name = vctEntry.getCustomerName();
				List<String> namesList = new ArrayList<>(Arrays.asList(name.split(" ")));
				for (int i = 0; i < namesList.size(); i++) {
					if(!namesList.get(i).matches("van|von")){
					namesList.set(i, namesList.get(i).substring(0, 1).toUpperCase() + namesList.get(i).substring(1).toLowerCase());}
				}
				
				
				if(namesList.get(0).equals("Dr.")){
					namesList.remove(0);
				}
				
				if(namesList.size()<2){	
				tCustomer.setFirstName(namesList.get(0));}
				
				else if(namesList.size()<3){
				tCustomer.setFirstName(namesList.get(0));
				tCustomer.setLastName(namesList.get(1));}
				
				
				else if(namesList.size()<4){
				tCustomer.setFirstName(namesList.get(0));
				tCustomer.setLastName(namesList.get(1)+" "+namesList.get(2));}
				
				//replace umlauts where needed
				tCustomer.setFirstName(DAO.replaceUmlaut(tCustomer.getFirstName()));
				tCustomer.setLastName(DAO.replaceUmlaut(tCustomer.getLastName()));
				
				
		
				//Set CID and insert Customer 
				tCustomer.setCID(DAO.getNewCID());
				DAO.insertCustomer(tCustomer);
				
				//print tCustomer
				System.out.println("Inserted: "+tCustomer);
				
				
				
				
				
				//get parameters from BankVCT, manipulate them, and add to TargetAccount
				
				//create new, empty TargetAccount & set CID
				TargetAccount tAccount = new TargetAccount();
				tAccount.setCID(tCustomer.getCID());
				
				//IBAN
				ch.sic.ibantool.Main ibanclass = new ch.sic.ibantool.Main();
				ch.sic.ibantool.RecordIban recordiban;
				recordiban = new ch.sic.ibantool.RecordIban ();
				
				recordiban.BCPC = new StringBuffer("230");
				if(vctEntry.accountNumber.length()<9){
					vctEntry.accountNumber = "0"+vctEntry.accountNumber;
				}
				recordiban.KoZe = new StringBuffer(vctEntry.accountNumber);
				recordiban = ibanclass.IBANConvert(recordiban);
				
				tAccount.setIBAN(recordiban.Iban.toString());
				
				// Account balance
				tAccount.setAccountBalance(Double.parseDouble(vctEntry.getTotal()));
				
				//Type of Account
				tAccount.setTypeOfAccount("Transaction");
				
				
				//Insert Account 
				DAO.insertAccount(tAccount);
				
				//print tAccount
				System.out.println("Inserted:" +tAccount);
				System.out.println();
				
		

				}
				else{
					System.out.println("not inserted because entry is a company");
					System.out.println();
				}
			
				
			}

		

	}

}
