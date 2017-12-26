package org.vbc4me.awanna.facets;

import java.util.Objects;

public abstract class Person {
	
	enum Type {STAFF, STUDENT, PICKUP}
	private String first;
	private String last;
	private Type type;
	
	public Person(String first, String last, Type type) {
		this.first = Objects.requireNonNull(first);
		this.last = Objects.requireNonNull(last);
		this.type = Objects.requireNonNull(type);
	}
	
	public String firstName() {
		return first;
	}
	
	public String lastName() {
		return last;
	}
	
	public String recordType() {
		return type.name();
	}
	
}
