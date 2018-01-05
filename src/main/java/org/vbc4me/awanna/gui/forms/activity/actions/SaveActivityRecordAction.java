package org.vbc4me.awanna.gui.forms.activity.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SaveActivityRecordAction extends AbstractAction {

  private static final long serialVersionUID = -1288201101615570596L;
  private Container frame;

  public SaveActivityRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Save Activity");
    putValue(SHORT_DESCRIPTION, "Saves the currently loaded actions");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Save Activity Action";
    String title = "Save Activity";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}