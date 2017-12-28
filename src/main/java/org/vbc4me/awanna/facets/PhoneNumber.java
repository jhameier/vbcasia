package org.vbc4me.awanna.facets;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class PhoneNumber {

    private Type type;
    private String number;

    /**
     * Represents a persons phone number. The number should be in its raw form
     * such as 1234567890 and should contain 10 numeric digits.
     * <p>
     * <p>
     * If any of the following conditions are not met,
     * this constructor will throw and {@link IllegalArgumentException}:
     * The input is not exactly 10 digits
     * The input contains any character that is not numeric
     * <p>
     * <p>
     * The type is used to classify the number such as home or cell or office etc.
     */
    public static PhoneNumber of(Type type, String number) {
        return new PhoneNumber(type, number);
    }

    private PhoneNumber(Type type, String number) {

        Objects.requireNonNull(type, "Phone Type can not be empty");
        Objects.requireNonNull(number, "Phone Number can not be empty");

        if (number.length() < 10) {
            throw new IllegalArgumentException(
                    "There are not enough digits in the phone number. It should be 10 digits long.");
        }

        if (number.length() > 10) {
            throw new IllegalArgumentException(
                    "There are too many digits in the phone number. It should be exactly 10 digits long.");
        }

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) <= '0' && number.charAt(i) >= '9')
                throw new IllegalArgumentException(
                        "The character: " + number.charAt(i) + " is not a numeric digit.");
        }

        this.type = type;
        this.number = number;
    }

    public static boolean contains(List<PhoneNumber> numbers, PhoneNumber number) {
        for (PhoneNumber num : numbers) {
            if (num.number.equals(number.number))
                return true;
        }
        return false;
    }

    /**
     * Returns true if the phone number is removed from the list of phone numbers otherwise returns false.
     * The number can be formatted as xxx-xxx-xxxx or (xxx) xxx-xxxx or unformatted xxxxxxxxxx.
     */
    public static boolean removePhoneNumber(List<PhoneNumber> phoneNumbers, String number) {
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
        for (PhoneNumber ph : phoneNumbers) {
            if (ph.number(false).equals(number)) {
                pnumber = ph;
                break;
            }
        }
        return pnumber != null && phoneNumbers.remove(pnumber);
    }

    public String type() {
        return type.name();
    }

    /**
     * Returns a phone number either in its raw input form or formatted such as
     * (###) ###-####
     *
     * @param formatted (if true)
     * @return the phone number (formated if true)
     */
    public String number(boolean formatted) {
        if (formatted) {
            return formatPhoneNumber(number);
        }
        return number;
    }

    /**
     * Returns a {@link String} with the type and phone number
     * for use in displaying a well formated output in the form of:
     * <p>
     * <p> Number Type : (123) 456-7890
     */
    public String toString() {
        return type + ": " + formatPhoneNumber(number);
    }

    public boolean isEqualTo(PhoneNumber phoneNumber) {
        return this.number.equals(phoneNumber.number);

    }

    private String formatPhoneNumber(String number) {
        String mask = "(###) ###-####";
        try {
            MaskFormatter mf = new MaskFormatter(mask);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(number);
        } catch (ParseException pe) {
            return number;
        }

    }

    public enum Type {HOME, OFFICE, CELL, OTHER}


}
