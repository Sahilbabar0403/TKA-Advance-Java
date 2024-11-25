package com.dao;

import java.sql.*;
import java.util.Scanner;

public class StudentDao {

    // Database connection details
    String url = "jdbc:mysql://localhost:3306/Registration"; // Database already specified in the URL
    String username = "root";
    String password = "root";

    // Method to create a database
    public void CreateDb() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306", username, password);
             Statement s = c.createStatement()) {

            s.execute("CREATE DATABASE IF NOT EXISTS Registration");
            System.out.println("Database created successfully (or already exists).");
        }
    }

    // Method to create a table
    public void CreateTB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection c = DriverManager.getConnection(url, username, password);
             Statement s = c.createStatement()) {

            s.executeUpdate("CREATE TABLE IF NOT EXISTS Registration.Demo (id INT PRIMARY KEY, name TEXT, salary INT)");
            System.out.println("Table created successfully (or already exists).");
        }
    }

    // Method to insert data into the table
    public void InsertTB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "INSERT INTO Registration.Demo VALUES (?, ?, ?)";
        try (Connection c = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = c.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter the id:");
            int id = sc.nextInt();
            ps.setInt(1, id);

            System.out.println("Enter the name:");
            String name = sc.next();
            ps.setString(2, name);

            System.out.println("Enter the salary:");
            int salary = sc.nextInt();
            ps.setInt(3, salary);

            ps.executeUpdate();
            System.out.println("Data inserted successfully.");
        }
    }

    // Method to update data in the table
    public void UpdateTB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "UPDATE Registration.Demo SET name = ? WHERE id = ?";
        try (Connection c = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = c.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter the name:");
            String name = sc.next();
            ps.setString(1, name);

            System.out.println("Enter the id:");
            int id = sc.nextInt();
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        }
    }

    // Method to delete data from the table
    public void DeleteTb() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "DELETE FROM Registration.Demo WHERE id = ?";
        try (Connection c = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = c.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter the id:");
            int id = sc.nextInt();
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        }
    }

    // Method to read data from the table
    public void ReadTb() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT * FROM Registration.Demo";
        try (Connection c = DriverManager.getConnection(url, username, password);
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getInt("salary"));
            }
        }
    }
}
