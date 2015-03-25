package com.jurdox.view;

import java.io.Serializable;

import com.jurdox.services.RegistrationService;

public class RegistrationView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String firstName;
	private String lastName;
	private String gender;
	private String state;
	private String note;
	private Integer age;

	private RegistrationService service = new RegistrationService();

	/**
	 * save person to DB and clear fields
	 * 
	 * @return
	 */
	public String registratePerson() {
		service.registratePerson(getAge(), getFirstName(), getLastName(),
				getGender(), getNote(), getState());
		clearFields();

		return null;
	}

	/**
	 * clear fields after adding new person
	 */
	public void clearFields() {
		setAge(null);
		setFirstName(null);
		setGender(null);
		setLastName(null);
		setNote(null);
		setState(null);
	}

	/**
	 * navigate to next page
	 * 
	 * @return table of persons
	 */
	public String getTableOfPersons() {
		return "tableOfPersons";
	}

	/**
	 * navigate to next page
	 * 
	 * @return mailer
	 */
	public String getEmail() {
		return "sendEmail";
	}

	
	// getters and setters

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
