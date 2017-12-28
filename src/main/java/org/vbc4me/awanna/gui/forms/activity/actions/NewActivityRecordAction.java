package org.vbc4me.awanna.gui.forms.activity.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.activity.ActivityButtonPanel;
import org.vbc4me.awanna.gui.forms.activity.ActivityDisplayForm;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2016.
 */
public class NewActivityRecordAction extends AbstractAction {

  private static final long serialVersionUID = 2304831696421418774L;
  private JPanel panel;

  public NewActivityRecordAction(JPanel panel) {
    this.panel = panel;
    putValue(NAME, "New Activity");
    putValue(SHORT_DESCRIPTION, "Creates new blank actions record ");
  }

  /**
   * Performs the necessary action to display the Activities button and display panels
   */
  public void actionPerformed(ActionEvent e) {
    AppGui.displayPanel().updateUpperDisplay(new ActivityDisplayForm(panel), new ActivityButtonPanel());
  }
}