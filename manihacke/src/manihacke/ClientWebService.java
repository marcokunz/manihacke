package manihacke;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.FloatWrapperHolder;
import javax.xml.rpc.holders.LongWrapperHolder;
import javax.xml.rpc.holders.StringHolder;

import ch.fhnw.www.wi.eai.bankjd.BankJD;
import ch.fhnw.www.wi.eai.bankjd.BankJDProxy;

public class ClientWebService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	BankJD bank;
		
		bank = new BankJDProxy();
		
		try {
			
			
			bank.printSavings();
			//das für alle klassen gem BankJD.java Klasse
			
			StringHolder fname;
			StringHolder lname;
			StringHolder street;
			StringHolder zipTown;
			FloatWrapperHolder interestrate;
			LongWrapperHolder accountnumber;
			LongWrapperHolder accountstatus;
			
			fname = new StringHolder();
			lname = new StringHolder();
			street = new StringHolder();
			zipTown = new StringHolder();
			interestrate = new FloatWrapperHolder();
			accountnumber = new LongWrapperHolder();
			accountstatus = new LongWrapperHolder();
			
			
			
			
			bank.retrieveSavings("", "Mueller", fname, lname, street, zipTown, interestrate, accountnumber, accountstatus);
			
			System.out.println("FNAME: "+fname.value);
			System.out.println("NNAME: "+lname.value);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
