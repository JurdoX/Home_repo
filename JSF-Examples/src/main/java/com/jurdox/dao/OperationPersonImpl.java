package com.jurdox.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.jurdox.model.Person;
import com.jurdox.util.HibernateUtil;

/**
 * this class implemented operations: select, insert, update, delete
 * 
 * @author JurdoX
 *
 */
public class OperationPersonImpl implements OperationWithPersonDAO {

	final static Logger logger = Logger.getLogger(OperationPersonImpl.class);
	
	/**
	 * save person to database
	 */
	@Override
	public boolean savePerson(Person person) {
		
		boolean success = false;

		try {
			logger.info("Saving person...");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			session.close();

			success = true;
		} catch (HibernateException e) {
			logger.error("Error: Save person not succes", e);
		}

		return success;
	}

	/**
	 * select all persons from database
	 * 
	 * @return list of persons
	 */
	@Override
	public List<Person> viewPerson(List<Person> persons) {
		try {
			logger.info("Selecting persons...");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			persons = session.createQuery("from Person").list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			logger.error("Error: Select from table not succes", e);
		}
		return persons;
	}

	/**
	 * update person
	 */
	@Override
	public boolean updatePerson(Person person) {

		boolean success = false;

		try {
			logger.info("Editing person...");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(person);
			session.getTransaction().commit();
			session.close();

			success = true;
		} catch (HibernateException e) {
			logger.error("Error: Edit person not succes", e);
		}

		return success;

	}

	/**
	 * delete person from database
	 */
	@Override
	public boolean deletePerson(Person person) {
		
		boolean success = false;

		try {
			logger.info("Deleting person...");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(person);
			session.getTransaction().commit();
			session.close();

			success = true;
		} catch (HibernateException e) {
			logger.error("Error: Delete person not succes", e);
		}

		return success;
	}

}
