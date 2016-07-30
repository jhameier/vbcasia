package org.vbc4me.awanna.gui.actions.picture;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.vbc4me.awanna.gui.picture.ImageContainer;
import org.vbc4me.awanna.gui.picture.PictureEditDialog;
import org.vbc4me.awanna.gui.picture.ThumbnailPanel;

/**
 * An action to call up a {@link JFileChooser} to select a photo to attach. The {@code JFileChooser}
 * uses a filter that only allows attaching a JPEG, PNG or GIF type file. 
 */
public class AttachPhotoAction extends AbstractAction {
	private static final long serialVersionUID = 6935260325468086008L;
	private final JPanel parent;

    /**
     * Constructs a action that allows attaching a photo to a {@link ThumbnailPanel} for display.
     *
     * @param panel: the parent panel that we want to center on
     */
    public AttachPhotoAction(JPanel parent ) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {
//    	PictureWorker worker = new PictureWorker(parent);
//    	worker.execute();
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
		
		int returnValue = chooser.showOpenDialog(parent);
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
				origImage = ImageIO.read(file);
				new PictureEditDialog(parent, new ImageContainer(origImage
						, ImageContainer.createThumbnail(origImage)
						,  new Dimension(0,0)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
