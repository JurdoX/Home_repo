package com.jurdox.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jurdox.utility.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate:");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Stock stock = new Stock();

		stock.setStockCode("4321");
		stock.setStockName("faaa");

		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}
}