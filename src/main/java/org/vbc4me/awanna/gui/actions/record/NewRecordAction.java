package org.vbc4me.awanna.gui.actions.record;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.DisplayPanel;
import org.vbc4me.awanna.gui.forms.student.StudentInputForm;


/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class NewRecordAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
//  private JFrame frame;

  public NewRecordAction(JFrame frame) {
//    this.frame = frame;
    putValue(NAME, "New Record");
    putValue(SHORT_DESCRIPTION, "Creates new blank information record ");
  }

  public void actionPerformed(ActionEvent e) {
//    String message = "This is activated from New Record Action";
//    String title = "New Record";
//    int messageType = JOptionPane.INFORMATION_MESSAGE;
//    JOptionPane.showMessageDialog(frame, message, title, messageType);
    PrimaryGuiPanel.changeButtonLayout(PrimaryGuiPanel.RECORD);
    DisplayPanel.updateUpperPanel(new StudentInputForm());
  }
}