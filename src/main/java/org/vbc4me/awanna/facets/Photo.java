package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

/**
 * Structure to hold photo, thumbnail and path to the image file.
 */
public class Photo {
	private final Path path;
	private final BufferedImage photo;
	private final BufferedImage thumbnail;
	
	/**
	 * Create an immutable structure to hold images.
	 * @param path: the path to the image
	 * @param photo: the image 
	 * @param thumbnail: the thumbnail of the image
	 */
	public Photo(Path path, BufferedImage photo, BufferedImage thumbnail) {
		this.path = path;
		this.photo = photo;
		this.thumbnail = thumbnail;
	}

	/**
	 * @return the path
	 */
	public final Path path() {
		return path;
	}

	/**
	 * @return the thumbnail
	 */
	public final BufferedImage thumbnail() {
		return thumbnail;
	}

	/**
	 * @return the photo
	 */
	public final BufferedImage photo() {
		return photo;
	}
	
}
