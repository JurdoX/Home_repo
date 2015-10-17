package com.jurdox.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jurdox.model.Person;
import com.jurdox.util.HibernateUtil;

/**
 * this class implemented operations: select, insert, update, delete
 * 
 * @author JurdoX
 *
 */
public class PersonDAOImpl implements PersonDAO {

	final static Logger logger = Logger.getLogger(PersonDAOImpl.class);
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	/**
	 * save person to database
	 */
	@Override
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

	/**
	 * select all persons from database
	 * 
	 * @return list of persons
	 */
	@Override
	public List<Person> selectAllPersons(List<Person> persons) {
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
	 * select persons from one page (for paging)
	 * 
	 * @return persons
	 */
	@Override
	public List<Person> selectPersonPage(List<Person> persons) {
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

	/**
	 * update person
	 */
	@Override
	public void updatePerson(Person person) {
		try {
			logger.info("Editing person...");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(person);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			logger.error("Error: Edit person not succes", e);
		}
	}

	/**
	 * delete person from database
	 */
	@Override
	public void deletePerson(Person person) {
		try {
			logger.info("Deleting person...");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(person);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			logger.error("Error: Delete person not succes", e);
		}
	}

}
