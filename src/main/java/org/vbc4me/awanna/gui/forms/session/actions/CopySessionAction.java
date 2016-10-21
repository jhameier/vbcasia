package org.vbc4me.awanna.gui.forms.session.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class CopySessionAction extends AbstractAction {
    private static final long serialVersionUID = 8569314471846162511L;
    private JPanel frame;

    public CopySessionAction(JPanel frame) {
        this.frame = frame;
        putValue(NAME, "Copy Session");
        putValue(SHORT_DESCRIPTION, "Copies the currently loaded Session");
		setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Copy Session Action";
        String title = "Copy Session";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}