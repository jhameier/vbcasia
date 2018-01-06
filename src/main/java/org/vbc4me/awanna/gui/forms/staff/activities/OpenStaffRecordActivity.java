package org.vbc4me.awanna.gui.forms.staff.activities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OpenStaffRecordActivity extends AbstractAction {

  private static final long serialVersionUID = -7690753674045453508L;
  private final Container frame;

  public OpenStaffRecordActivity(Container frame) {
    this.frame = frame;
    putValue(NAME, "Open Record");
    putValue(SHORT_DESCRIPTION, "Open the selected staff record for editing");
    setEnabled(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }

}
