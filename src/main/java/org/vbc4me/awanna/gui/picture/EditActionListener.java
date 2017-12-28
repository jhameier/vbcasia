package org.vbc4me.awanna.gui.picture;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Allows access to this panels methods from within the button panel
 */
public class EditActionListener extends AbstractAction {
    private static final long serialVersionUID = 3252488674763352416L;
    private final PictureEditDialog dialog;
    private final PictureEditPanel panel;
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
    public EditActionListener(PictureEditDialog dialog, PictureEditPanel imagePanel) {
        this.dialog = dialog;
        this.panel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "reduce":
                panel.reduceCropBox(10);
                break;
            case "expand":
                panel.expandCropBox(10);
                break;
            case "clockwise":
                // rotate the full image clockwise
                panel.rotateImage(90);
                break;
            case "counterclockwise":
                // rotate the full image counter clockwise
                panel.rotateImage(-90);
                break;
            case "up":
                // move the crop box up
                panel.moveVertical(-2);
                break;
            case "down":
                // move the crop box down
                panel.moveVertical(2);
                break;
            case "left":
                // move the crop box left
                panel.moveHorizontal(-2);
                break;
            case "right":
                // move the crop box right
                panel.moveHorizontal(2);
                break;
            case "save":
                // save the current image and thumbnail to new
                panel.saveThumbnail();
                break;
            case "cancel":
                dialog.thumbnailPanel().resetThumbnail();
                ;
                dialog.dispose();
                break;
            default:
                throw new IllegalArgumentException("Unknown action command" + e.getActionCommand());
        }
    }
}
