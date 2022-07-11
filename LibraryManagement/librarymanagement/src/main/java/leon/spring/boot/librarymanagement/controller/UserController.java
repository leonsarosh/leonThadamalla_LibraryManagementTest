package leon.spring.boot.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import leon.spring.boot.librarymanagement.entity.Role;
import leon.spring.boot.librarymanagement.entity.User;
import leon.spring.boot.librarymanagement.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String showUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("mode", "Add");
		return "user-reg-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("userId") int id) {
		User user = userService.findById(id);
		System.out.println("user fetched is "+user);
		model.addAttribute("user", user);
		model.addAttribute("mode", "Update");
		return "user-upt-form";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("userId") int id) {
		userService.deleteById(id);
		return "redirect:list";
	}

	@RequestMapping("/403")
	public String showErrorPage() {
		return "403";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("username") String username, Model model) {
		List<User> users = userService.searchByUsername(username);
		model.addAttribute("users", users);
		return "user-list";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Nullable @RequestParam(value = "userId") int id,
			@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("roles") String role) {
		if (id == 0) {
			if (role=="ADMIN") {
				Role role1 = new Role(1, role);
				List<Role> roles = new ArrayList<>();
				roles.add(role1);
				User user = new User(username, userService.passwordencode(password), roles);
				System.out.println(user);
				userService.save(user);
				return "redirect:list";
			} else {
				Role role1 = new Role(2, role);
				List<Role> roles = new ArrayList<>();
				roles.add(role1);
				User user = new User(username, userService.passwordencode(password), roles);
				System.out.println(user);
				userService.save(user);
				return "redirect:list";
			}
		} else {
			if(role=="ADMIN") {
				User user = userService.findById(id);
				user.setUsername(username);
				user.setPassword(userService.passwordencode(password));
				Role role1 = new Role(1, role);
				List<Role> roles = new ArrayList<>();
				roles.add(role1);
				user.setRoles(roles);
				System.out.println(user);
				userService.save(user);
				return "redirect:list";
			} else {
				User user = userService.findById(id);
				user.setUsername(username);
				user.setPassword(userService.passwordencode(password));
				Role role1 = new Role(2, role);
				List<Role> roles = new ArrayList<>();
				roles.add(role1);
				user.setRoles(roles);
				System.out.println(user);
				userService.save(user);
				return "redirect:list";	
			}
		}
	}

}
