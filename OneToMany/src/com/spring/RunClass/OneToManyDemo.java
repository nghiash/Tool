package com.spring.RunClass;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.DAO.CourseDAO;
import com.spring.DAO.Instructor;
import com.spring.DAO.InstructorDetail;
import com.spring.DAO.ReviewDAO;
import com.spring.dataConfig.DataFactory;
import com.spring.logger.ConfigLogger;

public class OneToManyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigLogger.setLogConfig();
		Session session = DataFactory.getSession();

		ReviewDAO RVdAO = new ReviewDAO("This have good content2");
		CourseDAO couserDao = new CourseDAO("Course for Lover5");
		//List<ReviewDAO> reviewList = new ArrayList<ReviewDAO>();
		//reviewList.add(RVdAO);
		couserDao.setReview(RVdAO);
		try {
			session.beginTransaction();
			System.out.println("couserDao: "+couserDao.getReviews());
			session.save(couserDao);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.close();
			ex.printStackTrace();
		}

	}

}
