package com.jurdox.spring.web.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void create(User user) {
		userDao.create(user);
	}

	public boolean exists(String username) {
		return userDao.exists(username);
	}
}
