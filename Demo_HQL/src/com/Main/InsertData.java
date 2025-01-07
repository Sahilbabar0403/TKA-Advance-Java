package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Emp;

public class InsertData {

	public static void main(String[] args) {

			Configuration cfg =new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Emp.class);
			
			SessionFactory sf =cfg.buildSessionFactory();
			Session ss = sf .openSession();
			Transaction tr =ss.beginTransaction();
			
			String hqlQuery ="insert into Emp (name,Domain,Salary)values(:name,:Domain,:Salary)";
			Query<Emp>query=ss.createQuery(hqlQuery);
			query.setParameter("name", "Sahil");
			query.setParameter("Domain", "Tester");
			query.setParameter("Salary", "85000");
			query.executeUpdate();
			
			System.out.println("Data Inserted Successfully");
			tr.commit();
			ss.close();
			
			
	}

}
