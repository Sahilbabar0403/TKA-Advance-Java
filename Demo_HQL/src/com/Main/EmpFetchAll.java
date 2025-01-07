package com.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Emp;

public class EmpFetchAll {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Emp.class);
		
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		
		
		
		
		String HqlQuery= "from Emp";
		Query<Emp>query=ss.createQuery(HqlQuery,Emp.class);
		List<Emp>list=query.getResultList();
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		

	}
}

