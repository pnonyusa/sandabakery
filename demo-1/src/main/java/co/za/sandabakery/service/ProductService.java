package co.za.sandabakery.service;

import java.util.List;

import co.za.sandabakery.io.entity.ProductCategory;
import co.za.sandabakery.io.entity.ProductEntity;
import co.za.sandabakery.ui.model.responses.ProductModelRespo;

public interface ProductService {

	ProductModelRespo addProduct(ProductEntity product);
	ProductModelRespo updateProduct(String productId,ProductEntity product);
	String deleteProduct(String productId);
	List<ProductEntity> getProducts(int page,int limit);
	ProductModelRespo getProduct(String productName);
	List<ProductEntity> getProductsByCategory(ProductCategory productCategory);
	
}
