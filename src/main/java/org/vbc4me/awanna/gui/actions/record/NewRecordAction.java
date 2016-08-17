package org.vbc4me.awanna.gui.actions.record;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.student.StudentInputForm;


/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class NewRecordAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;

  public NewRecordAction(JFrame frame) {
    putValue(NAME, "New Record");
    putValue(SHORT_DESCRIPTION, "Creates new blank information record ");
  }

  public void actionPerformed(ActionEvent e) {
    PrimaryGuiPanel.changeButtonLayout(PrimaryGuiPanel.RECORD);
    PrimaryGuiPanel.displayPanel().updateUpperDisplay(new StudentInputForm());
  }
}