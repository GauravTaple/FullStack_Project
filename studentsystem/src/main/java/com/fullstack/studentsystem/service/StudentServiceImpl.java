package com.fullstack.studentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fullstack.studentsystem.model.StudentModel;
import com.fullstack.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Override
	public StudentModel saveStudent(StudentModel student) {
		return studentRepository.save(student);
	}

	@Override
	public List<StudentModel> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public StudentModel getById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public StudentModel updateStudent(StudentModel student, Integer id) {
        // Check if the student with the given ID exists in the database
        Optional<StudentModel> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            StudentModel existingStudent = existingStudentOptional.get();
            // Update the fields of the existing student with the new values
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());
            // Save the updated student record in the database
            return studentRepository.save(existingStudent);
        } else {
            // If the student with the given ID is not found, return null or throw an exception
            return null;
        }
    }
	
	@Override
	public String deleteStudent(Integer id) {
        // Check if the student with the given ID exists in the database
        Optional<StudentModel> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            // If the student exists, delete it from the database
            studentRepository.deleteById(id);
        } else {
            // If the student with the given ID is not found, you can choose to throw an exception
            throw new RuntimeException("Student not found with ID: " + id);
        }
		return "ID is deleted";
    }

	
	

}
