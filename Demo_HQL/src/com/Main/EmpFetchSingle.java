package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Emp;

public class EmpFetchSingle {

	public static void main(String[] args) {
	Configuration cfg =new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Emp.class);
	
	SessionFactory sf =cfg.buildSessionFactory();
	Session ss =sf.openSession();
	Transaction tr =ss.beginTransaction();
	
	String HqlQuery ="From Emp where empid=:id";
	Query<Emp>query=ss.createQuery(HqlQuery,Emp.class);
	query.setParameter("id", 2);
	Emp e =query.getSingleResult();
	System.out.println(e);
	
	
	
	}

}
