package org.vbc4me.awanna.gui.forms.activity.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CopyActivityRecordAction extends AbstractAction {

  private static final long serialVersionUID = -1288201101615570596L;
  private Container frame;

  public CopyActivityRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Copy Activity");
    putValue(SHORT_DESCRIPTION, "Copies the currently loaded Activity");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Copy Activity Action";
    String title = "Copy Activity";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}