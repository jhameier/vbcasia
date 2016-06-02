package org.vbc4me.awanna.account;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * A staff is a individual of the organization that helps to oversee some event.
 */
public class Staff {
	private UUID id;
	private String recordType;
	private String first;
	private String last;
	private String address;
	private String city;
	private String state;
	private String zip;
	private List<PhoneNumber> phoneNumbers;
	private String email;
	private BufferedImage photo;
	private String specialNeeds;
	private String emergencyContactName;
	private PhoneNumber emergencyContactPhone;
	private String assignedClub;
	private String title;
	
	/**
	 * Returns a builder that assures this object is built with all the necessary information.
	 */
	public static Builder build() {
		return new Builder();
	}
	
	/**
	 * Returns the record childId
	 */
	public String id() {
		return id.toString();
	}
	
	public String type() {
		return recordType;
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
		return assignedClub;
	}
	
	/**
	 * Returns the staff members first name
	 */
	public String firstName() {
		return first;
	}
	
	/**
	 * Returns the staff members last name
	 */
	public String lastName() {
		return last;
	}
	
	/**
	 * Allows changing this staff members last name. While this may never be
	 * used there could be an instance where a female staff member gets married
	 * and wants to update their current record.
	 *
	 * @param name to change to.
	 */
	public void changeLastName(String name) {
		this.last = name;
	}
	
	/**
	 * Returns the staff members address of residence
	 */
	public String address() {
		return address;
	}
	
	/**
	 * Allows for input or updating a staff members address of residence.
	 * 
	 * @param address
	 *            to update to
	 */
	public void address(String address) {
		this.address = address;
	}
	
	/**
	 * Returns the staff members city of residence
	 */
	public String city() {
		return city;
	}
	
	/**
	 * Allows for input or update of the staff members city of residence.
	 * 
	 * @param city
	 *            of residence
	 */
	public void city(String city) {
		this.city = city;
	}
	
	/**
	 * Returns the staff members state of residence
	 */
	public String state() {
		return state;
	}
	
	/**
	 * Allows for input or update of the staff members state of residence.
	 * 
	 * @param state
	 *            of residence
	 */
	public void state(String state) {
		this.state = state;
	}
	
	/**
	 * Returns the staff members zip
	 */
	public String zip() {
		return zip;
	}
	
	/**
	 * Returns the staff members list of phone numbers
	 */
	public List<PhoneNumber> phoneNumbers() {
		return phoneNumbers;
	}
	
	/**
	 * Adds a phone number to this staff members list of phone numbers. The
	 * number should be in its raw form without formatting characters. If any
	 * formatting characters are present or the input is not 10 characters in
	 * length the creation method will throw an Illegal Argument exception.
	 *
	 * @param type
	 *            of phone number such as home or cell etc.
	 * @param number
	 *            to add
	 */
	public void addUnformattedPhoneNumber(String type, String number) {
		PhoneNumber ph = new PhoneNumber(type, number);
		this.phoneNumbers.add(ph);
	}
	
	/**
	 * Removes a phone number from this staff memeber's list of numbers. The
	 * number can be formatted xxx-xxx-xxxx or (xxx) xxx-xxxx or unformatted
	 * xxxxxxxxxx and this method call will throw and Illegal Argument Exception
	 * if the number is not found in the list of known phone numbers.
	 *
	 * @param number
	 *            to be removed from this staff memebers list of phone numbers
	 */
	public void removePhoneNumber(String number) {
		number = number.replace("(", "");
		number = number.replace(")", "");
		number = number.replace("-", "");
		number = number.replace(" ", "");
		
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
	
	public String emergencyContactName() {
		return emergencyContactName;
	}
	
	public void emergencyContactName(String name) {
		this.emergencyContactName = name;
	}
	
	/**
	 * Returns the emergency contact number assigned to this members record.
	 */
	public PhoneNumber emergencyContactNumber() {
		return emergencyContactPhone;
	}
	
	/**
	 * Assign an emergency contact phone number
	 */
	public void emergencyContactName(PhoneNumber number) {
		this.emergencyContactPhone = number;
	}
	
	/**
	 * Returns the staff members special needs
	 */
	public String specialNeeds() {
		return specialNeeds;
	}
	
	/**
	 * Adds a special need to this staff members special need listing.
	 *
	 * @param need
	 *            of the member
	 */
	public void addSpecialNeed(String need) {
		specialNeeds += ", " + need;
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
	 * @param email
	 *            address to add
	 */
	public void email(String email) {
		this.email = email;
	}
	
	/**
	 * Returns the path to this staff members photo
	 */
	public BufferedImage photo() {
		return photo;
	}
	
	/**
	 * Adds a path to a photo to this staff members record.
	 *
	 * @param photo path to add
	 */
	public void photo(BufferedImage photo) {
		this.photo = photo;
	}
	
	private Staff(Builder builder) {
		this.recordType = "staff";
		this.title = builder.title;
		this.assignedClub = builder.club;
		this.first = builder.firstName;
		this.last = builder.lastName;
		this.address = builder.address;
		this.city = builder.city;
		this.state = builder.state;
		this.zip = builder.zip;
		this.phoneNumbers = builder.phoneNumbers;
		this.specialNeeds = builder.specialNeeds;
		this.email = builder.email;
		this.photo = builder.photo;
		this.emergencyContactName = builder.emerContactName;
		this.emergencyContactPhone = builder.emerContactNumber;
		this.id = UUID.randomUUID();
	}
	
	public static class Builder {
		
		private String title;
		private String club;
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String zip;
		private List<PhoneNumber> phoneNumbers = new ArrayList<>();
		private String specialNeeds;
		private String email;
		private BufferedImage photo;
		private String emerContactName;
		private PhoneNumber emerContactNumber;
		
		private Builder() {
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
		
		public Builder club(String club) {
			this.club = club;
			return this;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder state(String state) {
			this.state = state;
			return this;
		}
		
		public Builder zip(String zip) {
			this.zip = zip;
			return this;
		}
		
		public Builder phoneNumber(String type, String number) {
			PhoneNumber ph = new PhoneNumber(type, number);
			this.phoneNumbers.add(ph);
			return this;
		}
		
		public Builder specialNeeds(String specialNeeds) {
			this.specialNeeds = specialNeeds;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder photo(BufferedImage photo) {
			this.photo = photo;
			return this;
		}
		
		public Builder emergencyContactName(String name) {
			this.emerContactName = name;
			return this;
		}
		
		public Builder emergencyContactNumber(String type, String number) {
			this.emerContactNumber = new PhoneNumber(type, number);
			return this;
		}
		
		public Staff done() {
			Objects.requireNonNull(firstName, "First name cannot be null");
			Objects.requireNonNull(lastName, "Last name cannot be null");
			return new Staff(this);
		}
	}
	
}
