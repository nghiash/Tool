package com.spring.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class ReviewDAO {
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE ,generator = "id_Seq")
	@SequenceGenerator(name="id_Seq", sequenceName = "SEQ_INSTRUCTOR")
    @Column(name="id")
	private int id;
	@Column(name="comment_review")
	private String comment_review;
	public ReviewDAO() {
	}
	public ReviewDAO(String comment_review) {
		this.comment_review = comment_review;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment_review() {
		return comment_review;
	}
	public void setComment_review(String comment_review) {
		this.comment_review = comment_review;
	}

	@Override
	public String toString() {
		return "ReviewDAO [id=" + id + ", comment_review=" + comment_review + "";
	}
	
	
	
}
