package org.vbc4me.awanna.gui.forms.staff.activities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateNewStaffRecordActivity extends AbstractAction {

  private static final long serialVersionUID = 6052353184094817955L;
  private final Container frame;

  public CreateNewStaffRecordActivity(Container frame) {
    this.frame = frame;
    putValue(NAME, "New Record");
    putValue(SHORT_DESCRIPTION, "Creates new blank staff record");
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

}
