package org.vbc4me.awanna.gui.forms.season.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * A set of steps used to close an opened Season
 *
 * @author John Hameier: June 2015.
 */
public final class CloseSeasonAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;

    public CloseSeasonAction() {
        putValue(NAME, "Close Season");
        putValue(SHORT_DESCRIPTION, "Closes an existing Season.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This will close a Season out. Closing a actions cannot be undone!\n\n"
                + "Are you sure you wish to continue?";
        String title = "Close Existing Season Conformation";
        int messageType = JOptionPane.WARNING_MESSAGE;
        int confirmed = JOptionPane.showConfirmDialog(null, message, title, messageType);

        if (confirmed == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Closing Season out.");
        }
    }
}