package org.vbc4me.awanna.facets;

import java.util.Objects;
import java.util.UUID;

public abstract class Person {
	
	public enum Type {STAFF, STUDENT, PICKUP, CONTACT, GUARDIAN}
	private final UUID id;
	private final String first;
	private final String last;
	private final Type type;
	
	public Person(UUID id, String first, String last, Type type) {
		this.id = Objects.requireNonNull(id);
	    this.first = Objects.requireNonNull(first);
		this.last = Objects.requireNonNull(last);
		this.type = Objects.requireNonNull(type);
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
     * Return the type this {@link Person} represents.
     */
	public String recordType() {
		return type.name();
	}
	
}
