package com.jurdox.model;

import org.apache.log4j.Logger;

public class Person {

	private Logger log = Logger.getLogger(Person.class);

	private String firstName;
	private String lastName;
	private String gender;
	private String state;
	private String note;
	private Integer age;

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

	public String print() {

		log.debug("Start logging");

		System.out.println("Name: " + getFirstName());
		System.out.println("Surname: " + getLastName());
		System.out.println("Gender: " + getGender());
		System.out.println("State: " + getState());
		System.out.println("Age: " + getAge());
		System.out.println("Note: " + getNote());

		return null;
	}
}
