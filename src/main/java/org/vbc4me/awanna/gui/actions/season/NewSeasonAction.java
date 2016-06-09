package org.vbc4me.awanna.gui.actions.season;

import java.awt.event.ActionEvent;

import javax.swing.*;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;


/**
 * Used to create a new blank Season.
 *
 * @author John Hameier: June 2015.
 */
public class NewSeasonAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JFrame frame;

  public NewSeasonAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "New Season");
    putValue(SHORT_DESCRIPTION, "Create a New Blank Season.");
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from New Season Action";
    String title = "Create New Season";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(frame, message, title, messageType);


  }
}