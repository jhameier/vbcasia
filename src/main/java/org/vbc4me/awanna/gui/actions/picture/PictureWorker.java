package org.vbc4me.awanna.gui.actions.picture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.vbc4me.awanna.gui.picture.ImageContainer;
import org.vbc4me.awanna.gui.picture.PictureEditDialog;

public class PictureWorker extends SwingWorker<Void, Void> {
	private final JPanel parent;

	
	public PictureWorker(JPanel parent) {
		this.parent = parent;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
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
			try {
				BufferedImage origImage = ImageIO.read(file);
				new PictureEditDialog(parent, new ImageContainer(origImage, ImageContainer.createThumbnail(origImage)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		return null;
	}
	
	@Override
	protected void done() {
		System.out.println("Done with pict panel.");
	}
}
