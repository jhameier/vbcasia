package org.vbc4me.awanna.gui.actions.activity;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.activity.ActivityDisplayForm;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2016.
 */
public class NewActivityRecordAction extends AbstractAction {
	private static final long serialVersionUID = 2304831696421418774L;
	
	public NewActivityRecordAction() {
		putValue(NAME, "New Activity");
		putValue(SHORT_DESCRIPTION, "Creates new blank activity record ");
	}
	
	/**
	 * Performs the necessary action to display the Activities button and
	 * display panels
	 */
	public void actionPerformed(ActionEvent e) {
		PrimaryGuiPanel.changeButtonLayout(PrimaryGuiPanel.ACTIVITY);
		PrimaryGuiPanel.displayPanel().updateUpperDisplay(new ActivityDisplayForm());
	}
}