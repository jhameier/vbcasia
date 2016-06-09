package org.vbc4me.awanna.gui.actions.season;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class CloseSeasonAction extends AbstractAction {
	private static final long serialVersionUID = -6301577011454895115L;
	private JFrame frame;
	
	public CloseSeasonAction(JFrame frame) {
		this.frame = frame;
		putValue(NAME, "Close Season");
		putValue(SHORT_DESCRIPTION, "Closes an existing Season.");
	}
	
	public void actionPerformed(ActionEvent e) {
		String message = "This will close a Season out. Closing a season cannot be undone!\n\n"
				+ "Are you sure you wish to continue?";
		String title = "Close Existing Season Conformation";
		int messageType = JOptionPane.WARNING_MESSAGE;
		int confirmed = JOptionPane.showConfirmDialog(frame, message, title, messageType);
		
		if (confirmed == JOptionPane.OK_OPTION) {
			JOptionPane.showMessageDialog(frame, "Closing Season out.");
		}
	}
}