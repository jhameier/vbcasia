package org.vbc4me.awanna.gui.forms.season;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.forms.season.actions.CloseSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.CreateSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.NewSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.OpenSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.SaveAsSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.SaveSeasonAction;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public final class SeasonButtonPanel extends JPanel {
    private static final long serialVersionUID = -4124279123949931880L;
    public CloseSeasonAction closeAction;
    public CreateSeasonAction createAction;
    public NewSeasonAction newAction;
    public OpenSeasonAction openAction;
    public SaveAsSeasonAction saveAsAction;
    public SaveSeasonAction saveAction;

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