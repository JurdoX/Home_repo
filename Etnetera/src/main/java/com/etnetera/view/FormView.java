package com.etnetera.view;

import java.io.Serializable;

import com.etnetera.service.PersonService;

public class FormView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String phone;
	private String email;
	
	private PersonService service = new PersonService();
	
	/**
	 * save person to DB
	 * @return null, stay in this page (form.xhtml)
	 */
	public String savePerson() {
		service.savePerson(getName(), getPhone(), getEmail());
		cleanFields();
		
		return null;
	}
	
	/**
	 * clean fields after save person
	 */
	public void cleanFields() {
		setName("");
		setPhone("");
		setEmail("");
	}

	/**
	 * redirect to table view
	 * @return name to redirect page
	 */
	public String showTable() {
		return "table";
	}
	
	/**
	 * redirect to email sender
	 * @return name to redirect page
	 */
	public String sendEmail() {
		return "sendEmail";
	}
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
