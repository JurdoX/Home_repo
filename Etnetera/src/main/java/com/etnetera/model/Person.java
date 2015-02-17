package com.etnetera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ETNETERA_PERSONS")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private Integer personId;
	@Column(name = "NAME", length = 20, nullable = false)
	private String name;
	@Column(name = "PHONE", length = 13, nullable = false)
	private String phone;
	@Column(name = "EMAIL", length = 30, nullable = false)
	private String email;
	@Column(name = "DATE", length = 30, nullable = true)
	private String date;
	@Column(name = "CLOSE", length = 10, nullable = true)
	private String close;
	@Column(name = "CHANGED", length = 10, nullable = true)
	private String changed;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getChanged() {
		return changed;
	}

	public void setChanged(String changed) {
		this.changed = changed;
	}

}
