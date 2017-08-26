package org.vbc4me.awanna.facets;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a yearly set of records associated with an organization's program and
 * contains information such as events (start and end dates + activities), student and staffing information.
 */
public final class Season {
	
	private final UUID id;
	private final String name;
	private Session session;
	private Map<String, Student> students = new HashMap<>();
	private Map<String, Staff> staff = new HashMap<>();
	private boolean finalized;
	
	public Season(String name, Session session) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.session = session;
		this.finalized = false;
	}
	
	/**
	 * Returns whether or not this season is closed.
	 */
	public boolean isFinalized() {
		return finalized;
	}
	
	/**
	 * Closes out this season. This can not be undone (without proper knowledge of the system resources).
	 */
	public void finalize() {
		finalized = true;
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
	 * Returns the {@link Session} associated with this {@code SeasonContainer}.
	 */
	public Session session() {
		return session;
	}
	
	/**
	 * Returns all the {@link Student}s that are associated with this SeasonContainer.
	 */
	public Map<String, Student> students() {
		return students;
	}
	
	/**
	 * Returns a {@link Student} from this {@code SeasonContainer}'s list of
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
	 * Returns all the {@link Staff} associated with this SeasonContainer.
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
	
	/**
	 * Adds an existing set of students to the currently loaded season.
	 */
	public void addStudents(Map<String, Student> students) {
		this.students = students;
	}
	
	/**
	 * Adds an existing set of staff to the currently loaded season.
	 */
	public void addStaff(Map<String, Staff> staff) {
		this.staff = staff;
	}
	
}
