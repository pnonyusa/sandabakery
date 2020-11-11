package co.za.sandabakery.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.za.sandabakery.exceptions.UserServiceException;
import co.za.sandabakery.io.entity.ProductCategory;
import co.za.sandabakery.io.entity.ProductEntity;
import co.za.sandabakery.respositories.ProductRepository;
import co.za.sandabakery.service.ProductService;
import co.za.sandabakery.shared.dto.utils.Utils;
import co.za.sandabakery.ui.model.responses.ErrorMessages;
import co.za.sandabakery.ui.model.responses.ProductModelRespo;

@Service
public class ProductServiceImple implements  ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public ProductModelRespo addProduct(ProductEntity product) {
		
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		//ProductModelRespo productResponse=new ProductModelRespo();
		
		if(product==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());
		
		
		product.setProductId(new Utils().generateUserId(11));

     		
		return modelMapper.map(productRepository.save(product),ProductModelRespo.class);
	}

	@Override
	public ProductModelRespo updateProduct(String productId, ProductEntity product) {
		
		ProductEntity prod=productRepository.findByProductId(productId);
		
		ModelMapper modelMapper =new ModelMapper();
		
		if(prod==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		
		prod.setPrice(product.getPrice());
		prod.setQuantityOnHand(product.getQuantityOnHand());
		prod.setImage(product.getImage());
		prod.setProductRating(product.getProductRating());
		
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.save(prod),ProductModelRespo.class) ;
	}

	@Override
	public String deleteProduct(String productId) {
		// TODO Auto-generated method stub
		ProductEntity product=productRepository.findByProductId(productId);
		
		if(product==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		
		productRepository.delete(product);
		
		return "product is successfully delete";
	}

	@Override
	public List<ProductEntity> getProducts(int page, int limit) {
		
		Pageable pageReq=PageRequest.of(page, limit);
		
		Page<ProductEntity>prouductEntity=productRepository.findAll(pageReq);
		
		List<ProductEntity> products=prouductEntity.getContent();
		
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public ProductModelRespo getProduct(String productId) {
		// TODO Auto-generated method stub
		ProductEntity product=productRepository.findByProductId(productId);
		if(product==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		return new ModelMapper().map(product, ProductModelRespo.class);
	}

	@Override
	public List<ProductEntity> getProductsByCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		List<ProductEntity> products=productRepository.findByCategory(productCategory);
		
		if(products==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		return products;
	}

	

}
