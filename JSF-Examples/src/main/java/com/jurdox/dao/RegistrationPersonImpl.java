package com.jurdox.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.jurdox.model.Person;
import com.jurdox.util.DBConnectionUtil;
import com.jurdox.util.HibernateUtil;

public class RegistrationPersonImpl implements RegistrationPersonDAO {

	public boolean registratePerson(Person person) {

		boolean success = false;
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			session.close();
			
			success = true;
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	
		return success;
	}

}
