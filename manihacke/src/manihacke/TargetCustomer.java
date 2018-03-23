package manihacke;

public class TargetCustomer {
	
	private int CID;
	private String firstName;
	private String lastName;
	private String address;
	private String countryCode;
	private float status;

	public TargetCustomer(int CID, String firstName, String lastName, String address, String countryCode, float status){
		this.CID = CID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.countryCode = countryCode;
		this.status = status;
		
		
	}
	
	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TargetCustomer [CID=" + CID + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", countryCode=" + countryCode + ", status=" + status + "]";
	}



	

}
