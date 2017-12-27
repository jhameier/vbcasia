package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * A staff is a individual of the organization that helps to oversee some event.
 */
public class Staff extends Person{
    private final Address address;
	private List<PhoneNumber> phoneNumbers;
	private String email;
	private BufferedImage photo;
	private BufferedImage thumbnail;
	private String specialNeeds = "";
	private EmergencyContact emergencyContact;
	private Club assignedClub;
	private String title;
	
	/**
	 * Returns a builder that assures this object is built with all the necessary information.
	 */
	public static Builder builder() {
		return new Builder();
	}

    /**
     * Constructs a new {@link Staff} object.
     */
    private Staff(Builder builder) {
        super(builder.id, builder.firstName, builder.lastName, Person.Type.STAFF);
        this.title = builder.title;
        this.assignedClub = builder.club;
        this.address = builder.address;
        this.phoneNumbers = builder.phoneNumbers;
        this.specialNeeds = builder.specialNeeds;
        this.email = builder.email;
        this.photo = builder.photo;
        this.thumbnail = builder.thumbnail;
        this.emergencyContact = builder.emergencyContact;

    }

	/**
	 * Returns the record childId
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
	
	/**
	 *  Sets the title of this {@link Staff} member.
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
	 * Adds a phone number to this staff members list of phone numbers. The
	 * number should be in its raw form without formatting characters. If any
	 * formatting characters are present or the input is not 10 characters in
	 * length the creation method will throw an Illegal Argument exception.
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
		return specialNeeds;
	}
	
	/**
	 * Adds a special need to this staff members special need listing.
	 */
	public void addSpecialNeed(String need) {
		if(specialNeeds != null) {
			specialNeeds += ", " + need;
		} else {
			specialNeeds = need;
		}
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
	 * Returns the photo of this staff member.
	 */
	public BufferedImage photo() {
		return photo;
	}
	
	/**
	 * Adds a photo to this staff members record.
	 */
	public void photo(BufferedImage image) {
		this.photo = image;
	}
	
	/**
	 * Returns the thumbnail photo of this staff member.
	 */
	public BufferedImage thumbnail() {
		return thumbnail;
	}
	/**
	 * Adds a thumbnail photo of this staff member.
	 */
	public void thumbnail(BufferedImage image) {
		this.thumbnail = image;
	}
	
	public static class Builder {
	    private UUID id;
		private String title;
		private Club club;
		private String firstName;
		private String lastName;

		private String streetAddress;
		private String city;
		private String state;
		private Zipcode zip;
		private Address address;

		private List<PhoneNumber> phoneNumbers = new ArrayList<>();
		private String specialNeeds = "";
		private String email;
		private BufferedImage photo;
		private BufferedImage thumbnail;

		private UUID emerId;
		private String emerFirstName;
		private String emerLastName;
		private PhoneNumber emerPhoneNumber;
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
		
		public Builder address(String address) {
			this.streetAddress = address;
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
			this.zip = new Zipcode(zip);
			return this;
		}

		public Builder address(Address address) {
		    this.address = address;
		    return this;
        }
		
		public Builder phoneNumber(String type, String number) {
			PhoneNumber ph = new PhoneNumber(PhoneNumber.Type.valueOf(type.toUpperCase()), number);
			return phoneNumber(ph);
		}

		public Builder phoneNumber(PhoneNumber number) {
		    this.phoneNumbers.add(number);
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
		
		public Builder thumbnail(BufferedImage thumbnail) {
			this.thumbnail = thumbnail;
			return this;
		}

		public Builder emergencyContactId(UUID id) {
		    this.emerId = id;
		    return this;
        }

		public Builder emergencyContactFirstName(String firstName) {
		    this.emerFirstName = firstName;
		    return this;
        }

        public Builder emergencyContactLastName(String lastName) {
		    this.emerLastName = lastName;
		    return this;
        }

        public Builder emergencyContactPhoneNumber(PhoneNumber number) {
		    this.emerPhoneNumber = number;
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
            Objects.requireNonNull(title);
            Objects.requireNonNull(club);
            if (address == null) {
                Objects.requireNonNull(streetAddress);
                Objects.requireNonNull(city);
                Objects.requireNonNull(state);
                Objects.requireNonNull(zip);
                address = Address.builder()
                        .streetAddress(streetAddress)
                        .city(city)
                        .state(state)
                        .zipcode(zip)
                        .create();
            }
            if (phoneNumbers.isEmpty()) {
                throw new IllegalArgumentException("You must have at least 1 phone number");
            }
            if (emergencyContact == null) {
                Objects.requireNonNull(emerFirstName);
                Objects.requireNonNull(emerLastName);
                Objects.requireNonNull(emerPhoneNumber);
                if (emerId == null) {
                    emerId = UUID.randomUUID();
                }
                emergencyContact = EmergencyContact.builder()
                        .id(emerId)
                        .firstName(emerFirstName)
                        .lastName(emerLastName)
                        .phoneNumber(emerPhoneNumber)
                        .type(Type.CONTACT)
                        .create();
            }

			return new Staff(this);
		}
	}
	
}
