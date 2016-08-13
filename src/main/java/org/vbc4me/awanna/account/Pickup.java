package org.vbc4me.awanna.account;

import java.awt.image.BufferedImage;
import java.util.Objects;
// FIXME add javadoc comments
/**
 * Represents a person authorized to pickup a child from the place where 
 * an activity is taking place.
 */
public class Pickup {
	private String first;
	private String last;
	private String relationship;
	private BufferedImage photo;
	private BufferedImage thumbnail;
	
	public static Builder build() {
		return new Builder();
	}
	
	private Pickup(Builder builder) {
		this.first = builder.first;
		this.last = builder.last;
		this.relationship = builder.relationship;
		this.photo = builder.photo;
		this.thumbnail = builder.thumbnail;
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
	
	public void addPhoto(BufferedImage photo) {
		this.photo = photo;
	}
	
	public BufferedImage photo() {
		return photo;
	}
	
	public void addThumbail(BufferedImage thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public BufferedImage thumbnail() {
		return thumbnail;
	}
	
	static class Builder {
		private String first;
		private String last;
		private String relationship;
		private BufferedImage photo;
		private BufferedImage thumbnail;
		
		public Builder() {}
		
		public Builder first(String first) {
			this.first = first;
			return this;
		}
		
		public Builder last(String last) {
			this.last = last;
			return this;
		}
		
		public Builder relationship(String relationship) {
			this.relationship = relationship;
			return this;
		}
		
		public Builder photo(BufferedImage photo) {
			this.photo = photo;
			return this;
		}
		
		public Builder thumbnail(BufferedImage thumbnail) {
			this.thumbnail = thumbnail;
			return this;
		}
		
		public Pickup done() {
			Objects.requireNonNull(first, "First name is required");
			Objects.requireNonNull(last, "Last name is required");
			Objects.requireNonNull(relationship, "Relationship is required");
			return new Pickup(this);
		}
		
	}
}
