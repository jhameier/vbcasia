package org.vbc4me.awanna.facets;

import java.util.Objects;

public class Address {

  private final String streetAddress;
  private final String city;
  private final String state;
  private final Zipcode zipcode;

  private Address(Builder builder) {
    this.streetAddress = builder.streetAddress;
    this.city = builder.city;
    this.state = builder.state;
    this.zipcode = builder.zipcode;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String streetAddress() {
    return streetAddress;
  }

  public String city() {
    return city;
  }

  public String state() {
    return state;
  }

  public Zipcode zipcode() {
    return zipcode;
  }

  public static class Builder {

    private String streetAddress;
    private String city;
    private String state;
    private Zipcode zipcode;

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

    public Address create() {
      Objects.requireNonNull(streetAddress);
      Objects.requireNonNull(city);
      Objects.requireNonNull(state);
      Objects.requireNonNull(zipcode);
      return new Address(this);
    }
  }
}
