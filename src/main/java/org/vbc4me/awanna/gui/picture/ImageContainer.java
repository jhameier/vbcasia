package org.vbc4me.awanna.gui.picture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Objects;

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
	private boolean valid = false;						// used to signal if this has a valid image or is just holding a blank images.
		
	/**
	 *  Creates a new immutable container with the primary image, thumbnail and offset of the thumbnail.
	 */
	public ImageContainer(BufferedImage primaryImage, BufferedImage thumbnail, Dimension offset) {
		this.image = Objects.requireNonNull(primaryImage);
		this.thumbnail = Objects.requireNonNull(thumbnail);
		this.offset = Objects.requireNonNull(offset);
	}
	
	/**
	 * Returns a cloned copy of the primary parent image associated with this container. You cannot modify this containers image.
	 */
	public BufferedImage cloneImage() {		
		return deepCopy(image);
	}
	
	/**
	 * Returns a cloned copy of the thumbnail image associated with this container. You cannot modify this containers thumbnail.
	 */
	public BufferedImage cloneThumbnail() {
		return deepCopy(thumbnail);
	}
	/**
	 * Return a new instance of this containers offset. You cannot modify this containers offset.
	 */
	public Dimension getOffset() {
		return new Dimension(offset);
	}
	
	public boolean isValid() {
		return valid;
	}
	
	/**
	 *  Modifed from Klark:  http://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
	 */
	private BufferedImage deepCopy(BufferedImage image) {
		 return new BufferedImage(image.getColorModel(), 
				 image.copyData(null), image.getColorModel().isAlphaPremultiplied(), null);
	}

	/**
	 * Returns an empty {@link ImageContainer Image Container} with an Alpha enabled image and thumbnail.
	 */
	public static ImageContainer intializeEmptyContainer() {
		BufferedImage img = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
		BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		img.createGraphics().setColor(new Color(0, true));
		thumb.createGraphics().setColor(new Color(0, true));	
		return new ImageContainer(img , thumb, new Dimension(0, 0));
	}
	
	/**
	 * Returns a scaled duplicate of the image sized to 100 x 100 pixels.
	 */
	public static BufferedImage createThumbnail(BufferedImage image) {
		BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		thumb.createGraphics().drawImage(image.getScaledInstance(100, 100, BufferedImage.TYPE_INT_RGB), 0, 0,  null);
		return thumb;
	}

	/**
	 * Returns the dimensions of the image;
	 */
	public Dimension getImageSize() {
		return new Dimension(image.getWidth(), image.getHeight());
	}

	/**
	 * Returns a scaled copy of this containers image to size of {@link Dimension dim}.
	 */
	public BufferedImage getScaledImage(Dimension dim) {
		BufferedImage img = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
		img.createGraphics().drawImage(image.getScaledInstance(dim.width, dim.height, Image.SCALE_SMOOTH), 0, 0, null);
		return img;
	}
	
	/**
	 * Returns a scaled copy of an {@link BufferedImage image) to size of {@link Dimension dim}.
	 */
	public static BufferedImage getScaledImage(BufferedImage image, Dimension dim) {
		BufferedImage img = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
		img.createGraphics().drawImage(image.getScaledInstance(dim.width, dim.height, Image.SCALE_SMOOTH), 0, 0, null);
		return img;
	}
	
	public BufferedImage rotateImage(double theta) {
		double rotation = Math.toRadians (theta);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		
		AffineTransform at = new AffineTransform();
		at.setToQuadrantRotation(1, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage rotated = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		op.filter(image, rotated);
		return rotated;
	}
	
	/**
	 * From http://www.programcreek.com/java-api-examples/java.awt.image.AffineTransformOp
	 * 
	 *    Example 2: Project: FireflowEngine20   File: Images.java 
	 */
	public BufferedImage rotate(BufferedImage image, int degree) {
	    int iw = image.getWidth();
	    int ih = image.getHeight();
	    int w = 0;
	    int h = 0;
	    int x = 0;
	    int y = 0;
	    degree = degree % 360;
	    if (degree < 0)
	        degree = 360 + degree;
	    double ang = degree * 0.0174532925;

	    if (degree == 180 || degree == 0 || degree == 360) {
	        w = iw;
	        h = ih;
	    } else if (degree == 90 || degree == 270) {
	        w = ih;
	        h = iw;
	    } else {
	        int d = iw + ih;
	        w = (int) (d * Math.abs(Math.cos(ang)));
	        h = (int) (d * Math.abs(Math.sin(ang)));
	    }
	    x = (w / 2) - (iw / 2);
	    y = (h / 2) - (ih / 2);
	    BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
	    Graphics gs = rotatedImage.getGraphics();
	    gs.fillRect(0, 0, w, h);
	    AffineTransform at = new AffineTransform();
	    at.rotate(ang, w / 2, h / 2);
	    at.translate(x, y);
	    AffineTransformOp op = new AffineTransformOp(at,
	                                                 AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	    op.filter(image, rotatedImage);
	    image = rotatedImage;
	    return image;
	}
	
}
