package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Emp;

public class UpdateRecord {

	public static void main(String[] args) {
		Configuration cfg =new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Emp.class);
		
		SessionFactory sf =cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr  =ss.beginTransaction();
		
		
		String hqlQuery="update Emp set name=:name where id=:id ";
		Query<Emp>query= ss.createQuery(hqlQuery);
		query.setParameter("name", "Rahul");
		query.setParameter("id", 3);
		query.executeUpdate();
		System.out.println("Data deleted successfully");
		tr.commit();
		ss.close();

	}

}
