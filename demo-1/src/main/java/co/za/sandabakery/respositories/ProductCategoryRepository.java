package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.za.sandabakery.io.entity.ProductCategory;

public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

}
