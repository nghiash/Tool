package com.laptrinhSpringMVC;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
