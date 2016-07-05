package org.vbc4me.awanna.gui.picture;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;

/**
 * This represents a workable panel that allows manipulation of images. This panel primary purpose allows modifications to the 
 * {@link BufferedImage image} in order to get to a cropped image of the size 100 x 100. This panel does not permanently store
 * the image but has the methods necessary to create the thumbnail image. As a side effect this will return an 
 * {@link ImageContainer Image Container} that is used to store the information needed by this class to make future changes.
 */
public class PictureEditPanel extends JDialog{
	
	private static final long serialVersionUID = 2852491616246379626L;
	private ImageContainer imageContainer;
	private final JDialog dialog;
	private Dimension dialogSize = new Dimension(0, 0);
	private final JLabel label;
	private ImageIcon icon;
	private double scale = 1.0;

	public PictureEditPanel(JPanel parent, ImageContainer container) {
		this.imageContainer = container;
		this.dialog = new JDialog();
		dialog.setMinimumSize(new Dimension(650, 560));
		// Scale the image to a standard size
		Dimension dim = container.getImageSize();
		double scale = 600 / dim.getWidth();
		Dimension sDim = new Dimension(600, (int)(dim.height * scale));
		
		// Setup Dialog
		dialog.setTitle("Create Thumbnail");
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(new BorderLayout());
		icon = new ImageIcon(imageContainer.getScaledImage(sDim));
		
		// Create button panel	
		dialog.getContentPane().add(new EditPictureButtonPanel(new EditActionListener()), BorderLayout.NORTH);
		
		label = new JLabel(icon);
//		JScrollPane scrollPane = new JScrollPane(label);
//		dialog.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		label.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// this creates a circular reference after rotation of the image
//				scaleImageByWindowSize(dialog.getSize());
			}
		});
		dialog.getContentPane().add(label, BorderLayout.CENTER);
		dialog.addMouseListener(new EditPanelMouseAdaptor());
		
		dialog.pack();
		dialog.setVisible(true);
		
		
		// Get Glass Panel to Display Crop Box
		
	}
	
	private void rotateImage(int theta) {
		BufferedImage rotated = imageContainer.rotate(imageContainer.cloneImage(), theta);
		BufferedImage thumbnail = ImageContainer.createThumbnail(rotated);
		ImageContainer newContainer = new ImageContainer(rotated, thumbnail, new Dimension(0, 0));
		this.imageContainer = newContainer;		
		dialog.remove(label);

		// Scale the image to a standard size
		scale = 600.0 / rotated.getWidth();
		Dimension sDim = new Dimension(600, (int)(rotated.getHeight() * scale));
		
		if(sDim.height > 800) {
			scale = 800.0 / rotated.getHeight();
			sDim = new Dimension((int)(rotated.getWidth() * scale), 800);
		}
		
		icon = new ImageIcon(ImageContainer.getScaledImage(rotated, sDim));
		label.setIcon(icon);
		dialog.getContentPane().add(label, BorderLayout.CENTER);
		dialog.pack();
	}
	
	private void scaleImageByWindowSize(Dimension dim) {
		dialog.remove(label);
		double localScale = dim.getHeight()/ imageContainer.getImageSize().getHeight();
		Dimension sDim = new Dimension((int)(imageContainer.getImageSize().getWidth() * localScale), 
																			(int)(imageContainer.getImageSize().getHeight() * localScale));
		icon = new ImageIcon(ImageContainer.getScaledImage(imageContainer.cloneImage(), sDim));
		label.setIcon(icon);
		dialog.getContentPane().add(label, BorderLayout.CENTER);
		dialog.pack();
	}
	
	// Class for use with automatic scaling  TODO DOES NOT WORK AT THIS TIME
	protected class ImageLabel extends JLabel {
		public ImageLabel(ImageIcon icon) {
			super(icon);
		}
		protected void paintComponent(Graphics g) {
			if(getIcon() != null) {
				drawScaledImage(this);
			}
		}
	}
	
	/**
	 *  Adapted from: http://www.codejava.net/java-se/graphics/drawing-an-image-with-automatic-scaling
	 */
	protected void drawScaledImage(ImageLabel label) {
        int imageWidth = imageContainer.cloneImage().getWidth();
        int imageHeight = imageContainer.cloneImage().getHeight();
        double imageAspectRatio = (double) imageHeight / imageWidth;
 
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        double labelAspectRatio = (double) labelHeight / labelWidth;
        
        // (x1, y1) ~ image top left corner
        int x1 = 0; 
        int y1 = 0; 
        // (x2, y2) ~ image bottom right corner
        int x2 = 0;
        int y2 = 0;
         
        // Image smaller than container 
        if (imageWidth < labelWidth && imageHeight < labelHeight) {
            x1 = (labelWidth - imageWidth)  / 2;
            y1 = (labelHeight - imageHeight) / 2;
            x2 = x1 + imageWidth;
            y2 = y1 + imageHeight;
        } else { // image larger than container
            if (labelAspectRatio > imageAspectRatio) {
                y1 = labelHeight;
                labelHeight = (int) (labelWidth * imageAspectRatio);
                y1 = (y1 - labelHeight) / 2;
            } else {
                x1 = labelWidth;
                labelWidth = (int) (labelHeight / imageAspectRatio);
                x1 = (x1 - labelWidth) / 2;
            }
            x2 = x1 + labelWidth;
            y2 = y1 + labelHeight;
        }
        label.getGraphics().drawImage(imageContainer.cloneImage(), x1, y1, x2, y2, 0, 0, imageWidth, imageHeight, null);
    }
	
	private class EditPanelMouseAdaptor extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			// handle the mouse to move the crop box to create the offset
			// the image displayed has to account for scaling of the image since the image is considered full size
		}
	}
	
	protected class EditActionListener extends AbstractAction {
		private static final long serialVersionUID = 3252488674763352416L;
		
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
			switch(e.getActionCommand()) {
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
					break;
				case "down":
					// move the crop box down
					break;
				case "left":
					// move the crop box left
					break;
				case "right":
					// move the crop box right
					break;
				case "save":
					// save the current image and thumbnail to new ImageContainer
					break;
				case "cancel":
					dialog.dispose();
					break;
				default:
					throw new IllegalArgumentException("Unknown action command" + e.getActionCommand() );			
			}
		}
		
	}
	
}
