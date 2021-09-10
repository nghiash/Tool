package com.command;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.CourseDAO;
import com.dao.Instructor;
import com.dao.InstructorDetail;

public class CreateCourseForInstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(CourseDAO.class)
				.buildSessionFactory();
		//Instructor instructor = new Instructor("Ngan", "Thu", "Nghia's Lover");
		
		CourseDAO course1 = new CourseDAO("IT Course 2021");
		CourseDAO course2 = new CourseDAO("Piano Course 2021");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Instructor instructor = session.get(Instructor.class, -27);
		instructor.add(course1);
		instructor.add(course2);
		session.save(course1);
		session.save(course2);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
