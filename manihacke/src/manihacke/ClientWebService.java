package manihacke;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.xml.rpc.holders.FloatWrapperHolder;
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
			
			
			bank.printSavings();
			//das für alle klassen gem BankJD.java Klasse
			
			StringHolder fname = new StringHolder();
			StringHolder lname = new StringHolder();
			StringHolder street = new StringHolder();
			StringHolder zipTown = new StringHolder();
			FloatWrapperHolder interestrate = new FloatWrapperHolder();
			LongWrapperHolder accountnumber = new LongWrapperHolder();
			LongWrapperHolder accountstatus = new LongWrapperHolder();	
			
			
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
			
			String [] array = bank.listSavingsLastname();
			//System.out.println("Savings" + Arrays.toString(array));
			
			String [] array2 = bank.listeTransactionLastname();
			//System.out.println("Transaction" + Arrays.toString(array2));
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
