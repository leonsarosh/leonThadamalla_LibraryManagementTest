package leon.spring.boot.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import leon.spring.boot.librarymanagement.entity.User;
import leon.spring.boot.librarymanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository	userRepo;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.saveAndFlush(user);
	}

	@Override
	public List<User> searchByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.searchByUsername(username);
	}

	@Override
	public String passwordencode(String password) {
		// TODO Auto-generated method stub
		PasswordEncoder encoder = new BCryptPasswordEncoder(12);
		String encodedPassword = encoder.encode(password);
		return encodedPassword;
	}
	
}
