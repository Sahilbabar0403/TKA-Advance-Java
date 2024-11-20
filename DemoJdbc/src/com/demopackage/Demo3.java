package com.demopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo3 {

	// Method to establish a connection
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
	}

	// Insert data method
	public void insertData() throws SQLException {
		Connection c = getConnection();
		String query = "INSERT INTO student (id, name) VALUES (?, ?)";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			System.out.println("Inserting Data to table");
//			get input from user
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			int id = scanner.nextInt();
			System.out.print("Enter name: ");
			String name = scanner.next();
			ps.setInt(1, id); // Setting the 'id' parameter
			ps.setString(2, name); // Setting the 'name' parameter
			scanner.close();
			ps.executeUpdate();
			System.out.println("Data inserted successfully.");
		} finally {
			c.close();
		}
	}

	// Update data method
	public void updateData() throws SQLException {
		Connection c = getConnection();
		String query = "UPDATE student SET name = ? WHERE id = ?";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			System.out.println("Updating Data in table");
//			use scanner to take input
			Scanner mScanner = new Scanner(System.in);

			System.out.print("Enter name: ");
			String name = mScanner.nextLine();

			System.out.print("Enter id: ");
			int id = mScanner.nextInt();

			ps.setString(1, name); // Setting the 'name' parameter
			ps.setInt(2, id); // Setting the 'id' parameter
			ps.executeUpdate();
			System.out.println("Data updated successfully.");
		} finally {
			c.close();
		}
	}

	// Delete data method
	public void deleteData() throws SQLException {
		Connection c = getConnection();
		String query = "DELETE FROM student WHERE id = ?";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			System.out.println("Deleting Data from table");
			Scanner mScanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			int id = mScanner.nextInt();
			ps.setInt(1, id); // Setting the 'id' parameter
			ps.executeUpdate();
			System.out.println("Data deleted successfully.");
		} finally {
			c.close();
		}
	}

	// Fetch data method
	public void fetchData() throws SQLException {
		Connection c = getConnection();
		String query = "SELECT * FROM student";
		try (PreparedStatement ps = c.prepareStatement(query); 
			ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
			}
		} finally {
			c.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		Demo3 ps = new Demo3();
//		use switch case
		Scanner mScanner = new Scanner(System.in);
		System.out.println("Enter Your Choice"); // Asking to choice from 1-4
		System.out.println("1- Insert Data");
		System.out.println("2- Update Data");
		System.out.println("3- Delete Data");
		System.out.println("4- Fetch Data");
		System.out.println("Wrong Input will exit and fetch data");

		int userInput = mScanner.nextInt();
		switch (userInput) {
		case 1: {
			ps.insertData();
			break;
		}
		case 2: {
			ps.updateData();
			break;
		}
		case 3: {
			ps.deleteData();
			break;
		}
		case 4: {
			ps.fetchData();
			break;
		}
		default:
			System.out.println("Wrong input");
		}
		if (userInput == 4) {

		} 
		else {
			ps.fetchData();
		}

	}
	

}