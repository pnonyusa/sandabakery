package co.za.sandabakery.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name="products")
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String productId;
	
	@Column(nullable = false)
    private String productName;
    
	@Column(nullable = false)
    private String productDescription;
    
    
    @Column(nullable = false)
    private String productCategory;
    
    
    private String productRating;
    
    
    @Column(nullable = false)
    private double price;
    
    private int quantityOnHand;
    
    @Column(nullable = false)
    private String image;
    
    
    @Column(nullable = false)
    private String productIngredients;
    
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Order> orders;
    
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<SpecialOrderDetails> ordersDetails;
    
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<MenuOrderDetailsEntity> menuOrder;
    
    
    
    
    
    
    
	





	public ProductEntity(Long id, String productId, String productName, String productDescription,
			String productCategory, String productRating, double price, int quantityOnHand, String image,
			String productIngredients, List<Order> orders, List<SpecialOrderDetails> ordersDetails,
			List<MenuOrderDetailsEntity> menuOrder) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
		this.productRating = productRating;
		this.price = price;
		this.quantityOnHand = quantityOnHand;
		this.image = image;
		this.productIngredients = productIngredients;
		this.orders = orders;
		this.ordersDetails = ordersDetails;
		this.menuOrder = menuOrder;
	}





	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}





	public String getProductIngredients() {
		return productIngredients;
	}





	public void setProductIngredients(String productIngredients) {
		this.productIngredients = productIngredients;
	}





	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public List<SpecialOrderDetails> getOrdersDetails() {
		return ordersDetails;
	}


	public void setOrdersDetails(List<SpecialOrderDetails> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}


	public List<MenuOrderDetailsEntity> getMenuOrder() {
		return menuOrder;
	}


	public void setMenuOrder(List<MenuOrderDetailsEntity> menuOrder) {
		this.menuOrder = menuOrder;
	}





	Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductRating() {
		return productRating;
	}
	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
    
    
    
    
   
}
