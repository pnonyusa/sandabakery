package co.za.sandabakery.ui.model.responses;





public class AddressModelResp {
	
	
	
	private String addressId;
	
	
	private String city;
	
	
	private String streetName;
	
	
	private String postalCode;
	

	private String country;
	

	private String type;
	
	private UserModelResp customer;
	
	
	
	
	
	
	
	
	
	

	public AddressModelResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressModelResp(String addressId, String city, String streetName, String postalCode, String country,
			String type, UserModelResp customer) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.country = country;
		this.type = type;
		this.customer = customer;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserModelResp getCustomer() {
		return customer;
	}

	public void setCustomer(UserModelResp customer) {
		this.customer = customer;
	}
	
	
	
	
	
	

}
