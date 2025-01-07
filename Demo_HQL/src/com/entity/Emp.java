package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String name;
	private String Domain;
	private int Salary;
	
	
	
	public int getEmpid() {
		return empid;
	}
	
	
	public Emp() {
		
	}


	public Emp(int empid, String name, String domain, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		Domain = domain;
		Salary = salary;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}


	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", name=" + name + ", Domain=" + Domain + ", Salary=" + Salary + "]";
	}
	
	
	
}
