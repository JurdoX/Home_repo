package com.jurdox.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jurdox.model.Person;
import com.jurdox.util.HibernateUtil;

public class RegistrationPersonImpl implements OperationWithPersonDAO {

	public boolean registratePerson(Person person) {

		boolean success = false;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			session.close();

			success = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return success;
	}

	public List<Person> infoAboutPerson(List<Person> persons) {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			persons = session.createQuery("from Person").list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return persons;
	}

	public boolean editPerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

}
