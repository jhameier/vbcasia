package org.vbc4me.awanna.facets;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A postal designation for an address.
 */
public class Zipcode {

  private static String primary;
  private static String extended;

  public static Zipcode of(String zipcode) {
    if (zipcode.length() == 10 && zipcode.contains("-")) {
      String[] zip = zipcode.split("-");
      primary = zip[0];
      extended = zip[1];
    } else if (zipcode.length() == 5) {
      primary = zipcode;
    } else {
      throw new IllegalArgumentException("Zip code must contain either 5 numeric characters in the form of xxxxx"
          + " or contain exactly 10 numeric characters in the form of xxxxx-xxxx  with a hyphen after the " +
          "5th character.");
    }

    if (!verifyPrimary(primary) || (!verifyExtended(extended))) {
      throw new IllegalArgumentException("The primary and exended zipcode \""
          + primary + "-" + extended + "\" is not a valid zipcode");
    }
    if (extended.isEmpty()) {
      return new Zipcode(primary);
    }
    return new Zipcode(primary, extended);
  }

  public Zipcode(String primary) {
    this(primary, "");
  }

  /**
   * A postal designation for an address.  The extended code can be an empty string. A null string will throw a {@link
   * NullPointerException}.
   */
  public Zipcode(String primary, String extended) {
    verifyPrimary(Objects.requireNonNull(primary));
    verifyPrimary(Objects.requireNonNull(extended));
    this.primary = primary;
    this.extended = extended;
  }

  public String primary() {
    return primary;
  }

  public String extended() {
    return extended;
  }

  @Override
  public String toString() {
    if (extended.isEmpty()) {
      return primary;
    }
    return primary + "-" + extended;
  }

  private static boolean verifyPrimary(String primary) {
    if (primary.length() != 5) {
      throw new IllegalArgumentException("The zip code must be 5 characters in length; found "
          + primary.length() + " characters.");
    }
    Pattern p = Pattern.compile("^[0-9]{5}");
    Matcher m = p.matcher(primary);
    return m.matches();
  }

  private static boolean verifyExtended(String extended) {
    if (extended.length() > 0 && extended.length() < 4) {
      throw new IllegalArgumentException("The extended code must be 4 characters in length; found "
          + extended.length() + " characters.");
    } else if (extended.isEmpty()) {
      return true;
    }
    Pattern p = Pattern.compile("^[0-9]{4}");
    Matcher m = p.matcher(extended);
    return m.matches();
  }
}
