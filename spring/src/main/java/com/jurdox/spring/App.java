package com.jurdox.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.jurdox.spring.database.Offer;
import com.jurdox.spring.database.OffersDao;
import com.jurdox.spring.logging.Logger;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/java/com/jurdox/spring/beans/beans.xml");

		// Person person = (Person) context.getBean("person");
		// System.out.println(person);
		//
		// Address address = (Address) context.getBean("address2");
		// System.out.println(address);
		//
		// Fruits fruits = (Fruits) context.getBean("fruits");
		// System.out.println(fruits);
		//
		// Jungle jungle = (Jungle) context.getBean("jungle");
		// System.out.println(jungle);

		// Logger logger = (Logger) context.getBean("logger");
		// logger.writeConsole("Hello there");
		// logger.writeFile("Hi again");

		// Robot robot = (Robot) context.getBean("robot");
		// robot.speak();

		OffersDao offerDao = (OffersDao) context.getBean("offersDao");
		
		Offer updateOffer = new Offer(7, "Krityna", "k@gmail.com", "fitness babe");
		if(offerDao.updateOffer(updateOffer)) {
			System.out.println("Offer updated");
		} else {
			System.out.println("Cannot be update");
		}
		
		try {
			Offer offer1 = new Offer("George", "myEmail@mail.com", "java coder");
			Offer offer2 = new Offer("Kate", "kate@mail.com", "tester babe");
			
			List<Offer> list = new ArrayList<Offer>();
			list.add(new Offer(18, "man1", "man1@gmail.com", "man1 text"));
			list.add(new Offer(19, "man2", "man2@gmail.com", "man2 text"));
			list.add(new Offer(23, "man3", "man3@gmail.com", "man3 text"));
			
			int[] rvals = offerDao.createOfferList(list);
			for(int value : rvals) {
				System.out.println("Updated: " + value + " rows");
			}
			
			if(offerDao.createOffer(offer1)) {
				System.out.println("Offer was created.");
			}
			
			if(offerDao.createOffer(offer2)) {
				System.out.println("Offer was created.");
			}
			
			System.out.println("Should be Mike: " + offerDao.getOffer(2));
			
			System.out.println("Delete offer: " + offerDao.deletedOffer(5));
			
			List<Offer> offers = offerDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get database connection.");
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
