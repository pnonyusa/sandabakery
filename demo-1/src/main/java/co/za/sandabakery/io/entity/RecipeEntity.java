package co.za.sandabakery.io.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="recipes")
public class RecipeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	private String recipeId;
	
	
	private String productName;
	
	
	private String productCategory;
	
	
	private String ingredients;
	

	private String notes;

	
	
	
	
	
	
	
	
	

	public RecipeEntity() {
		// TODO Auto-generated constructor stub
	}


	public RecipeEntity(Long id, String recipeId, String productName, String productCategory, String ingredients,
			String notes) {
		super();
		this.id = id;
		this.recipeId = recipeId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.ingredients = ingredients;
		this.notes = notes;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getIngredients() {
		return ingredients;
	}


	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
	
	
	
	
	
	

}
