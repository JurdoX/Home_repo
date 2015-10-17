package com.jurdox.spring;

public class PersonFactory {

	public Person createPerson(int id, String name) {
		System.out.println("Factory person");
		return new Person(789, "Kika");
	}
}
