package manihacke;

public class TargetAccount {
	
	private int CID;
	private String IBAN;
	private double accountBalance;
	private String typeOfAccount;
	
	
	

	public TargetAccount(int CID, String IBAN, double accountBalance, String typeOfAccount) {
		this.CID = CID;
		this.IBAN = IBAN;
		this.accountBalance = accountBalance;
		this.typeOfAccount = typeOfAccount;
	}




	public int getCID() {
		return CID;
	}




	public void setCID(int cID) {
		CID = cID;
	}




	public String getIBAN() {
		return IBAN;
	}




	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}




	public double getAccountBalance() {
		return accountBalance;
	}




	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}




	public String getTypeOfAccount() {
		return typeOfAccount;
	}




	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}




	@Override
	public String toString() {
		return "TargetAccount [CID=" + CID + ", IBAN=" + IBAN + ", accountBalance=" + accountBalance
				+ ", typeOfAccount=" + typeOfAccount + "]";
	}





}
