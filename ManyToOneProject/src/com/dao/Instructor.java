package com.dao;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "INSTRUCTOR")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_INSTRUCTOR")
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Instructor() {
	}
 
	
   @Override
	public String toString() {
		return "Instructure [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructureDetail=" + instructor_Detail + "]";
	}


@OneToOne(cascade = CascadeType.ALL)
 private InstructorDetail instructor_Detail;
public InstructorDetail getInstructureDetail() {
	return instructor_Detail;
}
public void setInstructureDetail(InstructorDetail instructor_Detail_arg) {
	this.instructor_Detail = instructor_Detail_arg;
}
@OneToMany(mappedBy = "instructor_id", cascade= {CascadeType.DETACH,CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
private List<CourseDAO>course;
public List<CourseDAO> getCourse() {
	return course;
}
public void setCourse(List<CourseDAO> course) {
	this.course = course;
}

}
