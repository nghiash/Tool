package com.command;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.CourseDAO;
import com.dao.Instructor;
import com.dao.InstructorDetail;

public class DeleteCourseDemo {
    private static Logger _logger = LogManager.getLogger(DeleteCourseDemo.class);
	public static void main(String[] args) {
		//String log4jConfPath = "C:\\Users\\nghiat.nguyen\\learnSpringws\\GitHUbRepo\\Tool\\ManyToOneProject\\conf\\log4j.properties";
		String log4jConfPath = "src/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(CourseDAO.class)
									.buildSessionFactory();
		
		
		try {
			_logger.info("Start to delete Course");
			int idCourse = 15;
			Session session = sessionFactory.getCurrentSession();
			
			session.beginTransaction();
			CourseDAO courseToDelete = session.get(CourseDAO.class, idCourse);
			session.delete(courseToDelete);
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception ex) {
			_logger.error("Can not delete course demo");
		}
		
	}

}
