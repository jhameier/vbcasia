package org.vbc4me.awanna.account;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class Student {
	private UUID childId;
	private String recordType;
	private String childFirstName;
	private String childLastName;
	private String childGrade;
	private LocalDate childDOB;
	private String specialNeeds;
	private String club;
	
	private BufferedImage childPhoto;
	private BufferedImage parentPhoto;
	
	private String parentFirstName;
	private String parentLastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private List<PhoneNumber> phoneNumbers;
	private String emailAddress;
	private String emergencyContactName;
	private PhoneNumber emergencyContactPhone;
	private List<Pickup> authPickup;
	
	// Account is automatically created when a student record is created
	private Account account = new Account();
	
	/**
	 * Return a builder that allows construction of a Student Record
	 */
	public static Builder build() {
		return new Builder();
	}
	
	/**
	 * Return the type of record this represents
	 */
	public String type() {
		return recordType;
	}
	
	/**
	 * Returns this {@link Student}'s account.
	 */
	public Account account() {
		return account;
	}
	
	/**
	 * Returns the id of the {@link Student} this record is associated with.
	 */
	public String childId() {
		return childId.toString();
	}
	
	/**
	 * Returns the club that this {@link Student} is associated with.
	 */
	public String currentClub() {
		return club;
	}
	
	/**
	 * Allows updating this {@link Student}'s assigned club.
	 *
	 * @param club
	 *            this student belongs to
	 */
	public void currentClub(String club) {
		this.club = club;
	}
	
	/**
	 * Returns the childFirstName
	 */
	public String childFirstName() {
		return childFirstName;
	}
	
	/**
	 * Returns the childLastName
	 */
	public String childLastName() {
		return childLastName;
	}
	
	public String childFullName() {
		return childFirstName() + " " + childLastName();
	}
	
	/**
	 * Returns the exact Age of this student in years as of the current day.
	 */
	public Integer childAge() {
		return Period.between(childDOB, LocalDate.now()).getYears();
	}
	
	/**
	 * Returns the exact Age of this student in years from a specific day.
	 */
	public Integer childAge(LocalDate date) {
		return Period.between(childDOB, date).getYears();
	}
	
	/**
	 * Returns the childGrade
	 */
	public String childGrade() {
		return childGrade;
	}
	
	/**
	 * Input or update of this students grade.
	 */
	public void childGrade(String grade) {
		this.childGrade = grade;
	}
	
	/**
	 * Returns the child date of birth in the form of yyyy/MM/dd
	 */
	public LocalDate childDOB() {
		return childDOB;
	}
	
	/**
	 * Allows input or update of this students date of birth.
	 *
	 * @param dob to set to
	 */
	public void childDOB(LocalDate dob) {
		this.childDOB = dob;
	}
	
	/**
	 * Returns the specialNeeds
	 */
	public String specialNeeds() {
		return specialNeeds;
	}
	
	/**
	 * Allows input or update of this students special needs.
	 *
	 * @param need
	 *            to add to this students specialNeeds listing.
	 */
	public void addSpecialNeed(String need) {
		this.specialNeeds = this.specialNeeds + ", " + need;
	}
	
	/**
	 * Returns the image of child's photo
	 */
	public BufferedImage childPhoto() {
		return childPhoto;
	}
	
	/**
	 * @param photo of child to store
	 */
	public void childPhoto(BufferedImage image) {
		this.childPhoto = image;
	}
	
	/**
	 * Returns the image to parent's photo file
	 */
	public BufferedImage parentPhoto() {
		return parentPhoto;
	}
	
	/**
	 * @param image image of parent to store
	 */
	public void parentPhoto(BufferedImage image) {
		this.parentPhoto = image;
	}
	
	/**
	 * Returns the parentFirstName
	 */
	public String parentFirstName() {
		return parentFirstName;
	}
	
	/**
	 * Allows the first name of the parent to be updated
	 *
	 * @param first
	 *            name of the parent to update record with
	 */
	public void parentFirstName(String first) {
		this.parentFirstName = first;
	}
	
	/**
	 * Returns the parentLastName
	 */
	public String parentLastName() {
		return parentLastName;
	}
	
	/**
	 * Allows the last name of the parent to be updated
	 *
	 * @param last
	 *            name of the parent to update record with
	 */
	public void parentLastName(String last) {
		this.parentLastName = last;
	}
	
	/**
	 * Returns the address of residence
	 */
	public String address() {
		return address;
	}
	
	/**
	 * @param address
	 *            of residence to update
	 */
	public void address(String address) {
		this.address = address;
	}
	
	/**
	 * Returns the city of residence for this record
	 */
	public String city() {
		return city;
	}
	
	/**
	 * @param city
	 *            of residence for this record
	 */
	public void city(String city) {
		this.city = city;
	}
	
	/**
	 * Returns the state of residence for this record
	 */
	public String state() {
		return state;
	}
	
	/**
	 * @param state
	 *            of residence for this record
	 */
	public void state(String state) {
		this.state = state;
	}
	
	/**
	 * Returns the zip code
	 */
	public String zip() {
		return zip;
	}
	
	/**
	 * @param zip
	 *            code of the residence for this record
	 */
	public void zip(String zip) {
		if (zip.length() < 5) {
			throw new IllegalArgumentException("A zip code must have at least 5 characters");
		}
		
		if (zip.contains("-") && zip.charAt(5) ==  '-' && (zip.length() < 10 || zip.length() > 10)) {
			throw new IllegalArgumentException("An extended zip code must have exactly 9 characters with a dash ('-') "
					+ "separating the first 5 characters from the last 4 characters");
		}
		
		this.zip = zip;
	}
	
	/**
	 * Returns the list of phone numbers
	 */
	public List<PhoneNumber> phoneNumbers() {
		return phoneNumbers;
	}
	
	/**
	 * Adds a phone number to this students list of phone numbers. The number
	 * should be in its raw form without formatting characters. If any
	 * formatting characters are present or the input is not 10 characters in
	 * length the creation method will throw an Illegal Argument exception.
	 *
	 * @param type
	 *            of phone number such as home or cell etc.
	 * @param number
	 *            to add
	 */
	public void addPhoneNumber(String type, String number) {
		PhoneNumber ph = new PhoneNumber(type, number);
		this.phoneNumbers.add(ph);
	}
	
	/**
	 * Removes a phone number from this student's list of numbers. The
	 * number can be formatted xxx-xxx-xxxx or (xxx) xxx-xxxx or unformatted
	 * xxxxxxxxxx and this method call will throw an Illegal Argument Exception
	 * if the number is not found in the list of known phone numbers.
	 *
	 * @param number
	 *            to be removed from this staff members list of phone numbers
	 */
	public void removePhoneNumber(String number) {
		if (number.contains("(")) {
			number = number.replace("(", "");
		}
		
		if (number.contains(")")) {
			number = number.replace(")", "");
		}
		
		if (number.contains("-")) {
			number = number.replace("-", "");
		}
		
		if (number.contains(" ")) {
			number = number.replace(" ", "");
		}
		
		PhoneNumber pnumber = null;
		for (PhoneNumber ph : this.phoneNumbers) {
			if (ph.number(false).equals(number)) {
				pnumber = ph;
				break;
			}
		}
		if (pnumber == null) {
			throw new IllegalArgumentException("Phone number not found in list");
		}
		this.phoneNumbers.remove(pnumber);
	}
	
	/**
	 * Returns home email address
	 */
	public String email() {
		return emailAddress;
	}
	
	/**
	 * Returns emergency contact's name
	 */
	public String emergencyContactName() {
		return emergencyContactName;
	}
	
	/**
	 * Returns emergency contact's phone number
	 */
	public PhoneNumber emergencyContactPhone() {
		return emergencyContactPhone;
	}
	
	/**
	 * Returns the authPickup
	 */
	public List<Pickup> authPickupList() {
		return authPickup;
	}
	
	private Student(Builder builder) {
		this.recordType = "student";
		this.club = builder.club;
		this.childFirstName = builder.childFirstName;
		this.childLastName = builder.childLastName;
		this.childGrade = builder.childGrade;
		this.childDOB = builder.childDOB;
		this.specialNeeds = builder.specialNeeds;
		this.childPhoto = builder.childPhoto;
		this.parentPhoto = builder.parentPhoto;
		this.parentFirstName = builder.parentFirstName;
		this.parentLastName = builder.parentLastName;
		this.address = builder.address;
		this.city = builder.city;
		this.state = builder.state;
		this.zip = builder.zip;
		this.phoneNumbers = builder.phoneNumbers;
		this.emailAddress = builder.emailAddress;
		this.emergencyContactName = builder.emergencyContactName;
		this.emergencyContactPhone = builder.emergencyContactPhone;
		this.authPickup = builder.authPickup;
		
		if (childId == null) {
			this.childId = UUID.randomUUID();
		} else {
			this.childId = builder.childId;
		}
	}
	
	/**
	 * Helper to construct the complex student structure.
	 */
	public static class Builder {
		private UUID childId;
		private String club;
		private String childFirstName;
		private String childLastName;
		private String childGrade;
		private LocalDate childDOB;
		private String specialNeeds;
		private BufferedImage childPhoto;
		private BufferedImage parentPhoto;
		private String parentFirstName;
		private String parentLastName;
		private String address;
		private String city;
		private String state;
		private String zip;
		private List<PhoneNumber> phoneNumbers;
		private String emailAddress;
		private String emergencyContactName;
		private PhoneNumber emergencyContactPhone;
		private List<Pickup> authPickup;
		
		private Builder() {
		}
		
		/**
		 * Sets the first name for this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder firstName(String first) {
			this.childFirstName = first;
			return this;
		}
		
		/**
		 * Sets the last name for this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder lastName(String last) {
			this.childLastName = last;
			return this;
		}
		
		/**
		 * Sets the UUID for this student. The id must match the UUID {@link UUID toString()} method of 
		 * UUID to be valid.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder childId(String id) {
			this.childId = UUID.fromString(id);
			return this;
		}
		
		/**
		 * Generates a new random UUID to assign to this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder childId() {
			this.childId = UUID.randomUUID();
			return this;
		}
		
		/**
		 *  Sets the current club of this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder currentClub(String club) {
			this.club = club;
			return this;
		}
		
		/**
		 * Sets the grade of this student.
		 *
		 * @return this builder for method chaining
		 */
		public Builder childGrade(String childGrade) {
			this.childGrade = childGrade;
			return this;
		}
		
		/**
		 * Sets this students date of birth.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder childDOB(LocalDate childDOB) {
			this.childDOB = childDOB;
			return this;
		}
		
		// FIXME This should be a list so that multiple items can be added as separate objects.
		/**
		 * Sets the special needs of this student.
		 * @param specialNeeds
		 * @return
		 */
		public Builder specialNeeds(String specialNeeds) {
			this.specialNeeds = specialNeeds;
			return this;
		}
		
		/**
		 * Adds a photo to this students profile.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder childPhoto(BufferedImage photo) {
			this.childPhoto = photo;
			return this;
		}
		
		/**
		 * Adds a photo to this students profile.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder parentPhoto(BufferedImage photo) {
			this.parentPhoto = photo;
			return this;
		}
		

		/**
		 * Sets the parents first name associated with this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder parentFirstName(String parentFirstName) {
			this.parentFirstName = parentFirstName;
			return this;
		}
		
		/**
		 * Sets the parents last name associated with this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder parentLastName(String parentLastName) {
			this.parentLastName = parentLastName;
			return this;
		}
		
		/**
		 * Sets the street address of this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		/**
		 * Sets the city associated with the this students street address.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		/**
		 * Sets the state associated with this students street address.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder state(String state) {
			this.state = state;
			return this;
		}
		
		// FIXME this should check for proper formatting of the zip code for both 5 and 9 digit zip codes
		/**
		 * Sets the zip code associated with this students street address
		 * 
		 * @return this builder for method chaining
		 */
		public Builder zip(String zip) {
			this.zip = zip;
			return this;
		}
		
		// FIXME this should check if the number exists and not add duplicate numbers
		/**
		 * Adds a new phone number associated with this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder phoneNumber(String type, String number) {
			if (phoneNumbers == null) {
				phoneNumbers = new ArrayList<>();
			}
			PhoneNumber ph = new PhoneNumber(type, number);
			this.phoneNumbers.add(ph);
			return this;
		}
		
		// FIXME this should check for correct formating of the email address
		/**
		 * Sets the email address associated with this student
		 * 
		 * @return this builder for method chaining
		 */
		public Builder emailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}
		
		/**
		 * Adds an emergency contact name to associate with this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder emergencyContactName(String name) {
			this.emergencyContactName = name;
			return this;
		}
		
		/**
		 * Adds an emergency phone number to associate with this students emergency contact name.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder emergencyContactPhone(PhoneNumber phone) {
			this.emergencyContactPhone = phone;
			return this;
		}
		
		/**
		 * Adds an Authorized {@link Pickup} to associate with this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder authPickup(String first, String last, String relationship, BufferedImage photo) {
			if (authPickup == null) {
				authPickup = new ArrayList<>();
			}
			Pickup.Builder pub = new Pickup.Builder(first, last).relationship(relationship).photo(photo);
			this.authPickup.add(pub.done());
			return this;
		}
		
		/**
		 * Builds a new Student Record. The only required items is the students first and last name. 
		 * All other information is optional at the time of creation.
		 */
		public Student done() {
			Objects.requireNonNull(childFirstName, "First name is required");
			Objects.requireNonNull(childLastName, "Last name is required");
			return new Student(this);
		}
	}
	
}
