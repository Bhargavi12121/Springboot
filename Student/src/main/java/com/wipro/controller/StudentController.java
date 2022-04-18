package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.Student;
import com.wipro.service.StudentService;
/**
 * 
 * @author BH20293715
 *
 */
@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student s=service.addStudent(student);
		return ResponseEntity.ok(s);
	}
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
		Student s=service.updateStudent(student, id);
		return ResponseEntity.ok(s);
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student>  getStudentById(@PathVariable int id){
		Optional<Student> stulist=service.getStudentByName(id);
		if(stulist.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(stulist.get());
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudentGpa(){
		List<Student> stulist=service.getStudentByGpa();
		if(stulist.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(stulist);
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		Boolean res=service.deleteStudent(id);
		if(res) {
			return ResponseEntity.accepted().body("Student deleted");
		}
		return ResponseEntity.noContent().build();
	}
	
	

}
