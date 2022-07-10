package leon.spring.boot.librarymanagement.service;

import java.util.List;

import leon.spring.boot.librarymanagement.entity.User;

public interface UserService {
	public List<User> findAll();
    public User findById(int id);
    public void deleteById(int id);
    public User findByUsername(String username);
    public void saveUser(User user);
    public List<User> searchByUsername(String username);
    public String passwordencode(String password);

}
