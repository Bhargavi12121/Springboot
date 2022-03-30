package com.wipro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.wipro.controller.StudentController;
import com.wipro.model.Student;
import com.wipro.service.StudentService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {
	
	@Autowired
	MockMvc mockmvc;
	
	@MockBean
	StudentService service;
	
	List<Student> list=new ArrayList<>();
	Student Student1 =new Student(1, "arjun", 5, 3.0, "Male", Arrays.asList("swimming", "dancing"));
	Student Student2 =new Student(2, "Surya", 4, 4.5, "Male", Arrays.asList("aerobics", "gymnastics"));
	Optional<Student> Student3 =Optional.of(new Student(3, "Leela", 2, 4.5, "Female", Arrays.asList("dancing", "singing")));
	
	@Test
	void testAddStudent() throws IOException, Exception {
		when(service.addStudent(Mockito.any(Student.class))).thenReturn(Student1);
		mockmvc.perform(MockMvcRequestBuilders.post("/addstudent")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(Student1)))
				.andExpect(status().is(200));
	}

	@Test
	void testUpdateStudent() throws IOException, Exception {
		when(service.updateStudent(Mockito.any(Student.class), Mockito.anyInt())).thenReturn(Student1);
		mockmvc.perform(MockMvcRequestBuilders.put("/updatestudent/1")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(Student1)))
				.andExpect(jsonPath("$.name", Matchers.is("arjun")));
	}

	@Test
	void testGetStudentByName() throws Exception  {
		when(service.getStudentByName(Mockito.anyInt())).thenReturn(Student3);
		mockmvc.perform(MockMvcRequestBuilders.get("/student/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	

	@Test
	void testGetStudentGpa() throws Exception {
		list.add(Student1);
		list.add(Student2);
		when(service.getStudentByGpa()).thenReturn(list);
		mockmvc.perform(MockMvcRequestBuilders.get("/students")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}

	@Test
	void testDeleteStudent() throws Exception {
		when(service.deleteStudent(Mockito.anyInt())).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.delete("/deletestudent/1"))
			.andExpect(status().is(202))
			.andExpect(content().string("Student deleted"));
	}

}
