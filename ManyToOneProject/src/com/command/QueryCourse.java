package com.command;


import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.CourseDAO;
import com.dao.Instructor;
import com.dao.InstructorDetail;

public class QueryCourse {
	
	private static Logger _logger = LogManager.getLogger(QueryCourse.class);
	public static void main(String[] args) {
		ConfigLogger.readConfigFile();
		// TODO Auto-generated method stub
		SessionFactory sessionFact = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(CourseDAO.class)
									.buildSessionFactory();
		System.out.println("listCourse "+getCourseList(sessionFact).toString());
	}
	private static List<CourseDAO> getCourseList(SessionFactory sessionFact){
		List<CourseDAO>listCourse = null;
		try {
        	_logger.info("Start get Course");
        	Session session = sessionFact.getCurrentSession();
        	session.beginTransaction();
        	Instructor inst =  session.get(Instructor.class, 1);
        	listCourse = inst.getCourse();
        	
        	session.getTransaction().commit();
        	session.close();
        } catch(Exception ex) {
        	ex.printStackTrace();
        	_logger.error("Error when commit query Course");
        }
		return listCourse;
	}

}
