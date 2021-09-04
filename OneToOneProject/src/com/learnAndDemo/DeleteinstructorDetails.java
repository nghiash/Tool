package com.learnAndDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.laptrinhSpringMVC.Instructor;
import com.laptrinhSpringMVC.InstructorDetail;

public class DeleteinstructorDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SessionFactory sessionFact = new Configuration().configure("hibernate.cfg.xml")
    							.addAnnotatedClass(Instructor.class)
    							.addAnnotatedClass(InstructorDetail.class)
    							.buildSessionFactory();
    Session session = sessionFact.getCurrentSession();
     try {
    	session.beginTransaction();
    	InstructorDetail instructorDetailsDelete = session.get(InstructorDetail.class, -27);
    	System.out.println("instructorDetailsDelete_hobby :"+instructorDetailsDelete.getYoutubeChannel());
    	//Instructor instructorToDelete = session.get(Instructor.class, -46);
    	instructorDetailsDelete.getInstrutor().setInstructureDetail(null); // set null to instrucdetail to break BI Directional
    	session.delete(instructorDetailsDelete);
        session.getTransaction().commit();
        session.close();
    }catch(Exception ex) {
    	ex.printStackTrace();
    }finally {
		session.close();
		sessionFact.close();
	}
    
    
	}

}
