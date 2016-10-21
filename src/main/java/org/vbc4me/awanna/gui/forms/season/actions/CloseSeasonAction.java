package org.vbc4me.awanna.gui.forms.season.actions;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class CloseSeasonAction extends AbstractAction {
	private static final long serialVersionUID = -6301577011454895115L;
	private JPanel panel;
	
	public CloseSeasonAction(JPanel panel) {
		this.panel = panel;
		putValue(NAME, "Close Season");
		putValue(SHORT_DESCRIPTION, "Closes an existing Season.");
		setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		String message = "This will close a Season out. Closing a actions cannot be undone!\n\n"
				+ "Are you sure you wish to continue?";
		String title = "Close Existing Season Conformation";
		int messageType = JOptionPane.WARNING_MESSAGE;
		int confirmed = JOptionPane.showConfirmDialog(panel, message, title, messageType);
		
		if (confirmed == JOptionPane.OK_OPTION) {
			JOptionPane.showMessageDialog(panel, "Closing Season out.");
		}
	}
}