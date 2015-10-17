package com.jurdox.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import com.jurdox.dao.EmailDAO;
import com.jurdox.dao.EmailDAOImpl;
import com.jurdox.model.Email;
import com.jurdox.util.EmailUtil;

public class EmailService {

	private static Logger logger = Logger.getLogger(EmailService.class);
	private static Properties props = new Properties();
	private EmailDAO dao = new EmailDAOImpl();


	/**
	 * send email with/without attachment
	 * 
	 * @param emailTo: recipients
	 * @param subject for email
	 * @param textMessage: text in email
	 * @param file: attachment
	 * @param count: many sent email
	 */
	public void sendEmail(String emailTo, String subject, String textMessage,
			UploadedFile file, int count) {

		String[] receivers = emailTo.split(";");

		Message message = null;
		BodyPart part = null;
		Multipart multi = null;
		MimeBodyPart attachment = null;
		InputStream input = null;

		try {
			// load properties
			input = EmailUtil.class.getClassLoader().getResourceAsStream("email.properties");
			props.load(input);

			readEmail();
			
			// login to email
			multi = new MimeMultipart();
			message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));

			// set one or more recipients
			InternetAddress[] addressTo = new InternetAddress[receivers.length];
			for (int i = 0; i < receivers.length; i++) {
				addressTo[i] = new InternetAddress(receivers[i]);
			}
			message.setRecipients(Message.RecipientType.TO, addressTo);

			// set subject
			message.setSubject(subject);

			// create text message (text part)
			part = new MimeBodyPart();
			part.setText(textMessage);
			multi.addBodyPart(part);

			// add attachment (attachment part)
			if (file.getFileName() != null && !file.getFileName().equals("")) {
				logger.info("FILE_CONTENT: " + file.getContentType());
				logger.info("FILE_NAME: " + file.getFileName());
				logger.info("FILE_SIZE: " + file.getSize());
				attachment = new MimeBodyPart();
				attachment.setFileName(file.getFileName());
				attachment.setContent(setBuffer(file), file.getContentType());
				multi.addBodyPart(attachment);
			}

			// set content and send
			message.setContent(multi);
			for (int i = 0; i < count; i++) {
				Transport.send(message);
			}
		} catch (MessagingException e) {
			logger.error("Email does not send: " + e);
			throw new RuntimeException(e);
		} catch (IOException e) {
			logger.error("Problem with datasource: " + e);
		}
	}

	/**
	 * create email session
	 * 
	 * @return session
	 */
	public Session getSession() {
		return Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
					props.getProperty("mail.username"), 
					props.getProperty("mail.password"));
			}
		});
	}

	/**
	 * create buffer for content to attachment in email
	 * 
	 * @param file
	 * @return buffer
	 */
	public byte[] setBuffer(UploadedFile file) {
		byte[] buffer = new byte[(int) file.getSize()];
		try {
			InputStream input = file.getInputstream();
			input.read(buffer);
			input.close();
		} catch (IOException e) {
			logger.error("Error in buffer: " + e);
		}

		return buffer;
	}
	
	public void readEmail() {
		Store store;
		Folder emailFolder;
		try {
			// create the IMAP store object and connect with the IMAP server
			store = getSession().getStore();
			store.connect(props.getProperty("mail.imap.host"),
					props.getProperty("mail.username"),
					props.getProperty("mail.password"));

			// create the folder object and open it
			emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			logger.info("messages.length---" + messages.length);
			

			
			
			
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveEmail(boolean attachment, Date date, String message,
			String sender, String subject) {
		Email email = new Email();
		email.setAttachment(attachment);
		email.setDate(date);
		email.setMessage(message);
		email.setSender(sender);
		email.setSubject(subject);
		dao.saveEmail(email);

	}
}
