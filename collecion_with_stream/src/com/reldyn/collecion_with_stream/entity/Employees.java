package com.reldyn.collecion_with_stream.entity;

public class Employees {
	int id;
	String name;
	int age;
	String gender;
	String department;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Employees(int id, String name, int age, String gender, String department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + "]";
	}
	

	

}
