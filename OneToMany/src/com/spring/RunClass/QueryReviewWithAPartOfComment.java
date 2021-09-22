package com.spring.RunClass;

import java.util.List;

import org.springframework.beans.ExtendedBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.DAO.ReviewDAO;
import com.spring.DAO.ReviewRepository;
import com.spring.logger.ConfigLogger;


public class QueryReviewWithAPartOfComment {
    
    @Autowired
    private static ReviewService reviewSer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ConfigLogger.setLogConfig();
    AnnotationConfigApplicationContext context = 
    		new AnnotationConfigApplicationContext();
    context.refresh();
    context.scan("com.spring.DAO");
	//ReviewRepository reviewRepo =
	//	 context.getBean(ReviewRepository.class);
	//List<ReviewDAO> reviewDao =  reviewRepo.getTheReviewWithPartOfComment("good");
		 List<ReviewDAO> reviewDao =  reviewSer.getReviewWithComment("good");
	if(reviewDao.size()!=0 && reviewDao!=null ) {
	for(int i =0 ; i< reviewDao.size(); i++) {
		System.out.println(reviewDao.get(i).getComment_review());
	}
	}else {
		System.out.println("No records was found");
	}
	
	}

}
