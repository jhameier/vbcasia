package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a person authorized to pickup a child from the place where 
 * an activity is taking place.
 */
public class Pickup extends Person{
	private final String relationship;
	private BufferedImage photo;
	private Path photoPath;
	private BufferedImage thumbnail;
	private Path thumbnailPath;
	
	public static Builder build() {
		return new Builder();
	}
	
	private Pickup(Builder builder) {
		super(builder.id, builder.first, builder.last, Person.Type.PICKUP);
		this.relationship = builder.relationship;
		this.photo = builder.photo;
		this.thumbnail = builder.thumbnail;
	}
	
	/**
	 * Returns the relationship to the {@link Student} this {@link Pickup} is associated with.
	 */
	public String relationship() {
		return relationship;
	}
	
	/**
	 * Returns the first and last name and the relationship of this {@link Pickup}.
	 */
	@Override
	public String toString() {
		return firstName() + " " + lastName() + " (" + relationship + ")";
	}
	
	public void addPhoto(BufferedImage photo) {
		this.photo = photo;
	}
	
	public BufferedImage photo() {
		return photo;
	}
	
	public void thumbnail(BufferedImage thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public BufferedImage thumbnail() {
		return thumbnail;
	}
	
	static class Builder {
		private UUID id;
		private String first;
		private String last;
		private String relationship;
		private BufferedImage photo;
		private BufferedImage thumbnail;
		
		public Builder id(UUID id) {
		    this.id = id;
		    return this;
        }
		
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
		
		public Pickup create() {
		    if (id == null) {
		        id = UUID.randomUUID();
            }
			Objects.requireNonNull(first, "First name is required");
			Objects.requireNonNull(last, "Last name is required");
			Objects.requireNonNull(relationship, "Relationship is required");
			return new Pickup(this);
		}
		
	}
}
