package org.vbc4me.awanna.gui.forms.season.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.forms.season.SeasonButtonPanel;

/**
 * Used to copy an existing Season.
 *
 * @author John Hameier: June 2016.
 */
public class SaveAsSeasonAction extends AbstractAction {
  private static final long serialVersionUID = -6301577011454895115L;
  private JPanel panel;

  public SaveAsSeasonAction(JPanel panel) {
    this.panel = panel;
    putValue(NAME, "SaveAs Season");
    putValue(SHORT_DESCRIPTION, "Saves the currently open Season with a new name.");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e) {
    String message = "This is activated from SaveAs Season Action";
    String title = "SaveAs Season";
    int messageType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(panel, message, title, messageType);


  }
}