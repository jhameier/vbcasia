package org.vbc4me.awanna.gui.actions.season;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to save a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class SaveSeasonAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JFrame frame;

  public SaveSeasonAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "Save Season");
    putValue(SHORT_DESCRIPTION, "Saves the currently Open Season.");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Save Season Action";
    String title = "Save Currently Open Season";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}