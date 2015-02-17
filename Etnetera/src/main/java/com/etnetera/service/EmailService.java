package com.etnetera.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import com.etnetera.Utils.EmailUtil;

public class EmailService {

	private static Logger logger = Logger.getLogger(EmailService.class);
	private EmailUtil email = new EmailUtil();

	public void completeMessage(String emailTo, String subject,
			String textMessage, UploadedFile file, int countOfEmails) {
		work(file);
		
		String [] to = emailTo.split(";");
		
		byte[] buffer = new byte[(int) file.getSize()];
		try {
			InputStream input = file.getInputstream();
			input.read(buffer);
			input.close();
		} catch (IOException e) {
			logger.error("Error in buffer: " + e);
		}

		email.sendTextMessage(to, subject, textMessage, file.getFileName(), 
				buffer, file.getContentType(), countOfEmails);
	}

	public void work(UploadedFile file) {
		logger.info("FILE_CONTENT: " + file.getContentType());
		logger.info("FILE_NAME: " + file.getFileName());
		logger.info("FILE_SIZE: " + file.getSize());
	}

}
