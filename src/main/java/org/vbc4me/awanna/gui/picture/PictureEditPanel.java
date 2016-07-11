package org.vbc4me.awanna.gui.picture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * This represents a workable panel that allows manipulation of images. This
 * panels primary purpose allows modifications to the {@link BufferedImage image}
 * in order to get to a cropped image of the size 100 x 100. This panel does not
 * permanently store the image but has the methods necessary to create the
 * thumbnail image. As a side effect this will return an {@link ImageContainer
 * Image Container} that is used to store the information needed by this class
 * to make future changes.
 */
public class PictureEditPanel extends JDialog {
	
	private static final long serialVersionUID = 2852491616246379626L;
	private ImageContainer imageContainer;
	private final JDialog dialog;
	private final ImageLabel label;
	private ImageIcon icon;
	private final Dimension DEFAULT_DIALOG_SIZE = new Dimension(600, 560);
	private final int DEFAULT_BORDER_SIZE = 30;
	private Dimension scaledImageDimension = new Dimension(0, 0);
	
	
	private JPanel imagePanel;
	
	public PictureEditPanel(JPanel parent, ImageContainer container) {
		this.imageContainer = container;
		this.dialog = new JDialog();
		dialog.setMinimumSize(DEFAULT_DIALOG_SIZE);
		dialog.setPreferredSize(DEFAULT_DIALOG_SIZE);
		
		// Scale the image to a standard size
		Dimension dim = container.getImageSize();
		
		double scale = 600 / dim.getWidth();
		Dimension sDim = new Dimension(600, (int) (dim.height * scale));
		
		// Setup Dialog
		dialog.setTitle("Create Thumbnail");
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(new BorderLayout());
		
		icon = new ImageIcon(imageContainer.getScaledImage(sDim));
		label = new ImageLabel(icon);
		
		imagePanel = new JPanel();
		imagePanel.setLayout(new BorderLayout());
		imagePanel.add(label, BorderLayout.CENTER);
		dialog.add(imagePanel, BorderLayout.CENTER);
		// Create button panel
		dialog.getContentPane().add(new EditPictureButtonPanel(new EditActionListener()), BorderLayout.NORTH);
		
		dialog.setVisible(true);
	}
	
	// FIXME Move this into the paint component section of the Image Label class
	private void rotateImage(int theta) {
		// Get a new rotated image from the container and create a new container
		BufferedImage rotated = imageContainer.rotate(imageContainer.cloneImage(), theta);
		BufferedImage thumbnail = ImageContainer.createThumbnail(rotated);
		this.imageContainer = new ImageContainer(rotated, thumbnail, new Dimension(0, 0));
		
		// Scale the image based on a standard 600 x 800 image (3x4 aspect ratio)
		double scale = 600.0 / rotated.getWidth();
		Dimension sDim = new Dimension(600, (int) (rotated.getHeight() * scale));
		
		if (sDim.height > 800) {
			scale = 800.0 / rotated.getHeight();
			sDim = new Dimension((int) (rotated.getWidth() * scale), 800);
		}
		
		icon = new ImageIcon(ImageContainer.getScaledImage(rotated, sDim));
		label.setIcon(icon);
		
		imagePanel.repaint();
	}
	
	/**
	 * Custom label that allows automatic resizing if the {@link ImageIcon} when
	 * the window this is attached to is resized.
	 */
	protected class ImageLabel extends JLabel {
		private static final long serialVersionUID = 1827785467459231872L;
		private int xPos = 20;
		private int yPos = 20;
		private int width = 100;
		private int height = 100;
		
		public ImageLabel(ImageIcon icon) {
			super(icon);
			setBorder(new LineBorder(getBackground(), DEFAULT_BORDER_SIZE));
		}
		
		public void moveHorizontal(int distance) {
			// FIXME Add constraints for keeping this inside of border area
			xPos = xPos + distance;
			revalidate();
		}
		
		public void moveVertical(int distance) {
			// FIXME Add constraints for keeping this inside of border area
			yPos = yPos + distance;
			revalidate();
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (getIcon() != null) {
				Dimension target = this.getSize();												// target containers size JLabel
				Dimension original = imageContainer.getImageSize();		// gets the size of the original image
				
				// Automatically set the the width to the target width then scale height measurement
				scaledImageDimension.width = target.width;
				scaledImageDimension.height = (scaledImageDimension.width * original.height) / original.width;
				
				// Check to see if the height exceeds the current window height if so re-scale based off of height
				if (scaledImageDimension.height > target.height) {
					scaledImageDimension.height = target.height;
					scaledImageDimension.width = (scaledImageDimension.height * original.width) / original.height;
				}
				
				ImageIcon icon = new ImageIcon(
						ImageContainer.getScaledImage(imageContainer.cloneImage(), scaledImageDimension));
				setIcon(icon);

				Graphics2D g2d = (Graphics2D)g.create();
				g2d.setColor(Color.RED);
				g2d.drawRect(xPos, yPos, width, height);
			}
		}
	}
	
	private class ImagePanel extends JPanel {
		private static final long serialVersionUID = 3218456572566697606L;
		private int xPos = 20 + DEFAULT_BORDER_SIZE;
		private int yPos = 20 + DEFAULT_BORDER_SIZE;
		private int width = 100;
		private int height = 100;
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g.create();
			g2d.setColor(Color.RED);
			g2d.drawRect(xPos, yPos, width, height);
			
		}
		
		public void moveHorizontal(int distance) {
			// FIXME Add constraints for keeping this inside of border area
			xPos = xPos + distance;
			revalidate();
		}
		
		public void moveVertical(int distance) {
			// FIXME Add constraints for keeping this inside of border area
			yPos = yPos + distance;
			revalidate();
		}
		
	}
	
	protected class EditActionListener extends AbstractAction {
		private static final long serialVersionUID = 3252488674763352416L;
		
		// Used when specifying the Action Commands used by buttons
		String REDUCE = "reduce";
		String EXPAND = "expand";
		String CLOCKWISE = "clockwise";
		String COUNTER_CLOCKWISE = "counterclockwise";
		String UP = "up";
		String DOWN = "down";
		String LEFT = "left";
		String RIGHT = "right";
		String SAVE = "save";
		String CANCEL = "cancel";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "reduce":
					// reduce the size of the crop box
					
					break;
				case "expand":
					// expand the size of the crop box

					break;
				case "clockwise":
					// rotate the full image clockwise
					rotateImage(90);
					break;
				case "counterclockwise":
					// rotate the full image counter clockwise
					rotateImage(-90);
					break;
				case "up":
					// move the crop box up
					label.moveVertical(-2);
					break;
				case "down":
					// move the crop box down
					label.moveVertical(2);
					break;
				case "left":
					// move the crop box left
					label.moveHorizontal(-2);
					break;
				case "right":
					// move the crop box right
					label.moveHorizontal(2);
					break;
				case "save":
					// save the current image and thumbnail to new
					// ImageContainer
					System.out.println("Icon Dimensions : " + icon.getIconWidth() + ":" + icon.getIconHeight());
					System.out.println("nDim (used when paiting label) : " + scaledImageDimension);
					break;
				case "cancel":
					dialog.dispose();
					break;
				default:
					throw new IllegalArgumentException("Unknown action command" + e.getActionCommand());
			}
		}
	}
	
}
