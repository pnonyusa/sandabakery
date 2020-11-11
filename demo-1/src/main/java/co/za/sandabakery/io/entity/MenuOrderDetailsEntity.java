package co.za.sandabakery.io.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name="menuorderdetails")
public class MenuOrderDetailsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	 private String menuorderdetailId;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "products_id", nullable = false)
	 private ProductEntity product;
	
	
	   private int quantity;
	
	   private double price;
	
	   @ManyToOne(fetch = FetchType.LAZY, optional = false)
	   @JoinColumn(name = "orders_id", nullable = false)
	   private Order order;
	   
	   

	public MenuOrderDetailsEntity() {
		// TODO Auto-generated constructor stub
	}

	public MenuOrderDetailsEntity(Long id, String menuorderdetailId, ProductEntity product, int quantity, double price,
			Order order) {
		super();
		this.id = id;
		this.menuorderdetailId = menuorderdetailId;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuorderdetailId() {
		return menuorderdetailId;
	}

	public void setMenuorderdetailId(String menuorderdetailId) {
		this.menuorderdetailId = menuorderdetailId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	   
	   
	   
	   
	   
	
	

}
