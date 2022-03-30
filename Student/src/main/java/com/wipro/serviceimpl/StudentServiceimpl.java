package com.wipro.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.Student;
import com.wipro.repository.StudentRepository;
import com.wipro.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Student addStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student updateStudent(Student student, int id) {
		Optional<Student> stu=repository.findById(id);
		if(stu.isPresent()) {
			stu.get().setName(student.getName());
			stu.get().setGpa(student.getGpa());
			stu.get().setGender(student.getGender());
			stu.get().setGradeLevel(student.getGradeLevel());
			stu.get().setActivities(student.getActivities());
			Student updatestudent=repository.save(stu.get());
			return updatestudent;
		}
		else {
			repository.save(student);
		}
		return student;
	}

	@Override
	public Optional<Student> getStudentByName(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Student> getStudentByGpa() {
		List<Student> stulist=repository.findAll();
		return stulist.stream().filter(e->e.getGpa()>3.5).collect(Collectors.toList());
	}

	@Override
	public Boolean deleteStudent(int id) {
		Optional<Student> stu=repository.findById(id);
		if(stu.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		else
			return false;
	}
}
