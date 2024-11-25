package com.controller;

import java.util.Scanner;

import com.service.StudentService;

public class StudentCOntroller {
	public static void main(String[] args) throws Exception {
		StudentService s2 = new StudentService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Choose an operation:");
			System.out.println("1 - Create Database");
			System.out.println("2 - Create Table");
			System.out.println("3 - Insert Data");
			System.out.println("4 - UpdateData");
			System.out.println("5 - Delete Data");
			System.out.println("6 - Read Data ");
			System.out.println("Any other number to exit.");

			while(true) {
			int choice = sc.nextInt();
			String dbName = "";
			String tableName = "";
			switch (choice) {
			case 1:
				s2.CreateDb();
				break;
			case 2:
				s2.CreateTb();
				break;
			case 3:
				s2.InsertData();
			case 4:
				s2.UpdateData();
				break;
			case 5:
				s2.DeleteData();
				break;
			case 6:
				s2.ReadData();
				break;
			default:
				System.out.println("Exiting program.");
			}
			}
//    sc.close();
		}
	}
}
