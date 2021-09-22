package com.spring.RunClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.ReviewDAO;
import com.spring.DAO.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
private ReviewRepository reviewrepo;
	public List<ReviewDAO> getReviewWithComment(String argComment){
		return reviewrepo.getTheReviewWithPartOfComment(argComment);
	}
}
