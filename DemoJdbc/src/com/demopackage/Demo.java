//package com.demopackage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class Demo {
//    public static void main(String[] args) throws Exception {
//        // Load the JDBC driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        // Establish connection to the database
//        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
//
//        // Create a statement object
//        Statement s = c.createStatement();
//
//        // Execute an SQL query to insert data
//        s.executeUpdate("INSERT INTO students VALUES (1, 'Shan' )");
//
//        // Print confirmation
//        System.out.println("Data is inserted successfully....");
//
//        // Close the connection
//        c.close();
//    }
//}
package com.demopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws Exception {
//        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            
            // Create statement object
            Statement s = c.createStatement();
            
            // Execute read query
            ResultSet rs = s.executeQuery("SELECT * FROM students");
            
            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
//                int age = rs.getInt("age"); // Example field
                System.out.println("ID: " + id + ", Name: " + name );
            }
            
            // Close the resources
            rs.close();
            c.close();
        }
//    catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }
