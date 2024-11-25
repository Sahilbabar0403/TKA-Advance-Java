package com.service;

import com.dao.StudentDao;

public class StudentService {

	public void CreateDb() throws Exception {
		StudentDao s1 = new StudentDao();
		s1.CreateDb();
	}
	public void CreateTb() throws Exception {
		StudentDao s1 = new StudentDao();
		s1.CreateTB();
		
	}
	public void InsertData() throws Exception {
		StudentDao s1 = new StudentDao();
		s1.InsertTB();
	}
	public void UpdateData() throws Exception {
		StudentDao s1 = new StudentDao();
		s1.UpdateTB();
	}
	
	
	public void DeleteData() throws Exception {
		StudentDao s1 = new StudentDao();
		s1.DeleteTb();
	}
	public void ReadData() throws Exception {
		StudentDao s1 = new StudentDao();
		s1.ReadTb();
	}
}
