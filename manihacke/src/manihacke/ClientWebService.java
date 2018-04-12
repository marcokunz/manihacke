package manihacke;

import java.rmi.RemoteException;
import java.sql.SQLException;

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

	
	
	
	// toString
	public String toString() {
		return "ClientWebService [tFirstName=" + tFirstName + ", tLastName=" + tLastName + ", tAddress=" + tAddress
				+ ", tCountry=" + tCountry + ", tRanking=" + tRanking + ", tIBAN=" + tIBAN + ", tAccountStatus="
				+ tAccountStatus + ", tBIC=" + tBIC + ", sFirstName=" + sFirstName + ", sLastName=" + sLastName
				+ ", sStreet=" + sStreet + ", sZipTown=" + sZipTown + ", sInterestRate=" + sInterestRate
				+ ", sAccountNumber=" + sAccountNumber + ", sAccountStatus=" + sAccountStatus + "]";
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
	
	
	
	
	
	
	
	
	

	
	public static void launch() throws SQLException {
		
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
			//create new objects and print 
			String [] array1 = bank.listSavingsLastname();
			for(int i = 0; i < array1.length;i++) {
				
				String name = array1[i];
				bank.retrieveSavings("", name, fname, lname, street, zipTown, interestrate, accountnumber, accountstatus);
				ClientWebService BankJDEntry = new ClientWebService(fname.value, lname.value, street.value, zipTown.value, interestrate.value.toString(), accountnumber.value.toString(), accountstatus.value.toString());
				System.out.println(BankJDEntry.toString());
				
				

				//get parameters from BankJDSavings, manipulate them, and add to TargetCustomer

				//create new customer and assign CID
				TargetCustomer customer = new TargetCustomer();
				customer.setCID(DAO.getNewCID());
				
				
				// firstname, lastname, address, countrycode
				customer.setFirstName(BankJDEntry.getsFirstName());
				customer.setLastName(BankJDEntry.getsLastName());
				customer.setAddress(BankJDEntry.getsStreet()+" "+BankJDEntry.getsZipTown());
				customer.setCountryCode("CH");
				
				//add umlauts where needed
				//customer.setFirstName(DAO.replaceUmlaut(customer.getFirstName()));
				customer.setLastName(DAO.replaceUmlaut(customer.getLastName()));
				
				//Ranking
				Float rankingSavings = Float.parseFloat(BankJDEntry.getsAccountStatus());
				if(rankingSavings>1000000){
					customer.setStatus("Gold");
				}
				else if(rankingSavings>500000){
					customer.setStatus("Silver");
				}
				else if(rankingSavings<=500000){
					customer.setStatus("Bronze");
				}
				DAO.insertCustomer(customer);
				System.out.println(customer);
				
				
				
				//get parameters from BankJDSavings, manipulate them, and add to TargetAccount
				
				//create new customer and assign CID
				TargetAccount account = new TargetAccount();
				if(DAO.duplicateCustomerCheck(customer)==true){
					int existingCID = DAO.getCIDbyName(customer.getFirstName(), customer.getLastName());
					account.setCID(existingCID);
				}
				else{
					account.setCID(customer.getCID());}
				
				//IBAN
				ch.sic.ibantool.Main ibanclass = new ch.sic.ibantool.Main();
				ch.sic.ibantool.RecordIban recordiban;
				recordiban = new ch.sic.ibantool.RecordIban ();
				
				recordiban.BCPC = new StringBuffer("230");
				recordiban.KoZe = new StringBuffer(BankJDEntry.getsAccountNumber());
				recordiban = ibanclass.IBANConvert(recordiban);
				
				account.setIBAN(recordiban.Iban.toString());
				
				// Balance & Type
				account.setAccountBalance(Double.parseDouble(BankJDEntry.sAccountStatus));
				account.setTypeOfAccount("Savings");
				
				DAO.insertAccount(account);
				System.out.println(account);

				
				
				
				
				
				
				

			}
			
			System.out.println();
			System.out.println();
			System.out.println("TRANSACTIONS TRANSACTIONS TRANSACTIONS TRANSACTIONS TRANSACTIONS");
			
			

			//Transactions Holders
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
				ClientWebService BankJDEntry = new ClientWebService(transactionFirstName.value, transactionLastName.value, transactionAddress.value, transactionCountry.value, transactionRanking.value.toString(), transactionIbanNumber.value, transactionAccountStatus.value.toString(), transactionBic.value);
				System.out.println(BankJDEntry.toString());
				
				//get parameters from BankJDTransactions, manipulate them, and add to TargetCustomer
				TargetCustomer customer = new TargetCustomer();
				customer.setCID(DAO.getNewCID());
				
				
				//firstname, lastname, address, countrycode
				customer.setFirstName(BankJDEntry.gettFirstName());
				customer.setLastName(BankJDEntry.gettLastName());
				customer.setAddress(BankJDEntry.gettAddress());
				customer.setCountryCode(BankJDEntry.gettCountry());
				
				//add umlauts where needed
				//customer.setFirstName(DAO.replaceUmlaut(customer.getFirstName()));
				customer.setLastName(DAO.replaceUmlaut(customer.getLastName()));
			
				
				//Ranking
				int rankingSavings = Integer.parseInt(BankJDEntry.gettRanking());
				if(rankingSavings<3){
					customer.setStatus("Gold");
				}
				else if(rankingSavings<5){
					customer.setStatus("Silver");
				}
				else if(rankingSavings>=5){
					customer.setStatus("Bronze");
				}
				
				//DAO.insertCustomer(customer);
				System.out.println(customer);
				
				
				
				
				//get parameters from BankJDTransactions, manipulate them, and add to TargetAccount
				
				//create new customer and assign CID
				TargetAccount account = new TargetAccount();
				if(DAO.duplicateCustomerCheck(customer)==true){
					int existingCID = DAO.getCIDbyName(customer.getFirstName(), customer.getLastName());
					account.setCID(existingCID);
				}
				else{
					account.setCID(customer.getCID());}
				
				//IBAN
				ch.sic.ibantool.Main ibanclass = new ch.sic.ibantool.Main();
				ch.sic.ibantool.RecordIban recordiban;
				recordiban = new ch.sic.ibantool.RecordIban ();
								
				recordiban.BCPC = new StringBuffer("230");
				System.out.println(BankJDEntry.gettIBAN().substring(12));
				recordiban.KoZe = new StringBuffer(BankJDEntry.gettIBAN().substring(12,BankJDEntry.gettIBAN().length()));
				recordiban = ibanclass.IBANConvert(recordiban);
				System.out.println(recordiban.VFlag.toString());

				
				account.setIBAN(recordiban.Iban.toString());
				
				// Balance & Type
				account.setAccountBalance(Double.parseDouble(BankJDEntry.gettAccountStatus()));
				account.setTypeOfAccount("Transaction");
				
				System.out.println(account);
				DAO.insertAccount(account);
				System.out.println();

				
				
				
				
				
			}
			
		
			
		
		
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
