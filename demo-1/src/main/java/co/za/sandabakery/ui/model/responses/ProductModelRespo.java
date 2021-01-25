package co.za.sandabakery.ui.model.responses;



public class ProductModelRespo {
	
	private String productId;
	
	
    private String productName;
    
	
    private String productDescription;
    
    
    
    private ProductCategoryResponse category;
    
    
    private String productRating;
    
    
    private String productIngredients;
    
    
    private double price;
    
    
    private int quantityOnHand;
    
    
    private String image;
    
    
    

    
    
    
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

	public ProductCategoryResponse getCategory() {
		return category;
	}

	public void setCategory(ProductCategoryResponse category) {
		this.category = category;
	}
    
    
    
 
}
