package com.jurdox.spring.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		jdbc.update("INSERT INTO users(username, password, email, enabled) VALUES (:username, :password, :email, :enabled)", params);
		
		return jdbc.update("INSERT INTO authorities(username, authority) VALUES(:username, :authority)", params) == 1;
	}

	public boolean exists(String username) {
		return jdbc.queryForObject("SELECT COUNT(*) FROM users WHERE username=:username", 
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}
}
