package org.wipro;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaExample {

	public static void main(String[] args) {
		
		Supplier<Stream<Student>> su=() -> StudentDatabase.getAllStudetns().stream();
		su.get().forEach(i->System.out.println("Student details "+i));
	
		List<Student> list = su.get().filter(e->e.getGradeLevel()>3).collect(Collectors.toList());
		System.out.println("All the students whose gradeLevel > 3 "+list);

		Map<String, Student> map =su.get().filter(e->e.getGpa()>9.5).collect(Collectors.toMap(e->e.getName(), e->e));
		System.out.println("All the students whose gpa > 9.5 "+map);

	}

}
