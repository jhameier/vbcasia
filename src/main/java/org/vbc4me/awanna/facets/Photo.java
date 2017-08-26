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
	 * @param tpath: the path to the thumbnail image
	 * @param thumbnail: the thumbnail of the image
	 */
	public Photo(Path path, BufferedImage image, Path tpath, BufferedImage thumb) {
		Objects.requireNonNull(path);
		Objects.requireNonNull(image);
		Objects.requireNonNull(tpath);
		Objects.requireNonNull(thumb);
		this.photoPath = path;
		this.photo = image;
		this.thumbPath = tpath;
		this.thumbnail = thumb;
	}

	/**
	 * @return the path
	 */
	public Path photoPath() {
		return photoPath;
	}
	
	/**
	 * @return the thumbnail path
	 */
	public Path thumbnailPath() {
		return thumbPath;
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
