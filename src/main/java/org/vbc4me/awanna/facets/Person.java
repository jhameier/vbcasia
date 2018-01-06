package org.vbc4me.awanna.facets;

import java.util.UUID;
import org.vbc4me.awanna.gui.picture.Photo;

public abstract class Person {

  UUID id;
  String first;
  String last;
  Type type;
  Photo photo;

  Person(UUID id, String first, String last, Type type, Photo photo) {
    this.id = id;
    this.first = first;
    this.last = last;
    this.type = type;
    this.photo = photo;
  }

  /**
   * Return the {@link UUID} associated with the {@link Person}.
   */
  public UUID id() {
    return id;
  }

  /**
   * Return the first name associated with this {@link Person}.
   */
  public String firstName() {
    return first;
  }

  /**
   * Return the last name associated with this {@link Person}.
   */
  public String lastName() {
    return last;
  }

  /**
   * Returns the full name (firstName lastName) of this {@link Person}.
   */
  public String name() {
    return first + " " + last;
  }

  /**
   * Return the type this {@link Person} represents.
   */
  public String recordType() {
    return type.name();
  }

  /**
   * Return the {@link Photo} associated with this {@link Person}.
   */
  public Photo photo() {
    return photo;
  }

  public enum Type {STAFF, STUDENT, PICKUP, CONTACT, GUARDIAN}
}
