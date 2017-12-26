package org.vbc4me.awanna.facets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.IllegalAddException;

import com.privatejgoodies.common.base.Objects;

/**
 * A postal designation for an address.
 */
public class Zipcode {
	private String primary;
	private String extended;
	
	public Zipcode(String primary) {
		this(primary,  "");
	}
	
	/**
	 * A postal designation for an address.  The extended code can be an empty string. A null string will throw a 
	 * {@link NullPointerException}.
	 */
	public Zipcode(String primary, String extended) {
		if (!verifyPrimary(primary) || (!verifyExtended(extended))) {
			throw new IllegalArgumentException("The primary and exended zipcode \"" 
																							+ primary + "-" + extended + "\" is not a valid zipcode");
		}
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
	
	private boolean verifyPrimary(String primary) {
		Pattern p = Pattern.compile("^[0-9]{5}");
		Matcher m = p.matcher(primary);
		return m.matches();
	}
	
	private boolean verifyExtended(String extended) {
		if (extended.length() > 0 && extended.length() < 4) {
			throw new IllegalArgumentException("The extended code must be 4 characters in length; found " 
						+ extended.length());
		} else if (extended.isEmpty() || extended.length() == 0) {
			return true;
		}
		Pattern p = Pattern.compile("^[0-9]{4}");
		Matcher m = p.matcher(extended);
		return m.matches();
	}
}
