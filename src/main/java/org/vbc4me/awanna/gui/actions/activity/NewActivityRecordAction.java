package org.vbc4me.awanna.gui.actions.activity;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.ActivityDisplayForm;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2016.
 */
public class NewActivityRecordAction extends AbstractAction {
	private static final long serialVersionUID = 2304831696421418774L;
	private JFrame frame;
	
	public NewActivityRecordAction(JFrame frame) {
		this.frame = frame;
		putValue(NAME, "New Activity");
		putValue(SHORT_DESCRIPTION, "Creates new blank activity record ");
	}
	
	/**
	 * Returns the frame associated with this action
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Performs the necessary action to display the Activities button and
	 * display panels
	 */
	public void actionPerformed(ActionEvent e) {
		PrimaryGuiPanel.changeButtonLayout(PrimaryGuiPanel.ACTIVITY);
		PrimaryGuiPanel.displayPanel().setDisplayPanel(new ActivityDisplayForm());
	}
}