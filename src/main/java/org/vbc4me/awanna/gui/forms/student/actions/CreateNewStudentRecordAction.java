package org.vbc4me.awanna.gui.forms.student.actions;

import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.student.RecordButtonPanel;
import org.vbc4me.awanna.gui.forms.student.StudentEditForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public final class CreateNewStudentRecordAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public CreateNewStudentRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "New Record");
    putValue(SHORT_DESCRIPTION, "Creates new blank information record ");
    setEnabled(true);
  }

  public void actionPerformed(ActionEvent e) {
    AppGui.displayPanel().updateRightDisplay(new StudentEditForm(), new RecordButtonPanel());
  }
}