package com.laptrinhSpringMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		/*
		 * SessionFactory sessionFactory = new
		 * Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); Session
		 * adsession = sessionFactory.getCurrentSession();
		 * 
		 */
		  Connection conn = DriverManager.getConnection(
		  "jdbc:oracle:thin:@vnmaxi03.clienttest.btmgcs.com:1521:epsilon","epsilon",
		  "Btmgcs4mau"); if(conn!= null) { //user_test
		  System.out.println("Success to connect to db"); }else {
		  System.out.println("Cant connect db"); }
		 
	
		//session.close();
		
	}
}
