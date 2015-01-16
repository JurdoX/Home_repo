package com.jurdox.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jurdox.dao.OperationPersonImpl;
import com.jurdox.dao.OperationWithPersonDAO;
import com.jurdox.model.Person;

public class TableOfPersons implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Person> personsList;
	OperationWithPersonDAO operation = new OperationPersonImpl();

	public TableOfPersons() {
		personsList = new ArrayList<Person>();
		viewPerson();
	}
	
	public String viewPerson() {
		personsList.clear();
		for (Person p : operation.viewPerson(personsList)) {
			Person person = new Person();
			person.setAge(p.getAge());
			person.setFirstName(p.getFirstName());
			person.setLastName(p.getLastName());
			person.setGender(p.getGender());
			person.setNote(p.getNote());
			person.setPersonId(p.getPersonId());
			person.setState(p.getState());
			personsList.add(person);
		}

		return null;
	}
	
	public String editPerson(Person person) {
		person.setEditable(true);

		return null;
	}

	public String saveChangedPerson() {
		for (Person p : getPersonsList()) {
			if (p.isEditable()) {
				p.setEditable(false);
				operation.updatePerson(p);
			}
		}

		return null;
	}

	public String deletePerson(Person person) {
		personsList.remove(person);
		operation.deletePerson(person);

		return null;
	}
	
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
