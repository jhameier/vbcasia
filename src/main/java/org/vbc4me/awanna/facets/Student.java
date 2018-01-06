package org.vbc4me.awanna.facets;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.vbc4me.awanna.gui.picture.Photo;


/**
 * A student is an individual that partakes of an activity produced by the organization.
 */
public class Student extends Person {

  private String grade;
  private LocalDate dateOfBirth;
  private Set<String> specialNeeds = new HashSet<>();
  private Club club;
  private Guardian guardian;
  private EmergencyContact emergencyContact;
  private List<Pickup> authPickup = new ArrayList<>();

  // Account is automatically created when a student record is created
  private Account account = new Account();

  private Student(Builder builder) {
    super(builder.studentId, builder.firstName, builder.lastName, Person.Type.STUDENT, builder.studentPhoto);
    this.club = builder.club;
    this.grade = builder.grade;
    this.dateOfBirth = builder.dateOfBirth;
    this.specialNeeds = builder.specialNeeds;

    this.guardian = builder.guardian;
    this.authPickup.addAll(builder.authPickup);
    this.emergencyContact = builder.emergencyContact;
  }

  /**
   * Return a builder that allows construction of a Student Record
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Returns this {@link Student}'s account.
   */
  public Account account() {
    return account;
  }

  /**
   * Returns the club that this {@link Student} is associated with.
   */
  public String currentClub() {
    return club.name();
  }

  /**
   * Allows updating this {@link Student}'s assigned club.
   *
   * @param club this student will now belong to
   */
  public void currentClub(Club club) {
    this.club = club;
  }


  /**
   * Returns the exact Age of this student in years as of the current day.
   */
  public Integer age() {
    Period p = Period.between(dateOfBirth, LocalDate.now());
    return p.getYears();
  }

  /**
   * Returns the exact Age of this student in years from a specific day.
   */
  public Integer age(LocalDate date) {
    Period p = Period.between(dateOfBirth, LocalDate.now());
    return p.getYears();
  }

  /**
   * Returns the grade level of this {@link Student}.
   */
  public String grade() {
    return grade;
  }

  /**
   * Update the grade level of this {@link Student}.
   */
  public void grade(String grade) {
    this.grade = grade;
  }

  /**
   * Returns the child date of birth in the form of yyyy/MM/dd
   */
  public LocalDate dateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Update the date of birth of this {@link Student}.
   */
  public void dateOfBirth(LocalDate dob) {
    this.dateOfBirth = dob;
  }

  /**
   * Returns the specialNeeds
   */
  public String specialNeeds() {
    StringBuilder sb = new StringBuilder();
    for (String str : specialNeeds) {
      sb.append(str).append(" : ");
    }
    // remove the last semicolon from the string by reversing, replacing the first 3 characters and
    // then reversing to put back in order.
    sb.reverse().replace(0, 3, "").reverse();
    return sb.toString();
  }

  /**
   * Allows input or update of this students special needs.
   *
   * @param need to add to this students specialNeeds listing.
   */
  public void addSpecialNeed(String need) {
    specialNeeds.add(need);
  }

  /**
   * Returns true only if the special need if found and removed from the current list, false otherwise.
   */
  public boolean removeSpecialNeed(String need) {
    return specialNeeds.remove(need);
  }

  /**
   * returns the {@link Guardian} associated with this {@link Student}.
   */
  public Guardian guardian() {
    return guardian;
  }

  /**
   * Returns the list of people authorized to {@link Pickup pickup} this {@link Student}.
   */
  public List<Pickup> authPickupList() {
    return authPickup;
  }

  /**
   * Returns the {@link EmergencyContact} associated with this {@link Student}.
   */
  public EmergencyContact emergencyContact() {
    return emergencyContact;
  }

  /**
   * Helper to construct the complex student structure.
   */
  public static class Builder {

    private UUID studentId;
    private Club club;
    private String firstName;
    private String lastName;
    private String grade;
    private LocalDate dateOfBirth;
    private Set<String> specialNeeds = new HashSet<>();
    private Photo studentPhoto;

    private Guardian guardian;
    private EmergencyContact emergencyContact;
    private List<Pickup> authPickup = new ArrayList<>();

    /**
     * Sets the first name for this student.
     *
     * @return this builder for method chaining
     */
    public Builder firstName(String first) {
      this.firstName = first;
      return this;
    }

    /**
     * Sets the last name for this student.
     *
     * @return this builder for method chaining
     */
    public Builder lastName(String last) {
      this.lastName = last;
      return this;
    }

    /**
     * Sets the UUID for this student. The id must match the UUID {@link UUID toString()} method of UUID to be valid.
     *
     * @return this builder for method chaining
     */
    public Builder studentId(String id) {
      this.studentId = UUID.fromString(id);
      return this;
    }

    /**
     * Sets the current club of this student.
     *
     * @return this builder for method chaining
     */
    public Builder club(Club club) {
      this.club = club;
      return this;
    }

    /**
     * Sets the grade of this student.
     *
     * @return this builder for method chaining
     */
    public Builder grade(String childGrade) {
      this.grade = childGrade;
      return this;
    }

    /**
     * Sets this students date of birth.
     *
     * @return this builder for method chaining
     */
    public Builder dateOfBirth(LocalDate dob) {
      this.dateOfBirth = dob;
      return this;
    }

    /**
     * Sets the special needs of this student.
     */
    public Builder specialNeeds(String specialNeed) {
      this.specialNeeds.add(specialNeed);
      return this;
    }

    /**
     * Adds a {@link Photo} to this {@link Student}s profile.
     *
     * @return this builder for method chaining
     */
    public Builder studentPhoto(Photo photo) {
      this.studentPhoto = photo;
      return this;
    }

    /**
     * Sets the parents last name associated with this student.
     *
     * @return this builder for method chaining
     */
    public Builder guardian(Guardian guardian) {
      this.guardian = guardian;
      return this;
    }

    /**
     * The {@link EmergencyContact} to associate with this student.
     *
     * @return this builder for method chaining
     */
    public Builder emergencyContact(EmergencyContact contact) {
      this.emergencyContact = contact;
      return this;
    }

    /**
     * Adds an Authorized {@link Pickup} to associate with this student.
     *
     * @return this builder for method chaining
     */
    public Builder authPickup(Pickup pickup) {
      this.authPickup.add(pickup);
      return this;
    }

    /**
     * Builds a new Student Record. The only required items is the students first and last name. All other information
     * is optional at the time of creation.
     */
    public Student create() {
      Objects.requireNonNull(firstName, "A first name is required.");
      Objects.requireNonNull(lastName, "a last name is required");
      Objects.requireNonNull(guardian, "A listed guardian is required.");
      Objects.requireNonNull(emergencyContact, "An emergency contact is required.");

      return new Student(this);
    }
  }

}
