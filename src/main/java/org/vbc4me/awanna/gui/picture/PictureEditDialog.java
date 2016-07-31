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
	private final Dimension DEFAULT_DIALOG_SIZE = new Dimension(600, 600);
	
	private PictureEditPanel imagePanel;

	protected ImageContainer imageContainer() {
		return imageContainer;
	}
	
	protected void imageContainer(ImageContainer container) {
		this.imageContainer =  container;
	}
	
	public PictureEditDialog(JPanel parent, ImageContainer container) {
		this.imageContainer = container;
		setMinimumSize(DEFAULT_DIALOG_SIZE);
		setPreferredSize(DEFAULT_DIALOG_SIZE);
		
		// Get the image size (full size of the original image)
		Dimension dim = container.getImageSize();
		
		// create new dimension with a standardized width of 600 x a scaled height
		double scale = 600 / dim.getWidth();
		Dimension sDim = new Dimension(600, (int) (dim.height * scale));
		
		// Setup the Dialog
		setTitle("Create Thumbnail");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		imagePanel = new PictureEditPanel(this);
		add(imagePanel, BorderLayout.CENTER);
		
		// Create button panel
		EditPictureButtonPanel buttonPanel = new EditPictureButtonPanel(new EditActionListener(this, imagePanel));
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}
	
}
