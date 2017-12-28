package org.vbc4me.awanna.facets;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Guardian extends Person {

  private final Address address;
  private final List<PhoneNumber> phoneNumbers = new ArrayList<>();
  private String emailAddress;

  private Guardian(Builder builder) {
    super(builder.id, builder.first, builder.last, Type.GUARDIAN, builder.photo);
    this.address = builder.address;
    this.phoneNumbers.addAll(builder.phoneNumbers);
    this.emailAddress = builder.emailAddress;
  }

  public static Builder builder() {
    return new Builder();
  }

  public Address address() {
    return address;
  }

  public String emailAddress() {
    return emailAddress;
  }

  /**
   * Returns an unmodifyable list of {@link PhoneNumber}s.
   */
  public List<PhoneNumber> phoneNumbers() {
    return Collections.unmodifiableList(phoneNumbers);
  }

  public static class Builder {

    private UUID id;
    private String first;
    private String last;
    private String streetAddress;
    private String city;
    private String state;
    private Zipcode zipcode;
    private Address address;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private String emailAddress;
    private Photo photo;

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder first(String first) {
      this.first = first;
      return this;
    }

    public Builder last(String last) {
      this.last = last;
      return this;
    }

    public Builder streetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
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

    public Builder zipcode(Zipcode zipcode) {
      this.zipcode = zipcode;
      return this;
    }

    public Builder address(Address address) {
      this.address = address;
      return this;
    }

    public Builder setPhoneNumber(PhoneNumber phoneNumber) {
      this.phoneNumbers.add(phoneNumber);
      return this;
    }

    public Builder setAllPhoneNumbers(List<PhoneNumber> phoneNumbers) {
      this.phoneNumbers.addAll(phoneNumbers);
      return this;
    }

    public Builder emailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
      return this;
    }

    public Builder photo(Photo photo) {
      this.photo = photo;
      return this;
    }

    public Guardian create() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      Objects.requireNonNull(first);
      Objects.requireNonNull(last);
      if (address == null) {
        Objects.requireNonNull(streetAddress);
        Objects.requireNonNull(city);
        Objects.requireNonNull(state);
        Objects.requireNonNull(zipcode);
        address = Address.builder()
            .streetAddress(streetAddress)
            .city(city)
            .state(state)
            .zipcode(zipcode)
            .create();
      }
      if (phoneNumbers.isEmpty()) {
        throw new IllegalArgumentException("There must be at least 1 phone number added.");
      }
      return new Guardian(this);
    }
  }
}
