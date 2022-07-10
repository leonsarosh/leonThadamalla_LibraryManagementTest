package leon.spring.boot.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import leon.spring.boot.librarymanagement.entity.User;
import leon.spring.boot.librarymanagement.repository.UserRepository;
import leon.spring.boot.librarymanagement.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
			User user = userRepo.findByUsername(username);
			if (user==null) {
				throw new UsernameNotFoundException("Username" + username + " not found");
			}
			
			MyUserDetails myUserDetails = new MyUserDetails(user);
			return myUserDetails;
	
//		Optional<User> opt = Optional.of(userRepo.findByUsername(username));
//
//		org.springframework.security.core.userdetails.User springUser = null;
//
//		if (opt.isEmpty()) {
//			throw new UsernameNotFoundException("Username" + username + " not found");
//		} else {
//			User user = opt.get();
//
//			List<Role> roles = user.getRoles();
//			List<GrantedAuthority> ga = new ArrayList<>();
//			for (Role role : user.getRoles()) {
//				ga.add(new SimpleGrantedAuthority(role.getName()));
//			}
//
//			springUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//					ga);
//		}
//		return springUser;
	}


//	@Override
//	public List<User> findAll() {
//		// TODO Auto-generated method stub
//		return userRepo.findAll();
//	}
//
//	@Override
//	public User findByUsername(String username) {
//		// TODO Auto-generated method stub
//		return userRepo.findByUsername(username);
//	}
//
//
//	@Override
//	public void saveUser(User user) {
//
//		userRepo.save(user);
//	}
//
//
//	@Override
//	public List<User> searchByUsername(String username) {
//		// TODO Auto-generated method stub
//		return userRepo.searchByUsername(username);
//	}
//
//
//	@Override
//	public String passwordencode(String password) {
//		// TODO Auto-generated method stub
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		String encodedPassword = encoder.encode(password);
//		return encodedPassword;
//	}
//
//
//	@Override
//	public User findById(int id) {
//		// TODO Auto-generated method stub
//		return userRepo.findById(id).get();
//	}
//
//
//	@Override
//	public void deleteById(int id) {
//		// TODO Auto-generated method stub
//		userRepo.deleteById(id);
//	}
}
