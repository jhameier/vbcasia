package org.vbc4me.awanna.gui.forms.season;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.forms.season.actions.*;
import javax.swing.border.LineBorder;
import java.awt.Color;

public final class SeasonButtonPanel extends JPanel {
	private static final long serialVersionUID = -8327426526043278048L;
    public static CloseSeasonAction closeAction;
    public static CreateSeasonAction createAction;
    public static NewSeasonAction newAction;
    public static OpenSeasonAction openAction;
    public static SaveAsSeasonAction saveAsAction;
    public static SaveSeasonAction saveAction;

    public SeasonButtonPanel() {
    	setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new MigLayout("", "[50px][50px][50px][50px]", "[23px][][]"));
		
		createAction = new CreateSeasonAction();
        JButton btnCreate = new JButton(createAction);
		add(btnCreate, "cell 0 0 2 1,growx,aligny center");

		openAction = new OpenSeasonAction();
        JButton btnOpen = new JButton(openAction);
		add(btnOpen, "cell 2 0 2 1,growx,aligny center");
		
		saveAction = new SaveSeasonAction();
        JButton btnSave = new JButton(saveAction);
		add(btnSave, "cell 0 1 2 1,growx,aligny center");
        
		saveAsAction = new SaveAsSeasonAction();
        JButton btnSaveAs = new JButton(saveAsAction);
		add(btnSaveAs, "cell 2 1 2 1,growx,aligny center");
		
		closeAction = new CloseSeasonAction();
		JButton btnClose = new JButton(closeAction);
		add(btnClose, "cell 1 2 2 1,growx,aligny center");
		
		newAction = new NewSeasonAction();
	}

}