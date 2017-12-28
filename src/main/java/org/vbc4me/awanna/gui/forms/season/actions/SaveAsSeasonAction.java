package org.vbc4me.awanna.gui.forms.season.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Used to copy an existing SeasonContainer.
 *
 * @author John Hameier: June 2016.
 */
public final class SaveAsSeasonAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;

    public SaveAsSeasonAction() {
        putValue(NAME, "SaveAs Season");
        putValue(SHORT_DESCRIPTION, "Saves the currently open Season with a new name.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from SaveAs Season Action";
        String title = "SaveAs Season";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(null, message, title, messageType);


    }
}