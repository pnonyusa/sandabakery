package co.za.sandabakery.respositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.ProductCategory;
import co.za.sandabakery.io.entity.ProductEntity;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long> {
         ProductEntity findByProductId(String productId);
         ProductEntity findByProductName(String productName);
         List<ProductEntity> findByCategory(ProductCategory category);
}
