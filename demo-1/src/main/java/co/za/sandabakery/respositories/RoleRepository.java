package co.za.sandabakery.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Role findByRoleName(String roleName);
}
