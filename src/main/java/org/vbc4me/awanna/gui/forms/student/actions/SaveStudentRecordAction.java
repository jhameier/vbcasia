package org.vbc4me.awanna.gui.forms.student.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class SaveStudentRecordAction extends AbstractAction {

  private static final long serialVersionUID = -1288201101615570596L;
  private final Container frame;

  public SaveStudentRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Save Record");
    putValue(SHORT_DESCRIPTION, "Saves the currently loaded Record");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Save Record Action";
    String title = "Save Record";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}