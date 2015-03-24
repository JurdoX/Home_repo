package com.jurdox.services;

import java.io.Serializable;

import com.jurdox.dao.PersonDAO;
import com.jurdox.dao.PersonDAOImpl;
import com.jurdox.model.Person;

public class RegistrationService implements Serializable {

	private static final long serialVersionUID = 1L;

	private PersonDAO dao = new PersonDAOImpl();

	/**
	 * create new person and save to DB
	 * 
	 * @param age
	 * @param name
	 * @param lastname
	 * @param gender
	 * @param note
	 * @param state
	 * @return null
	 */
	public String registratePerson(int age, String name, String lastname,
			String gender, String note, String state) {
		Person person = new Person();
		person.setAge(age);
		person.setFirstName(name);
		person.setLastName(lastname);
		person.setGender(gender);
		person.setNote(note);
		person.setState(state);
		dao.savePerson(person);

		return null;
	}

}
