package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.Objects;

/**
 * Structure to hold photo, thumbnail and path to the image file.
 */
public class Photo {
	private final BufferedImage photo;
	private final BufferedImage thumbnail;
	
	/**
	 * Create an immutable structure to hold images.
	 * @param photo: the image
	 * @param thumb: the thumbnail of the image
	 */
	public Photo(BufferedImage photo, BufferedImage thumb) {
		this.photo = Objects.requireNonNull(photo);
		this.thumbnail = Objects.requireNonNull(thumb);
	}
	
	/**
	 * @return the thumbnail
	 */
	public BufferedImage thumbnail() {
		return thumbnail;
	}

	/**
	 * @return the photo
	 */
	public BufferedImage photo() {
		return photo;
	}
}
