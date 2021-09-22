package com.spring.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewDAO, Long>{
  @Query("select * from review where comment_review like '%commentRv%'")
  List<ReviewDAO>getTheReviewWithPartOfComment(@Param("commentRv")String commetReview);
}
