package com.jurdox.util;

import java.io.IOException;
import java.io.InputStream;
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

// TODO: INBOX
// TODO: FORWARD EMAIL
// TODO: CHECK NAMES (CTRL + K)
// TODO: CHECK MORE RECIPIENTS

public class EmailUtil {

	private static Properties props = new Properties();
	private static Logger logger = Logger.getLogger(EmailUtil.class);

	/**
	 * send email with/without attachment
	 * 
	 * @param emailTo
	 *            : recipient/recipients
	 * @param subject
	 * @param textMessage
	 * @param filename
	 *            : attachment
	 * @param buffer
	 *            : body of attachment
	 * @param type
	 *            : type of file/attachment
	 * @param count
	 *            : how many email want to send (bomber)
	 */
	public void sendTextMessage(String[] emailTo, String subject,
			String textMessage, String filename, byte[] buffer, String type,
			int count) {

		Message message = null;
		BodyPart part = null;
		Multipart multi = null;
		MimeBodyPart attachment = null;
		InputStream input = null;

		try {
			// load properties
			input = EmailUtil.class.getClassLoader().getResourceAsStream(
					"email.properties");
			props.load(input);

			// login to email
			multi = new MimeMultipart();
			message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(props
					.getProperty("mail.username")));

			// set one or more recipients
			InternetAddress[] addressTo = new InternetAddress[emailTo.length];
			for (int i = 0; i < emailTo.length; i++) {
				addressTo[i] = new InternetAddress(emailTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, addressTo);

			// set subject
			message.setSubject(subject);

			// create text message (text part)
			part = new MimeBodyPart();
			part.setText(textMessage);
			multi.addBodyPart(part);

			// add attachment (attachment part)
			if (filename != null && !filename.equals("")) {
				attachment = new MimeBodyPart();
				attachment.setFileName(filename);
				attachment.setContent(buffer, type);
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
	public static Session getSession() {
		return Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props
						.getProperty("mail.username"), props
						.getProperty("mail.password"));
			}
		});
	}

	public static void main(String[] args) throws Exception {
		// create the POP3 store object and connect with the pop server
		Store store = getSession().getStore();
		store.connect();

		// create the folder object and open it
		Folder emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);

		// retrieve the messages from the folder in an array and print it
		Message[] messages = emailFolder.getMessages();
		System.out.println("messages.length---" + messages.length);
	}

}
