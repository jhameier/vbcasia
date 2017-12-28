package org.vbc4me.awanna.gui.picture;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    private final ThumbnailPanel thumbnailPanel;
    private final Dimension DEFAULT_DIALOG_SIZE = new Dimension(600, 600);

    /**
     * Constructs a new dialog that allows the creation of a thumbnail image
     * used to display within some panel. All images needed to create and store the thumbnail are provided by the
     * {@link ThumbnailPanel panel} passed in.
     */
    public PictureEditDialog(ThumbnailPanel thumbnailPanel) {
        this.thumbnailPanel = thumbnailPanel;

        setMinimumSize(DEFAULT_DIALOG_SIZE);
        setPreferredSize(DEFAULT_DIALOG_SIZE);

        // Setup the Dialog
        setTitle("Update Thumbnail");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        PictureEditPanel imagePanel = new PictureEditPanel(this);
        add(imagePanel, BorderLayout.CENTER);

        // Create button panel
        EditPictureButtonPanel buttonPanel = new EditPictureButtonPanel(new EditActionListener(this, imagePanel));
        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        setModalityType(ModalityType.APPLICATION_MODAL);
        pack();
        setVisible(true);
    }

    protected ThumbnailPanel thumbnailPanel() {
        return thumbnailPanel;
    }

}
