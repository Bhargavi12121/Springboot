package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.model.Student;

@Service
public interface StudentService {
	
	public Student addStudent(Student student);

	public Student updateStudent(Student student, int id);

	public Optional<Student> getStudentByName(int id);

	public List<Student> getStudentByGpa();

	public Boolean deleteStudent(int id);

	

}
