package com.reldyn.collecion_with_stream.entity;

public class EmployeeEntity {
	
	int id;
	String name;
	String deptName;
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
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", deptName=" + deptName + "]";
	}

	public EmployeeEntity(int id, String name, String deptName) {
		super();
		this.id = id;
		this.name = name;
		this.deptName = deptName;
	}
	
	
	

}
