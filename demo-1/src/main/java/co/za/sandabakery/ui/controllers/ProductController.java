package co.za.sandabakery.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.za.sandabakery.io.entity.ProductEntity;
import co.za.sandabakery.service.ProductService;
import co.za.sandabakery.ui.model.responses.ProductModelRespo;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	//myproduct
	@PostMapping(path = "/admin/addproduct", consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public ResponseEntity<ProductModelRespo> saveProduct(@RequestBody ProductEntity product) {
				return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
	}
	
	
	@PutMapping(path="/admin/updateproduct/{id}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public ResponseEntity<ProductModelRespo> updateProduct(@PathVariable String id,@RequestBody ProductEntity product){
		return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/admin/deleteProduct/{id}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public String deleteProduct(@PathVariable String id) {
		     
		return productService.deleteProduct(id);
		
	}
	
	
	@GetMapping(consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public List<ProductModelRespo> getProducts(@RequestParam(value="page",defaultValue="0") int page, @RequestParam(value="limit",defaultValue="15") int limit){
		
		    ModelMapper modelMapper =new ModelMapper();
		    
		    List<ProductModelRespo> responseModel=new ArrayList<>();
		    
		    List<ProductEntity> products=productService.getProducts(page, limit);
		    
		    
		    for(int i=0;i<products.size();i++) {
		    	responseModel.add(i, modelMapper.map(products.get(i), ProductModelRespo.class));
		    }
		    
		return responseModel;
		
		
	}
	
	
	@GetMapping(path="/{productId}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public ProductModelRespo getProduct(@PathVariable String productId) {
		return productService.getProduct(productId);
	}
	

}
