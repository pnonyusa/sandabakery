package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.AddressEntity;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<AddressEntity, Long> {

}
