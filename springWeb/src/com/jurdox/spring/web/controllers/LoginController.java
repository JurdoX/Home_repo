package com.jurdox.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jurdox.spring.web.dao.User;
import com.jurdox.spring.web.services.UserService;

@Controller
public class LoginController {

	private UserService usersService;

	@Autowired
	public void setUsersService(UserService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = usersService.getAllUsers();
		model.addAttribute("users", users);		
		return "admin";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showLogOut() {
		return "logout";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "newaccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		usersService.create(user);

		return "accountcreated";
	}
}
