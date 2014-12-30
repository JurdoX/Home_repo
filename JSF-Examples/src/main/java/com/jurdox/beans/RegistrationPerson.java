package com.jurdox.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jurdox.dao.OperationWithPersonDAO;
import com.jurdox.dao.RegistrationPersonImpl;
import com.jurdox.model.Person;

public class RegistrationPerson {

	public static final Logger log = Logger.getLogger("Registration:");

	private String firstName;
	private String lastName;
	private String gender;
	private String state;
	private String note;
	private Integer age;
	private List<Person> personsList = new ArrayList<Person>();

	public RegistrationPerson() {
		infoPerson();
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

	public List<Person> getPersonsList() {
		return personsList;
	}

	public void setPersonsList(List<Person> personsList) {
		this.personsList = personsList;
	}

	public void setEmptyFields() {
		setAge(null);
		setFirstName(null);
		setGender(null);
		setLastName(null);
		setNote(null);
		setState(null);
	}
	
	OperationWithPersonDAO operation = new RegistrationPersonImpl();
	
	public String registratePerson() {
		Person person = new Person();
		person.setAge(getAge());
		person.setFirstName(getFirstName());
		person.setLastName(getLastName());
		person.setGender(getGender());
		person.setNote(getNote());
		person.setState(getState());
		personsList.add(person);
		boolean result = operation.registratePerson(person);
		log.debug("Succes: " + result);
		setEmptyFields();

		return "person added";
	}

	public String infoPerson() {
		for (Person p : operation.infoAboutPerson(personsList)) {
			Person person = new Person();
			person.setAge(p.getAge());
			person.setFirstName(p.getFirstName());
			person.setLastName(p.getLastName());
			person.setGender(p.getGender());
			person.setNote(p.getNote());
			person.setState(p.getState());
			personsList.add(person);
		}

		return "info about person";
	}

}
