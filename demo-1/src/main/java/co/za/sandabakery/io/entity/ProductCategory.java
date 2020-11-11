package co.za.sandabakery.io.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="product_category")
public class ProductCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String productCategoryId;
	
	private String categoryName;
	
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category")
	private Set<ProductEntity> products;



	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(Long id, String productCategoryId, String categoryName, Set<ProductEntity> products) {
		super();
		this.id = id;
		this.productCategoryId = productCategoryId;
		this.categoryName = categoryName;
		this.products = products;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}



	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public Set<ProductEntity> getProducts() {
		return products;
	}



	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
	
	
	

}
