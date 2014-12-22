package com.jurdox.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.jurdox.model.Person;

public class DBConnectionUtil {

	private static SessionFactory factory = null;
	static {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		SessionFactory factory = config.buildSessionFactory();
	}

	public static Session openSession() {
		return factory.openSession();
	}

}
