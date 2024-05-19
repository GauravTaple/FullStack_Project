package com.fullstack.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.studentsystem.model.StudentModel;
import com.fullstack.studentsystem.service.StudentService;

@RestController	
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public String add(@RequestBody StudentModel student) {
		studentService.saveStudent(student);
		return "New Student is added.";
	}
	
	@GetMapping("/getAll")
	public List<StudentModel> getAll(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<StudentModel> getById(@PathVariable Integer id) {
		StudentModel model = studentService.getById(id);
        if (model != null) {
            return ResponseEntity.ok(model);
        } else {
            return ResponseEntity.notFound().build();
        }	
	}
	
	@PutMapping("/update/{id}")
	 public StudentModel updateStudent(@RequestBody StudentModel student, @PathVariable Integer id) {
	        return studentService.updateStudent(student, id);
	    }
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return studentService.deleteStudent(id);
	}
	
	
}
