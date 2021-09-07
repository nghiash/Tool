package com.command;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.Instructor;
import com.dao.InstructorDetail;

public class QueryCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFact = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();

	}

}
