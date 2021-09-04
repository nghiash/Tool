package com.laptrinhSpringMVC;

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
@Table(name="INSTRUCTOR_DETAIL")
public class InstructorDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
  @SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_INSTRUCTOR_DETAIL")
  @Column(name="id")
  private int id;
  @Column(name="youtube_channel")
  private String youtubeChannel;
  @Column(name="hobby")
  private String hobby;
  //@OneToOne(mappedBy = "instructor_Detail", cascade = CascadeType.ALL)
  @OneToOne(mappedBy = "instructor_Detail",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST
		  ,CascadeType.REFRESH}) // Use all cascade type except Remove to break BI - DIRECT. Now, we can delete only the Instructor detail component
  private Instructor instrutor;
public Instructor getInstrutor() {
	return instrutor;
}
public void setInstrutor(Instructor instrutor) {
	this.instrutor = instrutor;
}
public InstructorDetail() {
}
public InstructorDetail(String youtubeChannel, String hobby) {
	this.youtubeChannel = youtubeChannel;
	this.hobby = hobby;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getYoutubeChannel() {
	return youtubeChannel;
}
public void setYoutubeChannel(String youtubeChannel) {
	this.youtubeChannel = youtubeChannel;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
@Override
public String toString() {
	return "InstructureDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
}
  
}
