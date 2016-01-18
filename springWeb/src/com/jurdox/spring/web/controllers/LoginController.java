package com.jurdox.spring.web.controllers;

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

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
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
		
		user.setAuthority("user");
		user.setEnabled(true);
		usersService.create(user);
		
		return "accountcreated";
	}
}
