package org.vbc4me.awanna.gui.forms.session.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public final class OpenSessionAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JPanel panel;

    public OpenSessionAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "Open Session");
        putValue(SHORT_DESCRIPTION, "Opens an existing Session.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Open Session Action";
        String title = "Open Existing Session";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}