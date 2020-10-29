package co.za.sandabakery.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="addresses")
public class AddressEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length=10)
	private String addressId;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String streetName;
	
	@Column(nullable = false,length=7)
	private String postalCode;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String type;
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customers_id", nullable = false)
	@JsonBackReference
	private CustomerEntity customer;
	
	
	
	
	
	
	
	


	public AddressEntity(Long id, String addressId, String city, String streetName, String postalCode, String country,
			String type, CustomerEntity customer) {
		super();
		this.id = id;
		this.addressId = addressId;
		this.city = city;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.country = country;
		this.type = type;
		this.customer = customer;
	}
	
	
	


	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	
	
	
	
	
	
}