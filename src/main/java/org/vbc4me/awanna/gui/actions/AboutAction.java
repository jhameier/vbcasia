package org.vbc4me.awanna.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class AboutAction extends AbstractAction {
	private static final long serialVersionUID = -1288201101615570596L;
	private JFrame frame;

	public AboutAction(JFrame frame) {
		this.frame = frame;
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "Displays Information about this Application");
	}

	public void actionPerformed(ActionEvent e) {
		String message = "This application was created with God's Children in Mind. \n\n"
				+ "All Rights Reserved John Hameier 2015 \n"
				+ "john@hameier.net";
		String title = "About This App";
		int messageType = JOptionPane.INFORMATION_MESSAGE;
		JOptionPane.showMessageDialog(frame, message, title, messageType);
	}
}