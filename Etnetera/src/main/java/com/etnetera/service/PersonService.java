package com.etnetera.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.etnetera.Utils.Helper;
import com.etnetera.dao.OperationDao;
import com.etnetera.dao.OperationDaoImpl;
import com.etnetera.model.Person;

public class PersonService {

	private static Logger logger = Logger.getLogger(PersonService.class);
	private List<Person> list = new ArrayList<Person>();
	private OperationDao operation = new OperationDaoImpl();
	private Helper helper = new Helper();
	private boolean isDownload = false;
	
	/**
	 * download ZIP file which content CSV file
	 * @param fileName
	 * @param content
	 */
	public void downloadFile(String fileName, String content) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();

		ec.responseReset();
		ec.setResponseContentType("application/zip");
		ec.setResponseHeader("Content-Disposition", "attachment; filename=file.zip");
		try {
			OutputStream output = ec.getResponseOutputStream();
			ZipOutputStream zos = new ZipOutputStream(output);
			ZipEntry entry = new ZipEntry(fileName);

			// CSV file to ZIP
			zos.putNextEntry(entry);
			zos.write(content.getBytes());
			zos.closeEntry();
			zos.close();
		} catch (IOException e) {
			logger.error("DOWNLOAD Error: " + e);
		}
		
		fc.responseComplete();
	}

	/**
	 * for action event in view
	 * @param event
	 */
	public void downloadEvent(ActionEvent event) {
			isDownload = true;
			downloadFile("file.csv", helper.createCSV(getList()));
	}

	/**
	 * save person to DB
	 * @param name
	 * @param phone
	 * @param email
	 */
	public void savePerson(String name, String phone, String email) {
		OperationDao op = new OperationDaoImpl();
		Person p = new Person();
		p.setName(name);
		p.setPhone(phone);
		p.setEmail(email);
		p.setDate(helper.getElement("date"));
		p.setClose(helper.getElement("close"));
		p.setChanged(helper.getElement("change"));
		op.savePerson(p);
	}

	/**
	 * select all persons from DB
	 * @return list of persons
	 */
	public List<Person> getList() {
		if (!isDownload) {
			for (Person p : operation.selectAll(list)) {
				Person person = new Person();
				person.setName(p.getName());
				person.setPhone(p.getPhone());
				person.setEmail(p.getEmail());
				person.setDate(p.getDate());
				person.setClose(p.getClose());
				person.setChanged(p.getChanged());
				list.add(person);
			}
			return list;
		}

		return list;
	}

	public void setList(List<Person> list) {
		this.list = list;
	}

}
