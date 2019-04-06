package kabutz.heinz.datastructures.sorting;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Student s) {
//		int result = Integer.compare(id, s.id);
//		if (result != 0) return -result;
//		return name.compareTo(s.name);
		return NATURAL_COMPARATOR.compare(this, s);
	}
	
	@Override
	public String toString() {
		return name + " : " + id;
	}
	
	public static final Comparator<Student> NATURAL_COMPARATOR = 
			Comparator.comparingInt(Student::getId).reversed()
				.thenComparing(Student::getName);
}
