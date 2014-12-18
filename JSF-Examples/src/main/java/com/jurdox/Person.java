package com.jurdox;

public class Person {

	private String firstName;
	private String lastName;
	private String gender;
	private String state;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String print() {
		System.out.println("Name: " + getFirstName());
		System.out.println("Surname: " + getLastName());
		System.out.println("Gender: " + getGender());
		System.out.println("State: " + getState());
		System.out.println("Age: " + getAge());

		return null;
	}
}
