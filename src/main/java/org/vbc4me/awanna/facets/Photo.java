package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.Objects;

/**
 * Structure to hold photo, thumbnail and path to the image file.
 */
public class Photo {
	private final Path photoPath;
	private final BufferedImage photo;
	private final Path thumbPath;
	private final BufferedImage thumbnail;
	
	/**
	 * Create an immutable structure to hold images.
	 * @param path: the path to the image
	 * @param photo: the image 
	 * @param thumbnail: the thumbnail of the image
	 */
	public Photo(Path photoPath, BufferedImage photo, Path thumbPath, BufferedImage thumbnail) {
		Objects.requireNonNull(photoPath);
		Objects.requireNonNull(thumbPath);
		Objects.requireNonNull(photo);
		Objects.requireNonNull(thumbnail);
		this.photoPath = photoPath;
		this.photo = photo;
		this.thumbPath = thumbPath;
		this.thumbnail = thumbnail;
	}

	/**
	 * @return the path
	 */
	public final Path photoPath() {
		return photoPath;
	}
	
	/**
	 * @return the thumbnail path
	 */
	public final Path thumbnailPath() {
		return thumbPath;
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
