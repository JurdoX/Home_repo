package com.jurdox.view;

import org.primefaces.model.UploadedFile;

import com.jurdox.services.EmailService;

public class EmailView {

	private String emailTo;
	private String subject;
	private String textMessage;
	private UploadedFile uploadedFile;
	private int countOfEmails = 1;

	private EmailService service = new EmailService();

	public String sendEmail() {
		service.sendEmail(getEmailTo(), getSubject(), getTextMessage(),
				getUploadedFile(), getCountOfEmails());
		clear();

		return null;
	}

	public void clear() {
		setEmailTo("");
		setSubject("");
		setTextMessage("");
		setCountOfEmails(1);
	}

	/**
	 * navigate to registration form
	 * 
	 * @return registration page
	 */
	public String getRegistration() {
		return "registration";
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public int getCountOfEmails() {
		return countOfEmails;
	}

	public void setCountOfEmails(int countOfEmails) {
		this.countOfEmails = countOfEmails;
	}
}
