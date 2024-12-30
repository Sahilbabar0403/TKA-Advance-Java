package com.homepractice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Employee {

	@Id
	private int emp_id;
	private String emp_name;
	private String Address;

	public Employee() {

	}

	public Employee(int emp_id, String emp_name, String address) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		Address = address;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", Address=" + Address + "]";
	}

}
