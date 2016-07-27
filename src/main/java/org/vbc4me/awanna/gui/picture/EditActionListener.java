package org.vbc4me.awanna.gui.picture;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 *		Allows access to this panels methods from within the button panel
 */
public class EditActionListener extends AbstractAction {
	private static final long serialVersionUID = 3252488674763352416L;
	private final PictureEditPanel dialog;
	private final ImageLabel label;
	
	public EditActionListener(PictureEditPanel dialog, ImageLabel label) {
		this.dialog = dialog;
		this.label = label;
	}
	
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
				label.rotateImage(90);
				break;
			case "counterclockwise":
				// rotate the full image counter clockwise
				label.rotateImage(-90);
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
				System.out.println("Image Area : " + label.getBounds());
				System.out.println("Label (x, y) : (" + label.getX() + ", " + label.getY() + ")");
				System.out.println("Label (w, h) : (" + label.getWidth() + ", " + label.getHeight() + ")");
				System.out.println("scaled image dimensions (used when paiting label) : " + dialog.scaledImageDimension());
				System.out.println("Crop Box: " + dialog.cropBox().x + " : " + dialog.cropBox().y + " : " + dialog.cropBox().width + " : " + dialog.cropBox().height);
				System.out.println("Image Icon : " + label.getIcon().getIconWidth() + " : " + label.getIcon().getIconHeight());
				System.out.println("----------------------------------------------------------------------------");
				break;
			case "cancel":
				dialog.dispose();
				break;
			default:
				throw new IllegalArgumentException("Unknown action command" + e.getActionCommand());
		}
	}
}
