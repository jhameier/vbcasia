package org.vbc4me.awanna.gui.actions.season;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to copy an existing Season.
 *
 * @author John Hameier: June 2016.
 */
public class CopySeasonAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JFrame frame;

  public CopySeasonAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "Copy Season");
    putValue(SHORT_DESCRIPTION, "Copies an existing Season.");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from Copy Season Action";
    String title = "Copy Season";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);


  }
}