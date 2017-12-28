package org.vbc4me.awanna.facets;

import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Structure to hold image, thumbnail and path to the image file.
 */
public class Photo {
    private final BufferedImage image;
    private final BufferedImage thumbnail;

    /**
     * Create an immutable structure to hold images.
     *
     * @param image:     the image
     * @param thumbnail: the thumbnail of the image
     */
    public Photo(BufferedImage image, BufferedImage thumbnail) {
        this.image = Objects.requireNonNull(image);
        this.thumbnail = Objects.requireNonNull(thumbnail);
    }

    /**
     * @return the thumbnail
     */
    public BufferedImage thumbnail() {
        return thumbnail;
    }

    /**
     * @return the image
     */
    public BufferedImage image() {
        return image;
    }
}
