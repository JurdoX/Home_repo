package com.jurdox.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jurdox.dao.OperationWithPersonDAO;
import com.jurdox.dao.OperationPersonImpl;
import com.jurdox.model.Person;

public class RegistrationPerson implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String firstName;
	private String lastName;
	private String gender;
	private String state;
	private String note;
	private Integer age;

//	public List<Person> personsList;
	OperationWithPersonDAO operation = new OperationPersonImpl();

	TableOfPersons table = new TableOfPersons();
	
//	public RegistrationPerson() {
//		personsList = new ArrayList<Person>();
//	}
	
	public String registratePerson() {
		Person person = new Person();
		person.setAge(getAge());
		person.setFirstName(getFirstName());
		person.setLastName(getLastName());
		person.setGender(getGender());
		person.setNote(getNote());
		person.setState(getState());
		table.personsList.add(person);
		operation.savePerson(person);
		clearFields();

		return null;
	}

	public void clearFields() {
		setAge(null);
		setFirstName(null);
		setGender(null);
		setLastName(null);
		setNote(null);
		setState(null);
	}
	
	public String getTableOfPersons() {
		return "tableOfPersons";
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

//	public List<Person> getPersonsList() {
//		return personsList;
//	}
//
//	public void setPersonsList(List<Person> personsList) {
//		this.personsList = personsList;
//	}

}
