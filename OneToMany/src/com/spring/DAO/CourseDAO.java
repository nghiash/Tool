package com.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="COURSE")
public class CourseDAO {
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE ,generator = "id_Seq")
	@SequenceGenerator(name="id_Seq", sequenceName = "SEQ_INSTRUCTOR")
	private int id;
	@Column(name="titile")
	private String titile;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<ReviewDAO> reviews;
	public List<ReviewDAO> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewDAO> reviews) {
		this.reviews = reviews;
	}
	public void setReview(ReviewDAO agrRev) {
		if(reviews == null) {
			reviews = new ArrayList<ReviewDAO>();
		}
			reviews.add(agrRev);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor_id) {
		this.instructor = instructor_id;
	}
	
	public CourseDAO(String titile) {
		this.titile = titile;
	}
	
	@Override
	public String toString() {
		return "CourseDAO [id=" + id + ", titile=" + titile + "]";
	}
	public CourseDAO() {
	}


}
