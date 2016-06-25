package org.vbc4me.awanna.account;

import java.awt.Image;
import java.util.Objects;

/**
 * Represents a person authorized to pickup a child from the place where 
 * an activity is taking place.
 */
public class Pickup {
	private String first;
	private String last;
	private String relationship;
	private Image photo;
	
	private Pickup(String first, String last, String relationship, Image photo) {
		this.first = Objects.requireNonNull(first);
		this.last = Objects.requireNonNull(last);
		this.relationship = Objects.requireNonNull(relationship);
		this.photo = photo;
	}
	
	public String firstName() {
		return first;
	}
	
	public String lastName() {
		return last;
	}
	
	public String relationship() {
		return relationship;
	}
	
	public String toString() {
		return first + " " + last + " (" + relationship + ")";
	}
	
	public void addPhoto(Image photo) {
		this.photo = photo;
	}
	
	public Image photo() {
		return photo;
	}
	
	static class Builder {
		private String first;
		private String last;
		private String relationship;
		private Image photo;
		
		public Builder(String first, String last) {
			this.first = first;
			this.last = last;
		}
		
		public Builder relationship(String relationship) {
			this.relationship = relationship;
			return this;
		}
		
		public Builder photo(Image photo) {
			this.photo = photo;
			return this;
		}
		
		public Pickup done() {
			Objects.requireNonNull(first, "First name is required");
			Objects.requireNonNull(last, "Last name is required");
			Objects.requireNonNull(relationship, "Relationship is required");
			return new Pickup(first, last, relationship, photo);
		}
		
	}
}
