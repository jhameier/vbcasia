package org.vbc4me.awanna.account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a yearly set of activities associated with an organization's program and
 * contains information such as actions (start and end dates + activities), student and staffing information
 */
public final class Season {
	
	private final UUID id;
	private final String name;
	private Session session;
	private Map<String, Student> students = new HashMap<>();
	private Map<String, Staff> staff = new HashMap<>();
	
	public Season(String name, Session session, Map<String, Student> students, Map<String, Staff> staff) {
		this.name = name;
		this.session = session;
		this.students = students;
		this.staff = staff;
		this.id = UUID.randomUUID();
	}
	
	/**
	 * Return the id of this {@link Season}.
	 */
	public String id() {
		return id.toString();
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
	public Map<String, Student> students() {
		return students;
	}
	
	/**
	 * Returns a {@link Student} from this {@code Season}'s list of
	 * {@code Student}s.
	 *
	 * @param name
	 *            of the student to retrieve (first last)
	 */
	public Student getStudentByName(String name) {
		if (students.containsKey(name)) {
			return students.get(name);
		}
		return null;
	}
	
	/**
	 * Adds a single {@link Student} to this Seasons list of students.
	 */
	public void addStudent(Student student) {
		students.put(student.childLastName(), student);
	}
	
	/**
	 * Returns all the {@link Staff} associated with this Season.
	 */
	public Map<String, Staff> staff() {
		return staff;
	}
	
	/**
	 * Adds a {@link Staff} member to this {@code Seasons} list of staff members
	 */
	public void addStaff(Staff staff) {
		this.staff.put(staff.lastName(), staff);
	}
	
}
