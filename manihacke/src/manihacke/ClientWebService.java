package manihacke;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.xml.rpc.holders.FloatWrapperHolder;
import javax.xml.rpc.holders.IntegerWrapperHolder;
import javax.xml.rpc.holders.LongWrapperHolder;
import javax.xml.rpc.holders.StringHolder;

import ch.fhnw.www.wi.eai.bankjd.BankJD;
import ch.fhnw.www.wi.eai.bankjd.BankJDProxy;

public class ClientWebService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	BankJD bank;
		
		bank = new BankJDProxy();
		
		try {
			
			
			//Savings
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
			
			//print transactions
			String [] array2 = bank.listeTransactionLastname();
			for(int i = 0; i < array2.length;i++) {
				String name = array2[i];
				bank.retrieveTransaction("", name, transactionFirstName, transactionLastName, transactionAddress, transactionCountry, transactionRanking, transactionIbanNumber, transactionAccountStatus, transactionBic );
				System.out.println("--------------------------------------");
				System.out.println("Person " + (i+1) + ":");
				System.out.println("First Name: "+transactionFirstName.value);
				System.out.println("Last Name: "+transactionLastName.value);
				System.out.println("Address: "+transactionAddress.value);
				System.out.println("Country: "+transactionCountry.value);
				System.out.println("Ranking: "+transactionRanking.value);
				System.out.println("IBAN Number: "+transactionIbanNumber.value);
				System.out.println("Account Status: "+transactionAccountStatus.value);
				System.out.println("Account bic: "+transactionBic.value);
			}
			
		
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
