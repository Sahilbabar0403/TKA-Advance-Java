package com.demopackage;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class Demo5 {
	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
	    }

	    // Insert data method
	    public void insertData() throws SQLException {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter ID: ");
	        int id = scanner.nextInt();
	        System.out.print("Enter Name: ");
	        String name = scanner.next();
	        
	        Connection c = getConnection();
	        Statement s = c.createStatement();
	        s.executeUpdate("INSERT INTO student (id, name) VALUES (" + id + ", '" + name + "')");
	        System.out.println("Data inserted successfully.");
	        s.close();
	        c.close();
	    }

	    // Update data method
	    public void updateData() throws SQLException {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter ID to update: ");
	        int id = scanner.nextInt();
	        System.out.print("Enter New Name: ");
	        String name = scanner.next();
	        
	        Connection c = getConnection();
	        Statement s = c.createStatement();
	        s.executeUpdate("UPDATE student SET name='" + name + "' WHERE id=" + id);
	        System.out.println("Data updated successfully.");
	        s.close();
	        c.close();
	    }

	    // Delete data method
	    public void deleteData() throws SQLException {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter ID to delete: ");
	        int id = scanner.nextInt();
	        
	        Connection c = getConnection();
	        Statement s = c.createStatement();
	        s.executeUpdate("DELETE FROM student WHERE id=" + id);
	        System.out.println("Data deleted successfully.");
	        s.close();
	        c.close();
	    }

	    // Fetch data method
	    public void fetchData() throws SQLException {
	        Connection c = getConnection();
	        Statement s = c.createStatement();
	        ResultSet rs = s.executeQuery("SELECT * FROM student");
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
	        }
	        rs.close();
	        s.close();
	        c.close();
	    }

	    // Main Method
	    public static void main(String[] args) throws SQLException {
	        Demo4 demo = new Demo4();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nChoose an operation:");
	            System.out.println("1 - Insert Data");
	            System.out.println("2 - Update Data");
	            System.out.println("3 - Delete Data");
	            System.out.println("4 - Fetch Data");
	            System.out.println("5 - Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    demo.insertData();
	                    break;
	                case 2:
	                    demo.updateData();
	                    break;
	                case 3:
	                    demo.deleteData();
	                    break;
	                case 4:
	                    demo.fetchData();
	                    break;
	                case 5:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}


