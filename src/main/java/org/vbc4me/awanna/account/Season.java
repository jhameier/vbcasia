package org.vbc4me.awanna.account;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a yearly set of activities associated with the Awanna program and
 * contains information such as session (start and end dates + activities), student and staffing information
 */
public final class Season {
	
	private final String name;
	private static Session session;
	private static Map<String, Student> students = new HashMap<>();
	private static Map<String, Staff> staff = new HashMap<>();
	
	public Season(String name, Session session, Map<String, Student> students, Map<String, Staff> staff) {
		this.name = name;
		Season.session = session;
		Season.students = students;
		Season.staff = staff;
	}
	
	/**
	 * Returns the name that identifies this {@link Season}.
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Returns the {@link Session} associated with this {@code Season}.
	 */
	public Session session() {
		return session;
	}
	
	/**
	 * Returns all the {@link Student}s that are associated with this Season.
	 */
	public static Map<String, Student> students() {
		return students;
	}
	
	/**
	 * Returns a {@link Student} from this {@code Season}'s list of
	 * {@code Student}s.
	 *
	 * @param name
	 *            of the student to retrieve (first last)
	 */
	public static Student getStudentByName(String name) {
		if (students.containsKey(name)) {
			return students.get(name);
		}
		return null;
	}
	
	/**
	 * Adds a single {@link Student} to this Seasons list of students.
	 */
	public static void addStudent(Student student) {
		students.put(student.childLastName(), student);
	}
	
	/**
	 * Returns all the {@link Staff} associated with this Season.
	 */
	public static Map<String, Staff> staff() {
		return staff;
	}
	
	/**
	 * Adds a {@link Staff} member to this {@code Seasons} list of staff members
	 */
	public static void addStaff(Staff staff) {
		Season.staff.put(staff.lastName(), staff);
	}
	
}
