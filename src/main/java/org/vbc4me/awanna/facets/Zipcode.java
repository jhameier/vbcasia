package org.vbc4me.awanna.facets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A postal designation for an address.
 */
public class Zipcode {

  private static String primary;
  private static String extended;

  public static Zipcode of(String zipcode) {

    String first;
    String last;
    if (zipcode.length() == 10 && zipcode.contains("-")) {
      String[] zip = zipcode.split("-");
      first = zip[0];
      last = zip[1];
    } else if (zipcode.length() == 5) {
      first = zipcode;
      last = "";
    } else {
      throw new IllegalArgumentException("Zip code must contain either 5 numeric characters in the form of xxxxx"
          + " or contain exactly 10 numeric characters in the form of xxxxx-xxxx  with a hyphen after the " +
          "5th character.");
    }

    if (!verifyPrimary(first) || !verifyExtended(last)) {
      throw new IllegalArgumentException("The primary and exended zipcode \""
          + first + "-" + last + "\" is not a valid zipcode");
    }
    return new Zipcode(first, last);
  }

  private Zipcode(String primary, String extended) {
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
    if (extended == null || extended.isEmpty()) {
      return true;
    } else if (extended.length() != 4) {
      throw new IllegalArgumentException("The extended code must be 4 characters in length; found "
          + extended.length() + " characters : " + extended);
    }
    Pattern p = Pattern.compile("^[0-9]{4}");
    Matcher m = p.matcher(extended);
    return m.matches();
  }
}
