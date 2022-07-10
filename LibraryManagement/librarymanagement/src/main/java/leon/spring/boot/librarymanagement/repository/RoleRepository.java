package leon.spring.boot.librarymanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import leon.spring.boot.librarymanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
