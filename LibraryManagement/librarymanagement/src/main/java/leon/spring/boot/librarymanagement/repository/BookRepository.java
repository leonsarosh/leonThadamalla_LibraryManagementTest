package leon.spring.boot.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leon.spring.boot.librarymanagement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByTitleContainsAndAuthorContainsAllIgnoreCase(String title,String author);

}
