package com.wipro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wipro.model.Student;
import com.wipro.repository.StudentRepository;
import com.wipro.serviceimpl.StudentServiceimpl;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	
	@Mock
	private StudentRepository repository;
	
	@InjectMocks
	private StudentServiceimpl service;

	private Student Student1;
	private Student Student2;
	private Optional<Student> Student3;
	private List<Student> list;

	@BeforeEach
	public void setUp() throws Exception {
		list=new ArrayList<>();
		Student1 =new Student(1, "arjun", 5, 3.0, "Male", Arrays.asList("swimming", "dancing"));
		Student2 =new Student(2, "Surya", 4, 3.5, "Male", Arrays.asList("aerobics", "gymnastics"));
		Student3 =Optional.of(new Student(3, "Leela", 2, 4.5, "Female", Arrays.asList("dancing", "singing")));
		list.add(Student1);
		list.add(Student2);
	
	}

	@AfterEach
	void tearDown() throws Exception {
		Student1=Student2=null;
		Student3=null;
		list=null;
	}
	
	@Test
	void testAddStudent() {
		when(repository.save(Mockito.any(Student.class))).thenReturn(Student1);
		Student stu=service.addStudent(Student1);
		assertEquals("arjun", stu.getName());
	}

	@Test
	void testUpdateStudent() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Student3);
		service.updateStudent(Student1, Mockito.anyInt());
		verify(repository,times(1)).save(Mockito.any(Student.class));
	}

	@Test
	void testGetStudentById() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Student3);
		Optional<Student> stu=service.getStudentByName(Mockito.anyInt());
		assertEquals(3, stu.get().getId());		
	}

	@Test
	void testGetStudentByGpa() {
		when(repository.findAll()).thenReturn(list);
		List<Student> ls=service.getStudentByGpa();
		assertEquals(0, ls.size());
	}

	@Test
	void testDeleteStudent() {
		when(repository.findById(Mockito.anyInt())).thenReturn(Student3);
		service.deleteStudent(Mockito.anyInt());
		verify(repository, times(1)).deleteById(Mockito.anyInt());
	}



}
