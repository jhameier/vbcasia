package org.vbc4me.awanna.gui.actions.season;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to create a new blank season record.
 *
 * @author John Hameier: June 2015.
 */
public class OpenSeasonAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JFrame frame;

  public OpenSeasonAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "Open Season");
    putValue(SHORT_DESCRIPTION, "Opens an existing Season.");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Open Season Action";
    String title = "Open Existing Season";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }
}