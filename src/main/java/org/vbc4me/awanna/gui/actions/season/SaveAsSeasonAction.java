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
public class SaveAsSeasonAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JFrame frame;

  public SaveAsSeasonAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "SaveAs Season");
    putValue(SHORT_DESCRIPTION, "Saves the currently open Season with a new name.");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from SaveAs Season Action";
    String title = "SaveAs Season";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);


  }
}