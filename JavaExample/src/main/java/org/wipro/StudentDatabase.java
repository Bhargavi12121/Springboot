package org.wipro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDatabase {

	public static List<Student> getAllStudetns() {

		List<Student> ls = new ArrayList<>();
		ls.add(new Student("arjun", 5, 9.0, "Male", Arrays.asList("swimming", "dancing")));
		ls.add(new Student("Surya", 4, 9.5, "Male", Arrays.asList("aerobics", "gymnastics")));
		ls.add(new Student("Leela", 2, 9.8, "Female", Arrays.asList("dancing", "singing")));

		return ls;

	}

}
