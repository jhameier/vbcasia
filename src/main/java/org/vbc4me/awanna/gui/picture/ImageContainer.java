package org.vbc4me.awanna.gui.picture;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 *   Container for holding data about an image, a thumbnail (a subset image of the parent image) and the data associated with 
 *       where the thumbnail is in relation to the parent image. 
 *    
 *    <p>
 *    This container's data is immutable and you can get cloned copies of the data you must create a new one if you want to store 
 *        changes made.
 */
public final class ImageContainer {
	
	private final BufferedImage image;				// Parent Image.
	private final BufferedImage thumbnail;		// Subset Image of size 100 x 100 (w, h).
	private final Dimension offset;						// The x and y offset of the upper left corner (0, 0) of the thumbnail in relation to the
															                        //   parents upper left corner (0, 0).
	
	public ImageContainer(BufferedImage parent, BufferedImage thumbnail, Dimension offset) {
		this.image = parent;
		this.thumbnail = thumbnail;
		this.offset = offset;
	}
	
	/**
	 * Returns a cloned copy of the primary parent image associated with this container. You cannot modify this containers offset.
	 */
	public BufferedImage cloneImage() {
		return deepCopy(image);
	}
	
	/**
	 * Returns a cloned copy of the thumbnail image associated with this container. You cannot modify this containers offset.
	 */
	public BufferedImage cloneThumbnail() {
		return deepCopy(thumbnail);
	}
	/**
	 * Return a new instance of the this containers offset. You cannot modify this containers offset.
	 */
	public Dimension getOffset() {
		return new Dimension(offset);
	}
	
	/**
	 *  Directly from Klark @  http://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
	 */
	private BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

	
	
	
}
