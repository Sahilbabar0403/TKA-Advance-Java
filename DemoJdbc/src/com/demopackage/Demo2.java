package com.demopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement s =c.createStatement();
		s.executeUpdate("Update students set name='Sayali' where id='1'");

		s.executeUpdate("insert into students values (2,'Sahil')");
		
		s.execute("Delete from Students where id='1'");
		
		System.out.println("Data Deleted Successfully");
		c.close();

	}

}
