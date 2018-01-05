package org.vbc4me.awanna.gui.forms.student.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class CopyStudentRecordAction extends AbstractAction {

  private static final long serialVersionUID = -1288201101615570596L;
  private final Container frame;

  public CopyStudentRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Copy Record");
    putValue(SHORT_DESCRIPTION, "Copies the currently loaded Record");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Copy Record Action";
    String title = "Copy Record";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}