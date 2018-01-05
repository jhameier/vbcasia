package org.vbc4me.awanna.facets;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Represents a yearly set of records associated with an organization's program and contains information such as events
 * (start and end dates + activities), student and staffing information.
 */
public final class Season {

  private final UUID id;
  private final String name;
  private Session session;
  private Map<String, Student> students = new TreeMap<>();
  private Map<String, Staff> staff = new TreeMap<>();
  private boolean finalized;

  private Season(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.session = builder.session;
    this.finalized = builder.finalized;
  }

  public static Builder builder() {
    return new Builder();
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
   * Returns all the {@link Student}s that are associated with this {@code SeasonContainer}.
   */
  public Map<String, Student> students() {
    return students;
  }

  /**
   * Returns a {@link Student} from this {@code SeasonContainer}'s list of {@code Student}s.
   *
   * @param name of the student to retrieve (first last)
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
    students.put(student.lastName(), student);
  }

  /**
   * Adds an existing set of students to the currently loaded season.  This will overwrite the existing set of {@link
   * Student}s if any were added with the {@link #addStudent(Student)} method.
   */
  public void addStudents(Map<String, Student> students) {
    this.students = students;
  }

  /**
   * Adds a {@link Staff} member to this {@code Seasons} list of staff members
   */
  public void addStaff(Staff staff) {
    this.staff.put(staff.lastName(), staff);
  }

  /**
   * Adds an existing set of staff to the currently loaded season.  This will overwrite the existing set of {@code
   * Staff} if any were added with the {@link #addStaff(Staff)} method.
   */
  public void addStaff(Map<String, Staff> staff) {
    this.staff = staff;
  }

  /**
   * Returns all the {@link Staff} associated with this SeasonContainer.
   */
  public Map<String, Staff> staff() {
    return staff;
  }

  /**
   * Builder uitility for help in instantiating an new {@link Season}.
   */
  public static class Builder {

    boolean finalized = false;
    private UUID id;
    private String name;
    private Session session;

    /**
     * The unique identifier for this {@link Season}.  If one is not supplied a random {@link UUID} will be generated.
     * Returns this builder for method chaining.
     */
    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    /**
     * The name to associate with this {@link Season}.  Returns this builder for method chaining.
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * The {@link Session} to associate with this {@code Season}.  Return this builder for method chaining.
     */
    public Builder session(Session session) {
      this.session = session;
      return this;
    }

    /**
     * Expresses if this {@code Season} can be modified within the running application.  By default a newly created
     * {@code Season} is allowed to be modified unliess specified here.  Return this builder for method chaining.
     */
    public Builder finalized(boolean finalized) {
      this.finalized = finalized;
      return this;
    }

    /**
     * Returns a fully qualified {@link Season}.  Any missing elements (name or session) will throw a {@link
     * NullPointerException}.
     */
    public Season build() {
      Objects.requireNonNull(name);
      Objects.requireNonNull(session);
      if (id == null) {
        id = UUID.randomUUID();
      }

      return new Season(this);
    }
  }
}
