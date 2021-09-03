package com.laptrinhSpringMVC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDataFactory {

  public static void saveData(Instructor instructor) {
	  SessionFactory sessionFact = new Configuration().configure("hibernate.cfg.xml")
			  .addAnnotatedClass(Instructor.class)
			  .addAnnotatedClass(InstructorDetail.class)
			  .buildSessionFactory();
	  Session session = sessionFact.getCurrentSession();
	  session.beginTransaction();
	  session.save(instructor);
	  session.getTransaction().commit();
	  session.close();
  }
}
