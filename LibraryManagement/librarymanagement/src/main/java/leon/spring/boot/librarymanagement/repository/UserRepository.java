package leon.spring.boot.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leon.spring.boot.librarymanagement.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
	public List<User> searchByUsername(String username);
}
