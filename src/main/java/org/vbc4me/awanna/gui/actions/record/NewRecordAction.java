package org.vbc4me.awanna.gui.actions.record;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.student.RecordButtonPanel;
import org.vbc4me.awanna.gui.forms.student.StudentInputForm;


/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class NewRecordAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JPanel panel;

  public NewRecordAction(JPanel panel) {
    putValue(NAME, "New Record");
    putValue(SHORT_DESCRIPTION, "Creates new blank information record ");
  }

  public void actionPerformed(ActionEvent e) {
    PrimaryGuiPanel.displayPanel().updateUpperDisplay(new StudentInputForm(), new RecordButtonPanel());
  }
}