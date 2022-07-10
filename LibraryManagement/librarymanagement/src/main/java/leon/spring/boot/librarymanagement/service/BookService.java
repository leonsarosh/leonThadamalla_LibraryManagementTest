package leon.spring.boot.librarymanagement.service;

import java.util.List;

import leon.spring.boot.librarymanagement.entity.Book;

public interface BookService {
	public List<Book> findAll();
    public Book findById(int id);
    public void save(Book book);
    public void deleteById(int id);
    public List<Book> searchBy(String title, String author);
}
