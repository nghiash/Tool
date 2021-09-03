package XmlfileToJavaObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InstructorXml {
	private String first_name;
	private String last_name;

	private String email;
	private InstructorDetailXml instructordetail;
	
	
	@Override
	public String toString() {
		return "InstructorXml [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", instructorDeatails=" + instructordetail + "]";
	}
	public InstructorXml() {
	}
	public InstructorXml(String first_name, String last_name, String email, InstructorDetailXml instructorDeatails) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.instructordetail = instructorDeatails;
	}
	public String getFirst_name() {
		return first_name;
	}
	@XmlElement
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	@XmlElement
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}
	public InstructorDetailXml getInstructorDeatails() {
		return instructordetail;
	}
	@XmlElement
	public void setInstructorDeatails(InstructorDetailXml instructorDeatails) {
		this.instructordetail = instructorDeatails;
	}
	

}
