package org.vbc4me.awanna.gui.picture;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Allows cropping a picture to the normalized size of 100 x 100 which we use to
 * display throughout the application. 100 x 100 is an arbitrary size but seems
 * most appropriate for displaying a face shot of a person.
 *
 * Created by John Hameier January 2016.
 */
public class CropPicturePanel {
	
	BufferedImage image;
	
	/**
	 * Creates a copy of the original image and holds this in memory for
	 * 
	 * @param image
	 */
	public CropPicturePanel(BufferedImage image) {
		this.image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TRANSLUCENT);
		Graphics2D g2d = this.image.createGraphics();
		g2d.drawImage(image, 0, 0, null);
	}
	
}
