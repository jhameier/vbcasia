package org.vbc4me.awanna.gui.actions.picture;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 *  Action Classes for Buttons and Menu Items
 */
public class CropAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JFrame frame;

  public CropAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "Crop Picture");
    putValue(SHORT_DESCRIPTION, "Crops the currently loaded image to 100 x 100CropAction");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Crop Action";
    String title = "Crop Picture";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}