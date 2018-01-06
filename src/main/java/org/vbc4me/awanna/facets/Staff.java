package org.vbc4me.awanna.facets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.vbc4me.awanna.gui.picture.Photo;

/**
 * A staff is a individual of the organization that helps to oversee some event.
 */
public class Staff extends Person {

  private Address address;
  private List<PhoneNumber> phoneNumbers = new ArrayList<>();
  private String email;
  private Photo photo;
  private Set<String> specialNeeds = new HashSet<>();
  private EmergencyContact emergencyContact;
  private Club assignedClub;
  private String title;

  /**
   * Constructs a new {@link Staff} object.
   */
  private Staff(Builder builder) {
    super(builder.id, builder.firstName, builder.lastName, Person.Type.STAFF, builder.photo);
    this.title = builder.title;
    this.assignedClub = builder.club;
    this.address = builder.address;
    this.phoneNumbers.addAll(builder.phoneNumbers);
    this.specialNeeds.addAll(builder.specialNeeds);
    this.email = builder.email;
    this.emergencyContact = builder.emergencyContact;
    this.photo = builder.photo;
  }

  /**
   * Returns a builder that assures this object is built with all the necessary information.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Returns the record studentId
   */
  public String staffId() {
    return id().toString();
  }

  /**
   * Return the {@link Address} for this {@link Staff} member.
   */
  public Address address() {
    return address;
  }

  public void updateAddress(Address address) {
    this.address = address;
  }

  /**
   * Sets the title of this {@link Staff} member.
   */
  public void title(String title) {
    this.title = title;
  }

  /**
   * Returns the staff members title
   */
  public String title() {
    return title;
  }

  /**
   * Returns the staff members currently assigned club (may be empty)
   */
  public String assignedClub() {
    return assignedClub.getName();
  }

  /**
   * Returns the staff members list of phone numbers
   */
  public List<PhoneNumber> phoneNumbers() {
    return phoneNumbers;
  }

  /**
   * Adds a phone number to this staff members list of phone numbers. The number should be in its raw form without
   * formatting characters. If any formatting characters are present or the input is not 10 characters in length the
   * creation method will throw an Illegal Argument exception.
   */
  public void addUnformattedPhoneNumber(PhoneNumber number) {
    this.phoneNumbers.add(Objects.requireNonNull(number));
  }

  /**
   * Return the {@link EmergencyContact} associated with this {@link Staff} memeber.
   */
  public EmergencyContact emergencyContact() {
    return emergencyContact;
  }

  /**
   * Returns the staff members special needs
   */
  public String specialNeeds() {
    StringBuilder sb = new StringBuilder();
    for (String str : specialNeeds) {
      sb.append(str).append(" : ");
    }
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
   * Returns this staff member's email address
   */
  public String email() {
    return email;
  }

  /**
   * Adds an email address to this staff members record.
   *
   * @param email address to add
   */
  public void email(String email) {
    this.email = email;
  }

  /**
   * Returns the image of this staff member.
   */
  public Photo photo() {
    return photo;
  }

  /**
   * Adds a {@link Photo} to this staff members record.
   */
  public void photo(Photo photo) {
    this.photo = photo;
  }


  public static class Builder {

    private UUID id;
    private String firstName;
    private String lastName;
    private String title;
    private Club club;

    private Address address;

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private Set<String> specialNeeds = new HashSet<>();
    private String email;
    private Photo photo;

    private EmergencyContact emergencyContact;

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder firstName(String first) {
      this.firstName = first;
      return this;
    }

    public Builder lastName(String last) {
      this.lastName = last;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder club(Club club) {
      this.club = club;
      return this;
    }

    public Builder address(Address address) {
      this.address = address;
      return this;
    }

    public Builder phoneNumber(PhoneNumber number) {
      this.phoneNumbers.add(number);
      return this;
    }

    public Builder specialNeeds(String specialNeeds) {
      this.specialNeeds.add(specialNeeds);
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder photo(Photo photo) {
      this.photo = photo;
      return this;
    }

    public Builder emergencyContact(EmergencyContact contact) {
      this.emergencyContact = contact;
      return this;
    }

    public Staff create() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      Objects.requireNonNull(firstName);
      Objects.requireNonNull(lastName);

      return new Staff(this);
    }
  }

}
