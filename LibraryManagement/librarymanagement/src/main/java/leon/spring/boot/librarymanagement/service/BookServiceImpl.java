package leon.spring.boot.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leon.spring.boot.librarymanagement.entity.Book;
import leon.spring.boot.librarymanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> searchBy(String title, String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByTitleContainsAndAuthorContainsAllIgnoreCase(title, author);
	}

}
