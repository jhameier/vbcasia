package org.vbc4me.awanna.account;

import java.text.ParseException;
import java.util.Objects;

import javax.swing.text.MaskFormatter;

public class PhoneNumber {
	private String type;
	private String number;

	/**
	 * Represents a persons phone number. The number should be in its raw form
	 * such as 1234567890 and should contain 10 numeric digits. The type is used to
	 * classify the number such as home or cell or office etc.
	 */
	public PhoneNumber(String type, String number) {

		Objects.requireNonNull(type, "Phone Type can not be empty");
		Objects.requireNonNull(number, "Phone Number can not be empty");

		if (number.contains(" ") || number.contains("(") || number.contains(")") || number.contains("-")) {
			throw new IllegalArgumentException(
					"The number should not conatin special characters such as '(', ')', '-',  or blank spaces.");
		}

		if (number.length() < 10) {
			throw new IllegalArgumentException(
					"There are not enough numbers in the phone number. It should be 10 characters long.");
		}

		if (number.length() > 10) {
			throw new IllegalArgumentException(
					"There are too many numbers in the phone number. It should be 10 characters long.");
		}

		this.type = type;
		this.number = number;
	}

	public String type() {
		return type;
	}

	/**
	 * Returns a phone number either in its raw input form or formatted such as
	 * (###) ###-####
	 *
	 * @param formatted  (if true)
	 * @return the phone number (formated if true)
	 */
	public String number(boolean formatted) {
		if (formatted) {
			return formatPhoneNumber(number);
		}
		return number;
	}

	public String toString() {
		return type + ": " + formatPhoneNumber(number);
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

}
