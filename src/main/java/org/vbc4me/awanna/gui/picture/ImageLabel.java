package org.vbc4me.awanna.gui.picture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * Custom label that allows automatic resizing of the {@link ImageIcon} when
 * the {@link JDialog dialog} this is attached to is resized.
 */
public class ImageLabel extends JLabel {
	private static final long serialVersionUID = 1827785467459231872L;
	
	private final PictureEditDialog dialog;
	protected Point previousPosition = new Point();
	protected Point currentPosition = new Point();
	
	@SuppressWarnings("unused")
	private boolean initial = true; 
	
	
	public ImageLabel(PictureEditDialog dialog, ImageIcon icon) {
		super(icon);
		this.dialog = dialog;
		// crates a border around the image same as background color
		setBorder(new LineBorder(getBackground(), 30));
	}
	
	protected void moveHorizontal(int distance) {
		// FIXME Add constraints for keeping this inside of border area
		currentPosition.x = currentPosition.x + distance;
	}
	
	protected void moveVertical(int distance) {
		// FIXME Add constraints for keeping this inside of border area
		currentPosition.y = currentPosition.y + distance;
	}
	
	protected void moveCropBox(Point point) {
		// FIXME add offset as to where cropbox is currently at verses where mouse was clicked within the box
		currentPosition.setLocation(point.x, point.y);
	}
	
	protected void rotateImage(int theta) {
		// Get a new rotated image from the container and create a new container
		BufferedImage rotated = dialog.imageContainer().rotate(dialog.imageContainer().cloneImage(), theta);
		BufferedImage thumbnail = ImageContainer.createThumbnail(rotated);
		dialog.imageContainer( new ImageContainer(rotated, thumbnail, new Dimension(0, 0)));
	}
	
	protected void paintComponent(Graphics g) {			
		if (getIcon() != null) {
			// resizes the image based on container size
			Dimension target = this.getSize();												// target container size  is JLabel
			Dimension original = dialog.imageContainer().getImageSize();		// gets the size of the original image
			
			// Automatically set the the width to the target width then scale height measurement
			dialog.scaledImageDimension().width = target.width;
			dialog.scaledImageDimension().height = (dialog.scaledImageDimension().width * original.height) / original.width;
			
			// Check to see if the height exceeds the current window height if so re-scale based off of height
			if (dialog.scaledImageDimension().height > target.height) {
				dialog.scaledImageDimension().height = target.height;
				dialog.scaledImageDimension().width = (dialog.scaledImageDimension().height * original.width) / original.height;
			}
			
			setIcon(new ImageIcon(ImageContainer.getScaledImage(dialog.imageContainer().cloneImage(), dialog.scaledImageDimension())));
		}
		
		int x = (int) ((getX()/2) - (dialog.scaledImageDimension().width/2));
		int y = (int) ((getY()/2) - (dialog.scaledImageDimension().height/2));
		int width = dialog.scaledImageDimension().width;
		int height = dialog.scaledImageDimension().height;
		
		Graphics2D g2d = (Graphics2D)g.create();			
		super.paintComponent(g);
		
		g2d.setColor(Color.BLUE);
		g2d.draw(dialog.cropBox());
		g2d.setColor(Color.RED);
		g2d.drawRect(x, y, width, height);
	}
	
	boolean checkCropBox() {
        if (dialog.imageArea() == null) {
            return false;
        }

        if (dialog.imageArea().contains(dialog.cropBox().x, dialog.cropBox().y, dialog.cropBox().getWidth(), dialog.cropBox().getHeight())) {
            return true;
        }

        int new_x = dialog.cropBox().x;
        int new_y = dialog.cropBox().y;

        if ((dialog.cropBox().x + dialog.cropBox().getWidth()) > dialog.imageArea().getWidth()) {
            new_x = (int) dialog.imageArea().getWidth() - (int) (dialog.cropBox().getWidth() - 1);
        }
        if (dialog.cropBox().x < 0) {
            new_x = -1;
        }
        if ((dialog.cropBox().y + dialog.cropBox().getHeight()) > dialog.imageArea().getHeight()) {
            new_y = (int) dialog.imageArea().getHeight() - (int) (dialog.cropBox().getHeight() - 1);
        }
        if (dialog.cropBox().y < 0) {
            new_y = -1;
        }
        dialog.cropBox().setLocation(new_x, new_y);
        return false;
    }
	
}
