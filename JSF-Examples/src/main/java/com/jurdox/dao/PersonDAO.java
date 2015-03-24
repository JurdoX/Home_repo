package com.jurdox.dao;

import java.util.List;

import com.jurdox.model.Person;

public interface PersonDAO {

	public void savePerson(Person person);

	public List<Person> selectAllPersons(List<Person> persons);

	public List<Person> selectPersonPage(List<Person> persons);

	public void updatePerson(Person person);

	public void deletePerson(Person person);

}
