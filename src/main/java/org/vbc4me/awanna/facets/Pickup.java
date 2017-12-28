package org.vbc4me.awanna.facets;

import java.util.Objects;
import java.util.UUID;

/**
 * Represents a person authorized to pickup a child from the place where an activity is taking place.
 */
public class Pickup extends Person {

  private final String relationship;

  private Pickup(Builder builder) {
    super(builder.id, builder.first, builder.last, Person.Type.PICKUP, builder.photo);
    this.relationship = builder.relationship;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Returns the relationship to the {@link Student} this {@link Pickup} is associated with.
   */
  public String relationship() {
    return relationship;
  }

  /**
   * Returns the first and last name and the relationship of this {@link Pickup}.
   */
  @Override
  public String toString() {
    return firstName() + " " + lastName() + " (" + relationship + ")";
  }


  public static class Builder {

    private UUID id;
    private String first;
    private String last;
    private String relationship;
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

    public Builder relationship(String relationship) {
      this.relationship = relationship;
      return this;
    }

    public Builder photo(Photo photo) {
      this.photo = photo;
      return this;
    }


    public Pickup create() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      Objects.requireNonNull(first, "First name is required");
      Objects.requireNonNull(last, "Last name is required");
      Objects.requireNonNull(relationship, "Relationship is required");
      return new Pickup(this);
    }

  }
}
