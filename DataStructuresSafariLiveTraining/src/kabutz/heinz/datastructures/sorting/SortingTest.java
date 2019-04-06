package kabutz.heinz.datastructures.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Student> students = new ArrayList<>();
		Collections.addAll(students, 
			new Student("Bhavya",126000),
			new Student("Akhil",125849),
			new Student("Raj",134343)
			);
		// java 8 way of doing same
		List<Student> students2 = Stream.of(
			new Student("Akhil",126000),
			new Student("Bhavya",125849),
			new Student("Raj",134343)
			).collect(Collectors.toList());
	
//		Collections.sort(students, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				int result = Integer.compare(o1.getId(), o2.getId());
//				if (result != 0) return -result;
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		
		//java 8 syntax
//		Collections.sort(students2, (s1,s2) -> {
//				int result = Integer.compare(s1.getId(), s2.getId());
//				if (result != 0) return result;
//				return s1.getName().compareTo(s2.getName());
//			}
//		);
		
//		System.out.println(students2);
		
		// enen better syntax
//		Collections.sort(students, Comparator.comparingInt(Student::getId)
//				.reversed().thenComparing(Student::getName));
		
//		now put this natural comparator in Student class itself
		Collections.sort(students);
		System.out.println(students);
	}
}

