package com.laptrinhSpringMVC;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import XmlfileToJavaObject.InstructorXml;

public class ReadXmlAndCreateOneOnOne {


	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		File xmlFile = new File("C:\\NOTEFORBTM\\ReadXmlAndCreateOneToOne\\instructor.xml");
		try {
			JAXBContext jabx = JAXBContext.newInstance(InstructorXml.class);
			Unmarshaller mashaller = jabx.createUnmarshaller();
			InstructorXml instructorXml = (InstructorXml)mashaller.unmarshal(xmlFile);
			System.out.println("instructor_email:"+instructorXml.getEmail());
			System.out.println("Youtube channel:"+instructorXml.getInstructorDeatails().getYoutube_channel());
			Instructor newInstructor = new Instructor(instructorXml.getFirst_name(),instructorXml.getLast_name(),instructorXml.getEmail());
			InstructorDetail instructorDetailXml = new InstructorDetail(instructorXml.getInstructorDeatails().getYoutube_channel(), instructorXml.getInstructorDeatails().getHobby());
		    newInstructor.setInstructureDetail(instructorDetailXml);
			OneToOneDataFactory.saveData(newInstructor);
		}catch(JAXBException ex) {
			ex.printStackTrace();
		}

	}

}
