package leon.spring.boot.librarymanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import leon.spring.boot.librarymanagement.entity.Book;
import leon.spring.boot.librarymanagement.entity.Role;
import leon.spring.boot.librarymanagement.entity.User;
import leon.spring.boot.librarymanagement.repository.BookRepository;
import leon.spring.boot.librarymanagement.repository.RoleRepository;
import leon.spring.boot.librarymanagement.repository.UserRepository;
import leon.spring.boot.librarymanagement.service.UserService;

@SpringBootApplication
public class LibrarymanagementApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = bookRepository.findByTitleContainsAndAuthorContainsAllIgnoreCase("java", "james");
		System.out.println("books" + books);
		Role role = new Role();
		role.setName("TEST");
		List<Role> roles = new ArrayList<>();
//		roles.add(role);
//		User user = new User("user3", userService.passwordencode("1234"), roles );
//		System.out.println("user3" + user);
//		userRepository.save(user);
		User user2 = userRepository.findById(5).get();
		List<Role> roles2 = user2.getRoles();
		roles2.add(role);
		System.out.println("user3" + user2);
		userRepository.saveAndFlush(user2);
	}

}
