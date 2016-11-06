package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Represents a person authorized to pickup a child from the place where 
 * an actions is taking place.
 */
public class Pickup {
	private String first;
	private String last;
	private String relationship;
	private BufferedImage photo;
	private Path photoPath;
	private BufferedImage thumbnail;
	private Path thumbnailPath;
	
	public static Builder build() {
		return new Builder();
	}
	
	private Pickup(Builder builder) {
		this.first = builder.first;
		this.last = builder.last;
		this.relationship = builder.relationship;
		this.photo = builder.photo;
		this.photoPath = builder.photoPath;
		this.thumbnail = builder.thumbnail;
		this.thumbnailPath = builder.thumbnailPath;
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
	
	public void addPhotoPath(String path) {
		this.photoPath = Paths.get(path);
	}
	
	public Path photoPath() {
		return photoPath;
	}
	
	public void thumbnail(BufferedImage thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public BufferedImage thumbnail() {
		return thumbnail;
	}
	
	public void addThumbnailPath(String path) {
		this.thumbnailPath = Paths.get(path);
	}
	
	public Path thumbnailPath() {
		return thumbnailPath;
	}
	
	static class Builder {
		private String first;
		private String last;
		private String relationship;
		private BufferedImage photo;
		private Path photoPath;
		private BufferedImage thumbnail;
		private Path thumbnailPath;
		
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
		
		public Builder photoPath(String path) {
			this.photoPath = Paths.get(path);
			return this;
		}
		
		public Builder thumbnail(BufferedImage thumbnail) {
			this.thumbnail = thumbnail;
			return this;
		}
		
		public Builder thumbnailPath(String path) {
			this.thumbnailPath = Paths.get(path);
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
