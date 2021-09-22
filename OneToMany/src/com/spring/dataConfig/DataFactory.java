package com.spring.dataConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.DAO.CourseDAO;
import com.spring.DAO.Instructor;
import com.spring.DAO.InstructorDetail;
import com.spring.DAO.ReviewDAO;

public class DataFactory {
	public static Session getSession() {
		SessionFactory sessionFact = new Configuration().configure()
				
				.addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(CourseDAO.class)
				.addAnnotatedClass(ReviewDAO.class).buildSessionFactory();
		Session session = sessionFact.getCurrentSession();
		return session;	
	}
}
