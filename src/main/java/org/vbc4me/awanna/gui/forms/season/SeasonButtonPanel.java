package org.vbc4me.awanna.gui.forms.season;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.forms.season.actions.CloseSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.CreateSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.NewSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.OpenSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.SaveAsSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.SaveSeasonAction;

import net.miginfocom.swing.MigLayout;

public class SeasonButtonPanel extends JPanel {
	private static final long serialVersionUID = -8327426526043278048L;
	private final JButton btnCreate;
	private final Action createSeasonAction;
	
	public SeasonButtonPanel() {
		setLayout(new MigLayout("", "[50px][50px][50px][50px][50px][50px]", "[23px][]"));
		
		JButton btnNew = new JButton("New");
		final Action createNewSeasonAction = new NewSeasonAction(this);
		btnNew.setAction(createNewSeasonAction);
		add(btnNew, "cell 0 0 2 1,growx,aligny center");
		
		JButton btnOpen = new JButton("Open");
		final Action openSeasonAction = new OpenSeasonAction(this);
		btnOpen.setAction(openSeasonAction);
		add(btnOpen, "cell 2 0 2 1,growx,aligny center");
		
		JButton btnSave = new JButton("Save");
		final Action saveSeasonAction = new SaveSeasonAction(this);
		btnSave.setAction(saveSeasonAction);
		add(btnSave, "cell 0 1 2 1,growx,aligny center");
		
		JButton btnClose = new JButton("Close");
		final CloseSeasonAction closeSeasonAction = new CloseSeasonAction(this);
		btnClose.setAction(closeSeasonAction);
		add(btnClose, "cell 4 0 2 1,growx,aligny center");
		
		JButton btnCopy = new JButton("SaveAs");
		final Action copySeasonAction = new SaveAsSeasonAction(this);
		btnCopy.setAction(copySeasonAction);
		add(btnCopy, "cell 2 1 2 1,growx,aligny center");
		
		btnCreate = new JButton("Create");
		createSeasonAction = new CreateSeasonAction(this);
		btnCreate.setAction(createSeasonAction);
		createSeasonAction.setEnabled(false);
		add(btnCreate, "cell 4 1 2 1,growx,aligny center");
	}

	/**
	 * Enable or disable the create button action. True enables the action and button false disables.
	 */
	public void enableCreate(boolean enabled) {
		createSeasonAction.setEnabled(enabled);
	}
}