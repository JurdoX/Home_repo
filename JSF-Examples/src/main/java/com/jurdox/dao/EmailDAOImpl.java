package com.jurdox.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.jurdox.model.Email;
import com.jurdox.util.HibernateUtil;

public class EmailDAOImpl implements EmailDAO {

	final static Logger logger = Logger.getLogger(PersonDAOImpl.class);
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	/**
	 * save email to database
	 */
	@Override
	public void saveEmail(Email email) {
		try {
			logger.info("Saving email...");
			session.beginTransaction();
			session.save(email);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			logger.error("Error: Save email not success", e);
		}
	}

}
