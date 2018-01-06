package org.vbc4me.awanna.gui.forms.student.actions;

import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.student.StudentTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public final class DisplayAllStudentRecordAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public DisplayAllStudentRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Display All");
    putValue(SHORT_DESCRIPTION, "Displays all Student Record for the current session.");
    setEnabled(true);
  }

  public void actionPerformed(ActionEvent e) {
    StudentTableModel model = new StudentTableModel();
    for (Student student : AppGui.currentSeason().students().values()) {
      model.addData(student);
    }
    AppGui.displayPanel().updateTableDisplay(model);
  }
}