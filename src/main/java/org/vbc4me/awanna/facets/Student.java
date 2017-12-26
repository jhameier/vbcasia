package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A student is an individual that partakes of an activity produced by the organization.
 */
public class Student extends Person{
	private UUID childId;
	private String childGrade;
	private LocalDate childDOB;
	private Set<String> specialNeeds = new HashSet<>();
	private Club club;
	
	private Photo childPhoto;
	private Photo parentPhoto;
	
	private String parentFirstName;
	private String parentLastName;
	private String address;
	private String city;
	private String state;
	private Zipcode zip;
	private List<PhoneNumber> phoneNumbers;
	private String emailAddress;
	private String emergencyContactName;
	private PhoneNumber emergencyContactPhone;
	private List<Pickup> authPickup = new ArrayList<>();
	
	// Account is automatically created when a student record is created
	private Account account = new Account();
	
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
	 * Returns the id of the {@link Student} this record is associated with.
	 */
	public String childId() {
		return childId.toString();
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
	 * @param club
	 *            this student belongs to
	 */
	public void currentClub(Club club) {
		this.club = club;
	}
	
	/**
	 * Returns the childFirstName
	 */
	public String childFirstName() {
		return firstName();
	}
	
	/**
	 * Returns the childLastName
	 */
	public String childLastName() {
		return lastName();
	}
	
	public String childFullName() {
		return childFirstName() + " " + childLastName();
	}
	
	/**
	 * Returns the exact Age of this student in years as of the current day.
	 */
	public Integer childAge() {
		Period p = Period.between(childDOB, LocalDate.now());
		int age = p.getYears();
		return age;
	}
	
	/**
	 * Returns the exact Age of this student in years from a specific day.
	 */
	public Integer childAge(LocalDate date) {
		Period p = Period.between(childDOB, LocalDate.now());
		int age = p.getYears();
		return age;
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
		StringBuilder sb = new StringBuilder();
		for(String str : specialNeeds) {
			sb.append( str + " : ");
		}
		sb.reverse().replace(0, 3, "");
		return sb.reverse().toString();
	}
	
	/**
	 * Allows input or update of this students special needs.
	 *
	 * @param need
	 *            to add to this students specialNeeds listing.
	 */
	public void addSpecialNeed(String need) {
		specialNeeds.add(need);
	}
	
	public boolean removeSpecialNeed(String need) {
		return specialNeeds.remove(need);
	}
	
	/**
	 * Returns the image of this student
	 */
	public BufferedImage childPhoto() {
		return childPhoto.photo();
	}
	
	/**
	 * Returns the path to the image of this student.
	 */
	public Path childPhotoPath() {
		return childPhoto.photoPath();
	}
	
	/**
	 * Returns the thumbnail image of this student
	 */
	public BufferedImage childThumbnail() {
		return childPhoto.thumbnail();
	}

	/**
	 * Returns the path to this students thumbnail image.
	 * 
	 * <p>This method does not guarantee that the path to the file exists.
	 */
	public Path childThumbnailPath() {
		return childPhoto.thumbnailPath();
	}

	/**
	 * Returns the image of the parent's photo.
	 */
	public BufferedImage parentPhoto() {
		return parentPhoto.photo();
	}
	
	/**
	 * Returns the path to this parents photo.
	 * 
	 * <p>This does not guarantee that the path to the file exists.
	 */
	public Path parentPhotoPath() {
		return parentPhoto.photoPath();
	}
	
	/**
	 * Returns the thumbnail image of this student
	 */
	public BufferedImage parentThumbnail() {
		return parentPhoto.thumbnail();
	}

	/**
	 * Returns the path to this students thumbnail image.
	 * 
	 * <p>This method does not guarantee that the path to the file exists.
	 */
	public Path parentThumbnailPath() {
		return parentPhoto.thumbnailPath();
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
	public Zipcode zip() {
		return zip;
	}
	
	/**
	 * @param zip
	 *            code of the residence for this record
	 */
	public void zip(String zip) {
		this.zip = new Zipcode(zip);
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
		super(builder.childFirstName, builder.childLastName, Person.Type.STUDENT);
		this.club = builder.club;
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
		private Club club;
		private String childFirstName;
		private String childLastName;
		private String childGrade;
		private LocalDate childDOB;
		private Set<String> specialNeeds;
		
		private Photo childPhoto;
		private Photo parentPhoto;
		
		private String parentFirstName;
		private String parentLastName;
		private String address;
		private String city;
		private String state;
		private Zipcode zip;
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
		public Builder currentClub(Club club) {
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
		
		/**
		 * Sets the special needs of this student.
		 * @param specialNeeds
		 * @return
		 */
		public Builder specialNeeds(String specialNeed) {
			if(specialNeeds == null) 
				specialNeeds = new HashSet<>();
			this.specialNeeds.add(specialNeed);
			return this;
		}
		
		/**
		 * Adds a photo to this students profile.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder childPhoto(Photo photo) {
			this.childPhoto = photo;
			return this;
		}
		
		/**
		 * Adds a parents photo to this students profile.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder parentPhoto(Photo photo) {
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
		
		/**
		 * Sets the 5 character zip code associated with this students street address in the form of '12345' only.
		 * 
		 * @return this builder for method chaining
		 * @throws IllegalArgumentException if not supplying 5 numeric characters.
		 */
		public Builder zip(String zip) {
			this.zip = new Zipcode(zip);
			return this;
		}
		
		/**
		 * Sets the 9 character zipcode associated with this students street address in the form of '12345-6789'.
		 * 
		 * @param primary first 5 digits of the 9 character postal code
		 * @param extended last 4 digits of the 9 character postal code
		 * @throws IllegalArgumentException if not supplying 9 numeric characters.
		 */
		public Builder zip(String primary, String extended) {
			this.zip = new Zipcode(primary, extended);
			return this;
		}
		
		/**
		 * Adds a new phone number associated with this student. If the phone
		 * number already exists in the list, this method just returns without adding 
		 * a duplicate number.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder phoneNumber(String type, String number) {
			if (phoneNumbers == null) {
				phoneNumbers = new ArrayList<>();
			}
			PhoneNumber ph = new PhoneNumber(type, number);
			if(!PhoneNumber.contains(phoneNumbers, ph))
				this.phoneNumbers.add(ph);
			return this;
		}
		
		/**
		 * Sets the email address associated with this student
		 * 
		 * @return this builder for method chaining
		 */
		public Builder emailAddress(String emailAddress) {
			Pattern p = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]{3}");
			Matcher m = p.matcher(emailAddress);
			if (!m.matches()) {
				throw new IllegalArgumentException("The email does not match the common pattern of xxxxx@xxx.XXX");
			}
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
		public Builder authPickup(String first, String last, 
															String relationship, BufferedImage photo, BufferedImage thumb) {
			if (authPickup == null) {
				authPickup = new ArrayList<>();
			}
			Pickup pub = Pickup.build().first(first). last(last).relationship(relationship).photo(photo).thumbnail(thumb).done();
			this.authPickup.add(pub);
			return this;
		}
		
		/**
		 * Adds an Authorized {@link Pickup} to associate with this student.
		 * 
		 * @return this builder for method chaining
		 */
		public Builder authPickup(String first, String last, String relationship, String photoPath, String thumbnailPath) {
			Pickup pub = Pickup.build().first(first).last(last).relationship(relationship)
												  .photoPath(photoPath).thumbnailPath(thumbnailPath).done();
			this.authPickup.add(pub);
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
