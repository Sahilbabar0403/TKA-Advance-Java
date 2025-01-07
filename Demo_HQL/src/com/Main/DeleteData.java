package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Emp;

public class DeleteData {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Emp.class);

        // Open session and start transaction
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        //  HQL query to delete by id
        String hql = "DELETE FROM Emp WHERE empid = :id";
        Query query = ss.createQuery(hql);
        query.setParameter("id", 2);

        // Execute the delete query
        int result = query.executeUpdate();
        System.out.println("Number of rows affected: " + result);

        // Commit the transaction
        tr.commit();
        
        // Close the session
        ss.close();
        sf.close();
    }
}


