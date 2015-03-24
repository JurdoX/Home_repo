package com.jurdox.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jurdox.model.Person;
import com.jurdox.services.EditService;

public class PersonListView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Person> personsList;
	private EditService service = new EditService();

	/**
	 * constructor: view all person in the table
	 */
	public PersonListView() {
		personsList = new ArrayList<Person>();
		service.viewAllPersons(personsList);
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
	 * stop editing person and update person in DB
	 * 
	 * @return updated person
	 */
	public String saveChangedPerson() {
		service.saveChangedPerson(getPersonsList());

		return null;
	}

	/**
	 * delete person from list and DB
	 * 
	 * @param person
	 * @return
	 */
	public String deletePerson(Person person) {
		service.deletePerson(person, getPersonsList());

		return null;
	}

	/**
	 * navigate to registration form
	 * 
	 * @return registration page
	 */
	public String getRegistration() {
		return "registration";
	}

	public List<Person> getPersonsList() {
		return personsList;
	}

	public void setPersonsList(List<Person> personsList) {
		this.personsList = personsList;
	}

}
