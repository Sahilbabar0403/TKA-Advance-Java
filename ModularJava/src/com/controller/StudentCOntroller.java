package com.controller;

import java.util.Scanner;
import com.service.StudentService;

public class StudentController {
    public static void main(String[] args) throws Exception {
        // Create an instance of the StudentService class to perform CRUD operations
        StudentService s2 = new StudentService();
        
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Start an infinite loop to continuously show the menu
        while (true) {
            // Display operation menu to the user
            System.out.println("Choose an operation:");
            System.out.println("1 - Create Database");
            System.out.println("2 - Create Table");
            System.out.println("3 - Insert Data");
            System.out.println("4 - Update Data");
            System.out.println("5 - Delete Data");
            System.out.println("6 - Read Data ");
            System.out.println("Any other number to exit.");
            
            // Nested loop for handling user choice
            while (true) {
                // Read user input for the operation choice
                int choice = sc.nextInt();

                // Variable placeholders for database and table names (currently not used)
                String dbName = "";
                String tableName = "";

                // Switch case to perform the appropriate operation based on user choice
                switch (choice) {
                    case 1:
                        // Create the database by calling the CreateDb method from StudentService
                        s2.CreateDb();
                        break;
                    case 2:
                        // Create the table by calling the CreateTb method from StudentService
                        s2.CreateTb();
                        break;
                    case 3:
                        // Insert data into the table by calling the InsertData method
                        s2.InsertData();
                        break;
                    case 4:
                        // Update data in the table by calling the UpdateData method
                        s2.UpdateData();
                        break;
                    case 5:
                        // Delete data from the table by calling the DeleteData method
                        s2.DeleteData();
                        break;
                    case 6:
                        // Read data from the table by calling the ReadData method
                        s2.ReadData();
                        break;
                    default:
                        // If any number other than 1-6 is entered, exit the program
                        System.out.println("Exiting program.");
                        sc.close(); // Close the scanner object
                        return; // Exit the main method, ending the program
                }
            }
        }
    }
}
