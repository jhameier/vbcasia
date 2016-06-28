package org.vbc4me.awanna.gui.actions.picture;

import org.vbc4me.awanna.gui.picture.PicturePanel;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * An action to call up a {@link JFileChooser} to select a photo to attach. The {@code JFileChooser}
 * uses a filter that only allows attaching a JPEG, PNG or GIF type file. 
 */
public class AttachPhotoAction extends AbstractAction {
	private static final long serialVersionUID = 6935260325468086008L;
	private JPanel panel;

    /**
     * Constructs a action that allows attaching a photo to a {@link JPanel}.
     *
     * @param panel     the parent panel that we want to center on
     * @param person    the identifier as to individual this photo is associated with
     * @param panelType the panel type to associate this action with
     */
    public AttachPhotoAction(JPanel panel, String person) {
        this.panel = panel;
        putValue("person", person);
        putValue(NAME, "About");
        putValue(SHORT_DESCRIPTION, "Displays Information about this Application");
    }

    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image File (jpg, png, gif)", "jpg", "JPG", "png", "PNG", "gif", "GIF");
        chooser.setFileFilter(filter);

        int returnValue = chooser.showOpenDialog(panel);
        if (returnValue == JFileChooser.APPROVE_OPTION) {

          /*
           *  1) Get Buffered Image of Photo
           *  2) Display image in JFrame ie PicturePanel
           *  3) Allow the user to crop the image to a 100 x 100 size
           *  4)
           */
            File file = new File(chooser.getSelectedFile().getAbsolutePath());

            try {
                BufferedImage origImage = ImageIO.read(file);
                PicturePanel picturePanel = new PicturePanel(origImage);
                

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}
