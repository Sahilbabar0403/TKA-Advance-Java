package com.service;

import com.dao.StudentDao; // Importing the DAO class

public class StudentService {

    // Method to delegate the database creation to the DAO layer
    public void CreateDb() throws Exception {
        StudentDao s1 = new StudentDao(); // Create an instance of StudentDao
        s1.CreateDb(); // Call the DAO method to create a database
    }

    // Method to delegate the table creation to the DAO layer
    public void CreateTb() throws Exception {
        StudentDao s1 = new StudentDao(); // Create an instance of StudentDao
        s1.CreateTB(); // Call the DAO method to create a table
    }

    // Method to delegate the data insertion to the DAO layer
    public void InsertData() throws Exception {
        StudentDao s1 = new StudentDao(); // Create an instance of StudentDao
        s1.InsertTB(); // Call the DAO method to insert data into the table
    }

    // Method to delegate the data update to the DAO layer
    public void UpdateData() throws Exception {
        StudentDao s1 = new StudentDao(); // Create an instance of StudentDao
        s1.UpdateTB(); // Call the DAO method to update data in the table
    }

    // Method to delegate the data deletion to the DAO layer
    public void DeleteData() throws Exception {
        StudentDao s1 = new StudentDao(); // Create an instance of StudentDao
        s1.DeleteTb(); // Call the DAO method to delete data from the table
    }

    // Method to delegate reading data to the DAO layer
    public void ReadData() throws Exception {
        StudentDao s1 = new StudentDao(); // Create an instance of StudentDao
        s1.ReadTb(); // Call the DAO method to read data from the table
    }
}
