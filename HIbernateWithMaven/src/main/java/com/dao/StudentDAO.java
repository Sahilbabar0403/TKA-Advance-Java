package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.Student;

public class StudentDAO {
	public void InsertData() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Scanner sc =new  Scanner(System.in);
		Student s1 =new Student();
		System.out.println("Enter the name");
		s1.setSname(sc.next());
		System.out.println("Enter the age");
		s1.setAge(sc.nextInt());
		System.out.println("Enter the Domain");
		s1.setSdomain(sc.next());
		
		System.out.println("data inserted successfully");
		ss.persist(s1);
		tr.commit();
		ss.close();
		
	}
	
	public void UpdateData()
	{
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Scanner sc = new Scanner(System.in);
		
		String hqlQuery= "Update Student set sname=:sname where sid =:sid";
		
		Query<Student>query=ss.createQuery(hqlQuery);
		System.out.println("Enter the name u have to update");
		query.setParameter("sname", sc.next());
		System.out.println("Enter the id");
		query.setParameter("sid", sc.nextInt());
		query.executeUpdate();
		System.out.println("Data updated successfully");
		tr.commit();
		ss.close();
	}

	public void Deletedata()
	{
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Scanner sc = new Scanner(System.in);
		
		String hqlQuery= "Delete Student where sid=:sid";
		
		Query<Student>query=ss.createQuery(hqlQuery);
		System.out.println("Enter the id u have to delete");
		query.setParameter("sid", sc.next());
		query.executeUpdate();
		System.out.println("Data updated successfully");
		tr.commit();
		ss.close();
	}
	public void FetchAlldata()
	{
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Scanner sc = new Scanner(System.in);
		
		String HqlQuery="From Student";
		Query<Student>query=ss.createQuery(HqlQuery);
		List<Student> list=query.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
	}
		
		
		
		public void FetchParticularData()
		{
			Configuration cfg =new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);
			
			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			Scanner sc = new Scanner(System.in);
			
			String HqlQuery = "From Student where sid =:sid";
			
			Query<Student>query=ss.createQuery(HqlQuery);
			
			System.out.println("Enter the id");
			query.setParameter("sid", sc.nextInt());
			Student s =query.getSingleResult();
			System.out.println(s);
			tr.commit();
			ss.close();
			
			
		
	}
	
	
}
