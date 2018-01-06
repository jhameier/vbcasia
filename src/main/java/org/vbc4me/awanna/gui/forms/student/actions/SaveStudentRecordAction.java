package org.vbc4me.awanna.gui.forms.student.actions;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.student.StudentEditForm;

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
    JPanel panel = AppGui.displayPanel().lowerLeftPanel();
    if (!(panel instanceof StudentEditForm)) {
      throw new IllegalArgumentException("The returned panel is not a student edit form.");
    }
    Student student = ((StudentEditForm) panel).createStudent();
    AppGui.currentSeason().students().put(student.lastName(), student);
  }
}