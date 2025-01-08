package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private int age;
	private String sdomain;

	public Student() {
	
	}
	public Student(int sid, String sname, int age, String sdomain) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.sdomain = sdomain;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSdomain() {
		return sdomain;
	}
	public void setSdomain(String sdomain) {
		this.sdomain = sdomain;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + ", sdomain=" + sdomain + "]";
	}
	
	
}
