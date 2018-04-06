package manihacke;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.FloatWrapperHolder;
import javax.xml.rpc.holders.IntegerWrapperHolder;
import javax.xml.rpc.holders.LongWrapperHolder;
import javax.xml.rpc.holders.StringHolder;

import ch.fhnw.www.wi.eai.bankjd.BankJD;
import ch.fhnw.www.wi.eai.bankjd.BankJDProxy;

public class ClientWebService {
	
	//Klassenvariablen Transaction
	private String tFirstName;
	private String tLastName;
	private String tAddress;
	private String tCountry;
	private String tRanking;
	private String tIBAN;
	private String tAccountStatus;
	private String tBIC;
	
	//Klassenvariablen Savings
	private String sFirstName;
	private String sLastName;
	private String sStreet;
	private String sZipTown;
	private String sInterestRate;
	private String sAccountNumber;
	private String sAccountStatus;
	
	
	//constructor 
	public ClientWebService(String tFirstName, String tLastName, String tAddress, String tCountry, String tRanking,
			String tIBAN, String tAccountStatus, String tBIC, String sFirstName, String sLastName, String sStreet,
			String sZipTown, String sInterestRate, String sAccountNumber, String sAccountStatus) {
		super();
		this.tFirstName = tFirstName;
		this.tLastName = tLastName;
		this.tAddress = tAddress;
		this.tCountry = tCountry;
		this.tRanking = tRanking;
		this.tIBAN = tIBAN;
		this.tAccountStatus = tAccountStatus;
		this.tBIC = tBIC;
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.sStreet = sStreet;
		this.sZipTown = sZipTown;
		this.sInterestRate = sInterestRate;
		this.sAccountNumber = sAccountNumber;
		this.sAccountStatus = sAccountStatus;
	}
	
	// empty constructor
	public ClientWebService() {
		super();
	}

	

	// constructor for transaction
	public ClientWebService(String tFirstName, String tLastName, String tAddress, String tCountry, String tRanking,
			String tIBAN, String tAccountStatus, String tBIC) {
		super();
		this.tFirstName = tFirstName;
		this.tLastName = tLastName;
		this.tAddress = tAddress;
		this.tCountry = tCountry;
		this.tRanking = tRanking;
		this.tIBAN = tIBAN;
		this.tAccountStatus = tAccountStatus;
		this.tBIC = tBIC;
	}
	
	
	

	//constructor savings
	public ClientWebService(String sFirstName, String sLastName, String sStreet, String sZipTown, String sInterestRate,
			String sAccountNumber, String sAccountStatus) {
		super();
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.sStreet = sStreet;
		this.sZipTown = sZipTown;
		this.sInterestRate = sInterestRate;
		this.sAccountNumber = sAccountNumber;
		this.sAccountStatus = sAccountStatus;
	}

	
	
	
	
	
	// getters and setters
	public String gettFirstName() {
		return tFirstName;
	}

	public void settFirstName(String tFirstName) {
		this.tFirstName = tFirstName;
	}

	public String gettLastName() {
		return tLastName;
	}

	public void settLastName(String tLastName) {
		this.tLastName = tLastName;
	}

	public String gettAddress() {
		return tAddress;
	}

	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	public String gettCountry() {
		return tCountry;
	}

	public void settCountry(String tCountry) {
		this.tCountry = tCountry;
	}

	public String gettRanking() {
		return tRanking;
	}

	public void settRanking(String tRanking) {
		this.tRanking = tRanking;
	}

	public String gettIBAN() {
		return tIBAN;
	}

	public void settIBAN(String tIBAN) {
		this.tIBAN = tIBAN;
	}

	public String gettAccountStatus() {
		return tAccountStatus;
	}

	public void settAccountStatus(String tAccountStatus) {
		this.tAccountStatus = tAccountStatus;
	}

	public String gettBIC() {
		return tBIC;
	}

