package com.etnetera.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;

import com.etnetera.model.Person;
import com.etnetera.service.PersonService;

public class TableView implements Serializable {

	private static final long serialVersionUID = 1L;

	private PersonService service = new PersonService();
	private List<Person> list;
	private String email;

	// FIX IT
	public String sendExportDBToMail() {
		return null;
	}
	
	/**
	 * download ZIP file
	 * @param event
	 */
	public void download(ActionEvent event) {
		service.downloadEvent(event);
	}

	public TableView() {
		list = service.getList();
	}

	public List<Person> getList() {
		return list;
	}

	public void setList(List<Person> list) {
		this.list = list;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
