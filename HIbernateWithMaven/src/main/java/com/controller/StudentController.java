package com.controller;

import com.service.StudentService;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        // Create an instance of StudentService
        StudentService ss = new StudentService();
        
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        int choice;
        
        // Loop to keep showing the menu until the user chooses to exit
        do {
            // Display the menu to the user
            System.out.println("\nSelect an operation:");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Fetch All Data");
            System.out.println("5. Fetch Particular Data");
            System.out.println("6. Exit");

            // Read user choice
            choice = sc.nextInt();

            // Switch statement to handle user choice
            switch (choice) {
                case 1:
                    // Insert data
                    ss.InsertData();
                    break;
                case 2:
                    // Update data
                    ss.UpdateData();
                    break;
                case 3:
                    // Delete data
                    ss.DeleteData();
                    break;
                case 4:
                    // Fetch all data
                    ss.FetchAllData();
                    break;
                case 5:
                    // Fetch particular data
                    ss.FetchParticularData();
                    break;
                case 6:
                    // Exit program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (choice != 6);  // Loop continues until user selects '6' to exit

        // Close scanner
        sc.close();
    }
}
