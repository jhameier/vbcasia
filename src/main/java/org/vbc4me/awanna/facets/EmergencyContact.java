package org.vbc4me.awanna.facets;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.vbc4me.awanna.gui.picture.Photo;

public class EmergencyContact extends Person {

  private final List<PhoneNumber> phoneNumbers;

  private EmergencyContact(Builder builder) {
    super(builder.id, builder.firstName, builder.lastName, builder.type, builder.photo);
    this.phoneNumbers = builder.phoneNumbers;
  }


  public static Builder builder() {
    return new Builder();
  }

  /**
   * Return the {@link PhoneNumber} associated with this {@link EmergencyContact}.
   */
  public List<PhoneNumber> phoneNumbers() {
    return phoneNumbers;
  }

  public static class Builder {

    private UUID id;
    private String firstName;
    private String lastName;
    private Type type;
    private List<PhoneNumber> phoneNumbers =  new ArrayList<>();
    private Photo photo;

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder type(Type type) {
      this.type = type;
      return this;
    }

    public Builder addPhoneNumber(PhoneNumber phoneNumber) {
      this.phoneNumbers.add(phoneNumber);
      return this;
    }

    public Builder photo(Photo photo) {
      this.photo = photo;
      return this;
    }

    public EmergencyContact create() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      if (type == null) {
        type = Type.CONTACT;
      }
      Objects.requireNonNull(firstName);
      Objects.requireNonNull(lastName);
      Preconditions.checkArgument(!phoneNumbers.isEmpty(), "At least 1 phone number is required.");
      return new EmergencyContact(this);
    }

  }
}
