package com.etnetera.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.etnetera.Utils.HibernateUtil;
import com.etnetera.model.Person;

public class OperationDaoImpl implements OperationDao {

	private static Logger logger = Logger.getLogger(OperationDaoImpl.class);
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void savePerson(Person person) {
		try {
			logger.info("Saving person...");
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			logger.error("Error: Save person not succes", e);
		}

	}

	public List<Person> selectPersonOnPage(List<Person> persons) {
		try {
			logger.info("Select persons from one page...");
			session.beginTransaction();
			Query q = session.createQuery("from Person");
			q.setFirstResult(3);
			q.setMaxResults(5);
			persons = q.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			logger.error("Error: Select persons not succes", e);
		}

		return persons;
	}
	
	public List<Person> selectAll(List<Person> persons) {
		try {
			logger.info("Select persons...");
			session.beginTransaction();
			persons = session.createQuery("from Person").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.error("Error: Select persons not succes", e);
		}

		return persons;
	}

}
