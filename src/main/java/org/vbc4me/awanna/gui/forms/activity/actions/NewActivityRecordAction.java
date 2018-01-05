package org.vbc4me.awanna.gui.forms.activity.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2016.
 */
public class NewActivityRecordAction extends AbstractAction {

  private static final long serialVersionUID = 2304831696421418774L;
  private Container frame;

  public NewActivityRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "New Activity");
    putValue(SHORT_DESCRIPTION, "Creates new blank actions record ");
  }

  /**
   * Performs the necessary action to display the Activities button and display panels
   */
  public void actionPerformed(ActionEvent e) {

  }
}