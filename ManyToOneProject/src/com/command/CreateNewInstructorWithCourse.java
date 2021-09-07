package com.command;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.CourseDAO;
import com.dao.Instructor;
import com.dao.InstructorDetail;

public class CreateNewInstructorWithCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(CourseDAO.class)
							.buildSessionFactory();
				Instructor instructor = new Instructor("Ngan", "Thu", "Nghia's Lover");
				InstructorDetail instructorDetail = new  InstructorDetail("nghianguyenYoutubeChannel","basketballWithLove");
				instructor.setInstructureDetail(instructorDetail);
				List<CourseDAO>cousrseDaos = new ArrayList<CourseDAO>();
			    CourseDAO courseDao = new CourseDAO("learnToBeNghia'sLover");
			    cousrseDaos.add(courseDao);
			    instructor.setCourse(cousrseDaos);
			    Session session = sessionFactory.getCurrentSession();
			    try {
			    	
			    	session.beginTransaction();
			    	session.save(instructor);
			    	session.getTransaction().commit();
			    	session.close();
			    	
			    }catch(Exception ex) {
			    	ex.printStackTrace();
			    }finally {
			    	session.close();
					sessionFactory.close();
				}
			    
			    
	}

}
