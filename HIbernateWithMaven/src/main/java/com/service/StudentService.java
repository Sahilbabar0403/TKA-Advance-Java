package com.service;

import com.dao.StudentDAO;

public class StudentService {

	StudentDAO sd =new StudentDAO();
	public void InsertData() {
	sd.InsertData();
	}
	
	public void UpdateData() {
		sd.UpdateData();
		
	}
	public void DeleteData()
	{
		sd.Deletedata();
	}
	
	public void FetchAllData() {
		sd.FetchAlldata();
	}

	public void FetchParticularData() {
		
		sd.FetchParticularData();
	}
	
	
}
