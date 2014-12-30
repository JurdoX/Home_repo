package com.jurdox.dao;

import java.util.List;

import com.jurdox.model.Person;

public interface OperationWithPersonDAO {

	public boolean registratePerson(Person person);
	public List<Person> infoAboutPerson(List<Person> persons);
	public boolean editPerson(Person person);
	public boolean deletePerson(Person person);
	
}
