package org.vbc4me.awanna.gui.forms.activity.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*
 *  Action Classes for Buttons and Menu Items
 */
public class EditActivityAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public EditActivityAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Edit Activity");
    putValue(SHORT_DESCRIPTION, "Edits the currently loaded actions information ");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Edit Activity Action";
    String title = "Edit Activity";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}
