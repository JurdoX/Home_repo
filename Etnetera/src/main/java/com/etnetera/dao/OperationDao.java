package com.etnetera.dao;

import java.util.List;

import com.etnetera.model.Person;

public interface OperationDao {
	public void savePerson(Person person);
	public List<Person> selectAll(List<Person> persons);
	public List<Person> selectPersonOnPage(List<Person> persons);
}
