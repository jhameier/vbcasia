package org.vbc4me.awanna.gui.forms.session.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public final class NewSessionAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JPanel panel;

    public NewSessionAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "New Session");
        putValue(SHORT_DESCRIPTION, "Creates new blank Session.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from New Session Action";
        String title = "Create New Session";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}