package com.laptrinhSpringMVC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateONEtOoNE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     SessionFactory sessionFactor = new Configuration().configure("hibernate.cfg.xml").
    		 						addAnnotatedClass(Instructor.class).
    		 						addAnnotatedClass(InstructorDetail.class).
    		 						buildSessionFactory();
     Session session = sessionFactor.getCurrentSession();
     InstructorDetail instructureDetail = new InstructorDetail("nghia-youtube-channel","basketball");
     Instructor instructureDemo = new Instructor("thanh","nghia","nghiat.nguyen@btmglobal.com");
     instructureDemo.setInstructureDetail(instructureDetail);
     session.beginTransaction();
	 session.save(instructureDemo);
	 session.getTransaction().commit();
	}

}
