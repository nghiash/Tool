package com.laptrinhSpringMVC;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateOneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SessionFactory sessionFac = new Configuration().configure("hibernate.cfg.xml").
    		addAnnotatedClass(Instructor.class)
    		.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
    Session session = sessionFac.getCurrentSession();
    session.beginTransaction();

    Instructor instrToupdate =  session.get(Instructor.class, -45);
    instrToupdate.setEmail("ngan@gmail.com");
    Instructor newInstructor = instrToupdate;
    
    session.close();
    Session session2 = sessionFac.getCurrentSession();
    session2.beginTransaction();
    session2.save(newInstructor);
    session2.getTransaction().commit();
    session2.close();
    System.out.println("instrToupdate-email: "+instrToupdate.getEmail());
    
	}

}
