package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.util.UUID;

public abstract class Person {
	
	public enum Type {STAFF, STUDENT, PICKUP, CONTACT, GUARDIAN}
	UUID id;
	String first;
	String last;
	Type type;
	Photo photo;

	public Person(UUID id, String first, String last, Type type, Photo photo) {
	    this.id = id;
	    this.first = first;
	    this.last = last;
	    this.type = type;
	    this.photo = photo;
    }



    /**
     * Return the {@link UUID} associated with the {@link Person}.
     */
    public  UUID id() {
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



    /**
     * Return the {@link BufferedImage image} associated with this {@link Person}.
     */
    public BufferedImage image() {
        return photo.image();
    }
    /**
     * Return the {@link BufferedImage thumbnail image} associated with this {@link Person}.
     */
    public BufferedImage thumbnail() {
        return photo.thumbnail();
    }
}
