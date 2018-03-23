package manihacke;

public class TargetAccount {
	
	private int CID;
	private int IBAN;
	private double accountBalance;
	private String typeOfAccount;
	
	
	

	public TargetAccount(int CID, int IBAN, double accountBalance, String typeOfAccount) {
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




	public int getIBAN() {
		return IBAN;
	}




	public void setIBAN(int iBAN) {
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




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
