package leon.spring.boot.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		model.addAttribute("book", user);
		model.addAttribute("mode", "Add");
		return "user-reg-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("userId") int id) {
		User user = userService.findById(id);
		model.addAttribute("book", user);
		model.addAttribute("mode", "Update");
		return "user-reg-form";
	}

	// Read Form data
	@PostMapping("/saveUser")
	public String saveUser(@RequestParam("id") int id, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("role1") String role1,
			@RequestParam("role2") String role2) {
		User user = null;
		if (id == 0) {
			List<Role> roles= new ArrayList<>();
			if(role1=="ADMIN" && role2=="USER") {
				Role role = new Role(role1);
				roles.add(role);
//				role=new Role(2,role2);
//				roles.add(role);
			} else if(role2=="USER" && role1=="") {
				Role role = new Role(role2);
				roles.add(role);
			} else if (role1=="ADMIN" && role2=="") {
				Role role = new Role(role1);
				roles.add(role);
			} else if (role1=="" && role2=="") {
				return "redirect:list";
			}
			String newPassword = userService.passwordencode(password);
			user = new User(username, newPassword, roles);
		} else {
			user = userService.findById(id);
			user.setUsername(username);
			String newPassword = userService.passwordencode(password);
			user.setPassword(newPassword);
			List<Role> roles= new ArrayList<>();
			if(role1=="ADMIN" && role2=="USER") {
				Role role = new Role(role1);
				roles.add(role);
//				role=new Role(role2);
//				roles.add(role);
			} else if(role2=="USER" && role1=="") {
				Role role = new Role(role2);
				roles.add(role);
			} else if (role1=="ADMIN" && role2=="") {
				Role role = new Role(role1);
				roles.add(role);
			} else if (role1=="" && role2=="") {
				return "redirect:list";
			}
			user.setRoles(roles);
			userService.saveUser(user);
			return "redirect:list";
		}
		return "redirect:list";
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

}
