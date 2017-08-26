package org.vbc4me.awanna.gui.forms.student.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Action Class for Buttons and Menu Items
 */
public final class EditStudentRecordAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JPanel panel;

    public EditStudentRecordAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "Edit Record");
        putValue(SHORT_DESCRIPTION, "Edits the currently loaded record information ");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Edit Record Action";
        String title = "Edit Record";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}