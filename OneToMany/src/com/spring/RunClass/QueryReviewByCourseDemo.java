package com.spring.RunClass;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.spring.DAO.CourseDAO;
import com.spring.dataConfig.DataFactory;
import com.spring.logger.ConfigLogger;

public class QueryReviewByCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ConfigLogger.setLogConfig();
      Session session = DataFactory.getSession();
      try {
    	  session.beginTransaction();
    	  CourseDAO course = session.get(CourseDAO.class, 59);
    	  System.out.println("Get review: "+ course.getReviews());
    	  session.close();
    	  }catch(Exception ex) {
    		  session.close();
    		  ex.printStackTrace();
    	  }
      
      }

}
