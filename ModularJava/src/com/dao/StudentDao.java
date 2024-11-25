package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDao {
	
	String url = "jdbc:mysql://localhost:3306/Registartion"; // Update your database name here
	String username = "root";
	String password = "root";

	
	//create Db
	
	public void CreateDb()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url, username, password);
		
		Statement s =c.createStatement();
		s.execute("Create database Registartion");
		s.close();
		c.close();
	}
	public void CreateTB()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url, username, password);
		
		Statement s =c.createStatement();
		s.executeUpdate("Create table Registartion.Demo(id int Primary key, name text,salary int)");
		System.out.println("Table created successfully");
		s.close();
		c.close();
	}
	public void InsertTB()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url, username, password);
		String Query="Insert into Registartion.Demo values(?,?,?)";
		try(PreparedStatement ps =c.prepareStatement(Query))
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id");
			int id =sc.nextInt();
			ps.setInt(1, id);
			System.out.println("Enter the name");
			String name =sc.next();
			ps.setString(2, name);
			System.out.println("Enter the salary");
			int sl=sc.nextInt();
			ps.setInt(3, sl);
			ps.executeUpdate();
			System.out.println("Data inserted successfully");
		}
		finally
		{
			c.close();
		}
	}
	public void UpdateTB()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url, username, password);
		String Query="Update Demo set name =? where id =?";
		try(PreparedStatement ps =c.prepareStatement(Query))
		{
			Scanner sc =new  Scanner(System.in);
			System.out.println("Enter the name");
			String name =sc.next();
			ps.setString(1, name);
			System.out.println("Enter the id");
			int id =sc.nextInt();
			ps.setInt(2, id);
			System.out.println("Data Updated successfully");
			ps.executeUpdate();
		}
		finally
		{
			c.close();
		}
	}
	
	public void DeleteTb()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url, username, password);
		String Query="Delete from Demo where id=?";
		try(PreparedStatement ps =c.prepareStatement(Query))
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id");
			int id=sc.nextInt();
			
			ps.setInt(1, id);
			System.out.println("Data Deleted successfully");
		}
		finally {
			c.close();
		}
	}
	public void ReadTb()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url, username, password);
		Statement s =c.createStatement();
		ResultSet ps =s.executeQuery("Select * from Demo");
		while (ps.next()) {
			System.out.println(ps.getInt("Id")+"-"+ps.getString("name")+"-"+ps.getInt("salary"));
		}
		c.close();
	}
}
