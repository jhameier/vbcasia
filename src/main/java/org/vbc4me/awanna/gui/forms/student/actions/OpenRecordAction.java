package org.vbc4me.awanna.gui.forms.student.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public class OpenRecordAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JFrame frame;

    public OpenRecordAction(JFrame frame) {
        this.frame = frame;
        putValue(NAME, "Open Record");
        putValue(SHORT_DESCRIPTION, "Opens an existing Record.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Open Record Action";
        String title = "Open Existing Record";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}