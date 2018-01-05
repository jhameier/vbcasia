package org.vbc4me.awanna.gui.forms.session.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public final class SaveSessionAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public SaveSessionAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Save Session");
    putValue(SHORT_DESCRIPTION, "Saves this Session.");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Save Session Action";
    String title = "Save Session";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}