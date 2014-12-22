package com.jurdox.beans;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

import com.jurdox.dao.RegistrationPersonDAO;
import com.jurdox.dao.RegistrationPersonImpl;
import com.jurdox.model.Person;

@ManagedBean(name = "registrationperson")
public class RegistrationPerson {

	public static final Logger log = Logger.getLogger("Registration:");
	
	private String firstName;
	private String lastName;
	private String gender;
	private String state;
	private String note;
	private Integer age;

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

	public String registratePerson() {
		RegistrationPersonDAO addPerson = new RegistrationPersonImpl();
		Person person = new Person();
		person.setAge(getAge());
		person.setFirstName(getFirstName());
		person.setLastName(getLastName());
		person.setGender(getGender());
		person.setNote(getNote());
		person.setState(getState());
		boolean result = addPerson.registratePerson(person);
		log.debug("Succes: " + result);
		
		return "person added";
	}

}
