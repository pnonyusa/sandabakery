package co.za.sandabakery.ui.model.responses;





public class CustomerModelResp {
	
	
	
	private String customerId;
	
	
	private String lastName;
	
	
	private String firstName;
	
	
	private String emailAddress;
	
	
	private String cellNumber;
	
	
	private AddressModelResp address;
	
	
	
	
	


	public CustomerModelResp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerModelResp(String customerId, String lastName, String firstName, String emailAddress,
			String cellNumber, AddressModelResp address) {
		super();
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.cellNumber = cellNumber;
		this.address = address;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getCellNumber() {
		return cellNumber;
	}


	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}


	public AddressModelResp getAddress() {
		return address;
	}


	public void setAddress(AddressModelResp address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	

}
