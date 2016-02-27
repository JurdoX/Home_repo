package com.jurdox.spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.jurdox.spring.web.dao.User;
import com.jurdox.spring.web.dao.UserDao;

@Service("usersService")
public class UserService {

	private UserDao userDao;

	@Autowired
	public void setUser(UserDao user) {
		this.userDao = user;
	}
	
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public void create(User user) {
		userDao.create(user);
	}

	public boolean exists(String username) {
		return userDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {		
		return userDao.getAllUsers();
	}
}
