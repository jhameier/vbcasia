package org.vbc4me.awanna.gui.forms.season;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.actions.season.CloseSeasonAction;
import org.vbc4me.awanna.gui.actions.season.CopySeasonAction;
import org.vbc4me.awanna.gui.actions.season.NewSeasonAction;
import org.vbc4me.awanna.gui.actions.season.OpenSeasonAction;
import org.vbc4me.awanna.gui.actions.season.SaveSeasonAction;

public class SeasonButtonPanel extends JPanel {
	private static final long serialVersionUID = -8327426526043278048L;
	private JFrame frame;
	private final Action openSeasonAction = new OpenSeasonAction(frame);
	private final Action createNewSeasonAction = new NewSeasonAction(frame);
	private final Action copySeasonAction = new CopySeasonAction(frame);
	private final Action saveSeasonAction = new SaveSeasonAction(frame);
	private final Action closeSeasonAction = new CloseSeasonAction(frame);
	
	public SeasonButtonPanel(JFrame frame) {
		this.frame = frame;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(1);
		add(horizontalStrut);
		
		JButton btnNew = new JButton("New");
		btnNew.setAction(createNewSeasonAction);
		add(btnNew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		add(horizontalStrut_1);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setAction(openSeasonAction);
		add(btnOpen);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		add(horizontalStrut_2);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setAction(copySeasonAction);
		add(btnCopy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		add(horizontalStrut_3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setAction(saveSeasonAction);
		add(btnSave);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		add(horizontalStrut_4);
		
		JButton btnClose = new JButton("Close");
		btnClose.setAction(closeSeasonAction);
		add(btnClose);
	}
}