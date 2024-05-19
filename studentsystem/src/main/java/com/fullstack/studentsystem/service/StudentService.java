package com.fullstack.studentsystem.service;

import java.util.List;

import com.fullstack.studentsystem.model.StudentModel;

public interface StudentService {
	
	public StudentModel saveStudent(StudentModel student);
	
	public List<StudentModel> getAllStudents();
	
	public StudentModel getById(Integer id);
	
	public StudentModel updateStudent(StudentModel student,Integer id);
	
	public String deleteStudent(Integer id);
	
	
}
