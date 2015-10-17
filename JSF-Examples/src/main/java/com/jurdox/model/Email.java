package com.jurdox.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Email")
public class Email {

	@Id
	@GeneratedValue
	@Column(name = "EMAIL_ID")
	private Integer emailId;
	@Column(name = "SENDER")
	private String sender;
	@Column(name = "SUBJECT")
	private String subject;
	@Column(name = "MESSAGE")
	private String message;
	@Column(name = "ATTACHMENT")
	private boolean attachment;
	@Column(name = "DATE")
	private Date date;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isAttachment() {
		return attachment;
	}

	public void setAttachment(boolean attachment) {
		this.attachment = attachment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
