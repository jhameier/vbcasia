package org.vbc4me.awanna.facets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.IllegalAddException;

public class Zipcode {
	private String primary;
	private String extended;
	
	public Zipcode(String primary) {
		if (!verifyPrimary(primary)) {
			throw new IllegalAddException("The primary zipcode \"" + primary + "\" is not a valid zipcode");
		}
		this.primary = primary;
		this.extended = "";
	}
	
	public Zipcode(String primary, String extended) {
		if (!verifyPrimary(primary) || (!verifyExtended(extended))) {
			throw new IllegalAddException("The primary and exended zipcode \"" 
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
		Pattern p = Pattern.compile("^[0-9]{4}");
		Matcher m = p.matcher(extended);
		return m.matches();
	}
}
