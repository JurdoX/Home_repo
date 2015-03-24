package com.jurdox.services;

import java.io.Serializable;
import java.util.List;

import com.jurdox.dao.PersonDAO;
import com.jurdox.dao.PersonDAOImpl;
import com.jurdox.model.Person;

public class EditService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PersonDAO dao = new PersonDAOImpl();

	/**
	 * select all persons from DB and save to list
	 * 
	 * @return list of persons
	 */
	public String viewAllPersons(List<Person> list) {
		for (Person p : dao.selectAllPersons(list)) {
			Person person = new Person();
			person.setAge(p.getAge());
			person.setFirstName(p.getFirstName());
			person.setLastName(p.getLastName());
			person.setGender(p.getGender());
			person.setNote(p.getNote());
			person.setPersonId(p.getPersonId());
			person.setState(p.getState());
			list.add(person);
		}

		return null;
	}

	/**
	 * start editing person
	 * 
	 * @param person
	 * @return
	 */
	public String editPerson(Person person) {
		person.setEditable(true);

		return null;
	}

	/**
	 * stop editing person and updated person in DB
	 * 
	 * @return updated person
	 */
	public String saveChangedPerson(List<Person> list) {
		for (Person p : list) {
			if (p.isEditable()) {
				p.setEditable(false);
				dao.updatePerson(p);
			}
		}

		return null;
	}

	/**
	 * delete person from list and DB
	 * 
	 * @param person
	 * @return
	 */
	public String deletePerson(Person person, List<Person> list) {
		list.remove(person);
		dao.deletePerson(person);

		return null;
	}

}
