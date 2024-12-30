package com.homepractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpMain {

	public static void main(String[] args) {
	
	Configuration cfg =new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Employee.class);
	SessionFactory sf =cfg.buildSessionFactory();
	Session ss =sf.openSession();
	Transaction ts = ss.beginTransaction();
	System.out.println("started");

	}

}
