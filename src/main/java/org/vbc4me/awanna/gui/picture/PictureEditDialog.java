package org.vbc4me.awanna.gui.picture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * This represents a workable dialog that allows manipulation of images. This
 * dialogs primary purpose allows modifications to the {@link BufferedImage image}
 * in order to get to a cropped image of the size 100 x 100. This dialog does not
 * permanently store the image but has the methods necessary to create  and display the
 * image and a coping box. As a side effect this dialog will return an {@link ImageContainer
 * Image Container} that is used to store the original image and the thumbnail image that 
 * can be used by this dialog to make future changes.
 */
public class PictureEditDialog extends JDialog {
	
	private static final long serialVersionUID = 2852491616246379626L;
	private ImageContainer imageContainer;
	private final ImageLabel label;
	private ImageIcon icon;
	private final Dimension DEFAULT_DIALOG_SIZE = new Dimension(600, 600);
	private Dimension scaledImageDimension = new Dimension(0, 0);
	
	private Rectangle cropBox = new Rectangle(0,0,100,100);  		// box used as reference for the thumbnail image
	private Rectangle imageArea = new Rectangle(0,0,600,600);	// area that contains the image label
	private Point currentPosition = new Point();
	private Point previousPosition = new Point();
	private boolean outside = false;
	
	private PictureEditPanel_JPanel imagePanel;

	protected ImageContainer imageContainer() {
		return imageContainer;
	}
	
	protected void imageContainer(ImageContainer container) {
		this.imageContainer =  container;
	}
	
	protected Rectangle cropBox() {
		return cropBox;
	}
	
	protected Dimension scaledImageDimension() {
		return scaledImageDimension;
	}
	
	protected Rectangle imageArea() {
		return imageArea;
	}
	
	public PictureEditDialog(JPanel parent, ImageContainer container) {
		this.imageContainer = container;
		setMinimumSize(DEFAULT_DIALOG_SIZE);
		setPreferredSize(DEFAULT_DIALOG_SIZE);
		
		// Scale the image to a standard size
		Dimension dim = container.getImageSize();
		
		double scale = 600 / dim.getWidth();
		Dimension sDim = new Dimension(600, (int) (dim.height * scale));
		
		// Setup Dialog
		setTitle("Create Thumbnail");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		icon = new ImageIcon(imageContainer.getScaledImage(sDim));
		label = new ImageLabel(this, icon);
		ImageMouseListener mouseListener = new ImageMouseListener();
		label.addMouseListener(mouseListener);
		label.addMouseMotionListener(mouseListener);
		label.addMouseWheelListener(mouseListener);
//		add(label, BorderLayout.CENTER);
		imagePanel = new PictureEditPanel_JPanel(this);
		add(imagePanel, BorderLayout.CENTER);
		
		// Create button panel
		EditPictureButtonPanel buttonPanel = new EditPictureButtonPanel(new EditActionListener(this, label));
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}
	
	protected class ImageMouseListener extends MouseAdapter {
		
	    public void mousePressed(MouseEvent e) {
	    	previousPosition.x = cropBox.x - e.getX();
	    	previousPosition.y = cropBox.y - e.getY();
	    	
	    	if(cropBox.contains(e.getPoint())) {
	    		updateLocation(e);
	    	} else {
	    		outside = true;
	    	}
	    }
	    
	    public void mouseDragged(MouseEvent e) {
	    	if (!outside) {
	    		updateLocation(e);
	    	}
	    }

		public void mouseReleased(MouseEvent e) {
			if (cropBox.contains(e.getPoint())) {
				updateLocation(e);
			} else {
				outside = false;
			}
		}
	    
	    private void updateLocation(MouseEvent e) {
	    	cropBox.setLocation(previousPosition.x + e.getX(), previousPosition.y + e.getY());
	    	label.checkCropBox();
	    	repaint();
	    }

        //	    public void mouseClicked(MouseEvent e) {}
        //	    public void mouseEntered(MouseEvent e) {}
        //	    public void mouseExited(MouseEvent e) {}
        //	    public void mouseMoved(MouseEvent e) {}
        //	    public void mouseWheelMoved(MouseWheelEvent e){}
	}
}