	public void settBIC(String tBIC) {
		this.tBIC = tBIC;
	}

	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getsStreet() {
		return sStreet;
	}

	public void setsStreet(String sStreet) {
		this.sStreet = sStreet;
	}

	public String getsZipTown() {
		return sZipTown;
	}

	public void setsZipTown(String sZipTown) {
		this.sZipTown = sZipTown;
	}

	public String getsInterestRate() {
		return sInterestRate;
	}

	public void setsInterestRate(String sInterestRate) {
		this.sInterestRate = sInterestRate;
	}

	public String getsAccountNumber() {
		return sAccountNumber;
	}

	public void setsAccountNumber(String sAccountNumber) {
		this.sAccountNumber = sAccountNumber;
	}

	public String getsAccountStatus() {
		return sAccountStatus;
	}

	public void setsAccountStatus(String sAccountStatus) {
		this.sAccountStatus = sAccountStatus;
	}
	
	
	
	
	
	
	
	
	

	
	public static void main(String[] args) {
		
		BankJD bank;
		bank = new BankJDProxy();
		
		try {
			
			
			//Savings Holders
			StringHolder fname = new StringHolder();
			StringHolder lname = new StringHolder();
			StringHolder street = new StringHolder();
			StringHolder zipTown = new StringHolder();
			FloatWrapperHolder interestrate = new FloatWrapperHolder();
			LongWrapperHolder accountnumber = new LongWrapperHolder();
			LongWrapperHolder accountstatus = new LongWrapperHolder();
			
			
			
			
			System.out.println("SAVINGS SAVINGS SAVINGS SAVINGS SAVINGS");
			//print Savings
			String [] array1 = bank.listSavingsLastname();
			for(int i = 0; i < array1.length;i++) {
				String name = array1[i];
				bank.retrieveSavings("", name, fname, lname, street, zipTown, interestrate, accountnumber, accountstatus);
				System.out.println("--------------------------------------");
				System.out.println("Person " + (i+1) + ":");
				System.out.println("First Name: "+fname.value);
				System.out.println("Last Name: "+lname.value);
				System.out.println("Street: "+street.value);
				System.out.println("ZIPTown: "+zipTown.value);
				System.out.println("InterestRate: "+interestrate.value);
				System.out.println("Account Number: "+accountnumber.value);
				System.out.println("Account Status: "+accountstatus.value);
			}
			
			System.out.println();
			System.out.println();
			System.out.println("TRANSACTIONS TRANSACTIONS TRANSACTIONS TRANSACTIONS TRANSACTIONS");
			
			
			
			
			
			
			
			//Transactions
			StringHolder transactionFirstName = new StringHolder();
			StringHolder transactionLastName = new StringHolder();
			StringHolder transactionAddress = new StringHolder();
			StringHolder transactionCountry = new StringHolder();
			IntegerWrapperHolder transactionRanking = new IntegerWrapperHolder();
			StringHolder transactionIbanNumber = new StringHolder();
			FloatWrapperHolder transactionAccountStatus = new FloatWrapperHolder();
			StringHolder transactionBic = new StringHolder();
			
			//print transactions & insert in DB
			String [] array2 = bank.listeTransactionLastname();
			for(int i = 0; i < array2.length;i++) {
				String name = array2[i];
				bank.retrieveTransaction("", name, transactionFirstName, transactionLastName, transactionAddress, transactionCountry, transactionRanking, transactionIbanNumber, transactionAccountStatus, transactionBic );
				TargetCustomer customer = new TargetCustomer(0, transactionFirstName.value, transactionLastName.value, transactionAddress.value, transactionCountry.value, "default");
				TargetAccount account = new TargetAccount(0, transactionIbanNumber.value, transactionAccountStatus.value, "Transaction");
				System.out.println(customer);
				System.out.println(account);
//				try {
//					DAO.insertCustomer(customer);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				try {
//					DAO.insertAccount(account);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				
			}
			
		
			
		
		
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
