package com.jurdox.dao;

import java.util.List;

import com.jurdox.model.Person;

public interface OperationWithPersonDAO {

	public boolean savePerson(Person person);
	public List<Person> viewPerson(List<Person> persons);
	public boolean updatePerson(Person person);
	public boolean deletePerson(Person person);
	
}
