package org.vbc4me.awanna.gui.actions.picture;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.vbc4me.awanna.gui.picture.ImageContainer;
import org.vbc4me.awanna.gui.picture.PictureEditDialog;
import org.vbc4me.awanna.gui.picture.ThumbnailPanel;

/**
 * An action to call up a {@link JFileChooser} to select a photo to attach. The {@code JFileChooser}
 * uses a filter that only allows attaching a JPEG, PNG or GIF type file. 
 */
public final class AttachPhotoAction extends AbstractAction {
	private static final long serialVersionUID = 6935260325468086008L;
	private final ThumbnailPanel thumbnailPanel;

    /**
     * Constructs a action that allows attaching a photo to a {@link ThumbnailPanel} for display.
     *
     * @param thumbnailPanel: the parent panel that we want to center on
     */
    public AttachPhotoAction(ThumbnailPanel thumbnailPanel) {
        this.thumbnailPanel = thumbnailPanel;
    }

    public void actionPerformed(ActionEvent e) {
    	attachPhoto();
    }

	private void attachPhoto() {
		Preferences preferences = Preferences.userRoot();
		String path = preferences.get("DEFAULT_PATH", "");
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setCurrentDirectory(new File(path));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image File (jpg, png, gif)", "jpg", "JPG", "png",
				"PNG", "gif", "GIF");
		chooser.setFileFilter(filter);
		
		int returnValue = chooser.showOpenDialog(thumbnailPanel.getParent());
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			
			/*
			 * 1) Get Buffered Image of Photo 
			 *        A) create an Image Container
			 * 2) Display image in JDialog ~ PicturePanel 
			 * 3) Allow the user to crop the image to a 100 x 100 size 
			 */
			File file = new File(chooser.getSelectedFile().getAbsolutePath());
			chooser.setCurrentDirectory(file);
			preferences.put("DEFAULT_PATH", file.getAbsolutePath());
			
			BufferedImage origImage;
			try {
				// read in the image needed to make the thumbnail from and create an initial thumbnail from the entire image.
				origImage = ImageIO.read(file);
				BufferedImage tempThumbnail = ImageContainer.createThumbnail(origImage);
				
				// Create a new image container
				ImageContainer container = new ImageContainer(origImage, tempThumbnail);
				
				// Attach the new image container to the thumbnail panel
				thumbnailPanel.updateThumbnail(container);
				
				// Create new dialog
				new PictureEditDialog(thumbnailPanel);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
