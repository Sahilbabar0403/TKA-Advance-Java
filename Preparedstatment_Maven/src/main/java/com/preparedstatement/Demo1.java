package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Demo1 {	
	String url="jdbc:mysql://localhost:3306/PS";
	String username="root";
	String password="root";
	public void insertData () throws Exception {
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url,username,password
				);
		String query="Insert into emp values(?,?,?)";
		try(PreparedStatement ps = c.prepareStatement(query))
		{
			System.out.println("Inserting data into table");
			
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter id");
			int id=sc.nextInt();
			
			System.out.println("Enter name");
			String name =sc.next();
			
			System.out.println("Enter Salary");
			int sl=sc.nextInt();
			
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setInt(3, sl);
			ps.executeUpdate();
			System.out.println("Data Inserted successfully");
		}
		finally
		{
			c.close();
		}
		
	}
	public void UpdateData() throws Exception
	{		
		System.out.println("Updating Data");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url,username,password);
		String query="Update emp set salary =? where id=?";
		try(PreparedStatement ps=c.prepareStatement(query))
		{
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter the salary");
			int salary=sc.nextInt();
			System.out.println("Enter id");
			int id=sc.nextInt();
			
			ps.setInt(1, id);
			ps.setInt(2, salary);
			ps.executeUpdate();
			System.out.println("Data Updated successfully");
		}
		finally
		{
			c.close();
		}
		
	}
	
	public void Deletedata()throws Exception
	{
		Connection c =DriverManager.getConnection(url,password,username);
		String Query="Delete from emp where id=?";
		try(PreparedStatement ps =c.prepareStatement(Query))
		{
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter the id");
			int id=sc.nextInt();
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Data Deleted Successfully");
		}	
		finally
		{
			c.close();
		}
		}
	public void showData() throws Exception
	{
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c =DriverManager.getConnection(url,username,password);
		String query="Select * from emp";
		try(PreparedStatement ps =c.prepareStatement(query))
		{
			ResultSet rs =ps.executeQuery();
			boolean hasdata=false;
			while(rs.next())
			{
				hasdata=true;
				  System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getInt("salary"));
			}
			if(!hasdata)
			{
				System.out.println("Empty set");
			}
			
		}
		finally
		{
			c.close();
		}
	}
	public static void main(String[] args) throws Exception {
	Demo1 d1 =new Demo1();	
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter the choice");
	System.out.println("1- Insert Data");
	System.out.println("2- Update Data");
	System.out.println("3- Delete Data");
	System.out.println("4- Show Data");
	
	int userinput=sc.nextInt();
	switch (userinput) {
	case 1:
		d1.insertData();
		break;
	case 2:
		d1.UpdateData();
		break;
	case 3:
		d1.Deletedata();
		break;
	case 4:
		d1.showData();
		break;
	default:
		System.out.println("Wrong input");
		break;
	}
			
}
}