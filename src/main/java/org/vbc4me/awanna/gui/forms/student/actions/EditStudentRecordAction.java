package org.vbc4me.awanna.gui.forms.student.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Action Class for Buttons and Menu Items
 */
public final class EditStudentRecordAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public EditStudentRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Edit Record");
    putValue(SHORT_DESCRIPTION, "Edits the currently loaded record information ");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Edit Record Action";
    String title = "Edit Record";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}