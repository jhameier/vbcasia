package org.vbc4me.awanna.gui.actions.session;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CopySessionAction extends AbstractAction {
    private static final long serialVersionUID = 8569314471846162511L;
    private JFrame frame;
    
    public CopySessionAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Copy Session");
	putValue(SHORT_DESCRIPTION, "Copies the currently loaded Session");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Copy Session Action";
	String title = "Copy Session";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}