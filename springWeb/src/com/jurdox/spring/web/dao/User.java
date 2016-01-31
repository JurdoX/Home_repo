package com.jurdox.spring.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.jurdox.spring.web.validation.ValidEmail;

public class User {

	@NotBlank(message = "Username can not be blank.")
	@Size(min = 3, max = 15)
	@Pattern(regexp = "^\\w{8,}$", message = "Username can consist of number, letters and the underscore character.")
	private String username;

	@NotBlank(message = "Password can not be blank.")
	@Size(min = 8, max = 15, message = "Password must be between 8 and 15 chars long.")
	@Pattern(regexp = "^\\S+$", message = "Password can not content a gap.")
	private String password;

	private String confirmPass;

	@ValidEmail(message = "This email address is not valid.")
	private String email;
	private boolean enabled;
	private String authority;

	public User() {
	}

	public User(String username, String password, String confirmPass, String email, boolean enabled, String authority) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPass = confirmPass;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
