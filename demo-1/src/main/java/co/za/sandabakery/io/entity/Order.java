package co.za.sandabakery.io.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String orderId;
	
	private String orderStatus;
	
	private Date orderd;
	
	private Date dateRecieved;
	
	private double orderTotal;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customers_id", nullable = false)
	private CustomerEntity customer;
	
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "products_id", nullable = false)
	 private ProductEntity product;
	 
	 @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	  private List<SpecialOrderDetails> ordersDetails;
	 
	 
	 @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	  private List<MenuOrderDetailsEntity> menuOrder;
	 
	 
	 
	 
	 


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(Long id, String orderId, String orderStatus, Date orderd, Date dateRecieved, double orderTotal,
			CustomerEntity customer, ProductEntity product) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderd = orderd;
		this.dateRecieved = dateRecieved;
		this.orderTotal = orderTotal;
		this.customer = customer;
		this.product = product;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Date getOrderd() {
		return orderd;
	}


	public void setOrderd(Date orderd) {
		this.orderd = orderd;
	}


	public Date getDateRecieved() {
		return dateRecieved;
	}


	public void setDateRecieved(Date dateRecieved) {
		this.dateRecieved = dateRecieved;
	}


	public double getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}


	public ProductEntity getProduct() {
		return product;
	}


	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	

}
