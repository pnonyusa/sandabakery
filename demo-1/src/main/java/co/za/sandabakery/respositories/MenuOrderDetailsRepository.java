package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.MenuOrderDetailsEntity;


@Repository
public interface MenuOrderDetailsRepository extends PagingAndSortingRepository<MenuOrderDetailsEntity, Long> {
                MenuOrderDetailsEntity findByMenuorderdetailId(String menuorderdetailId);
}
