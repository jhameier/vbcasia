package org.vbc4me.awanna.gui.forms.season;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.AppGui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public final class SeasonButtonPanel extends JPanel {

  private static final long serialVersionUID = -4124279123949931880L;

  public SeasonButtonPanel() {

    setBorder(new LineBorder(new Color(0, 0, 0)));
    setLayout(new MigLayout("", "[50px][50px][50px][50px]", "[23px][][]"));

    JButton btnCreate = new JButton(AppGui.newSeasonAction());
    add(btnCreate, "cell 0 0 2 1,growx,aligny center");

    JButton btnOpen = new JButton(AppGui.openSeasonAction());
    add(btnOpen, "cell 2 0 2 1,growx,aligny center");

    JButton btnSave = new JButton(AppGui.saveSeasonAction());
    add(btnSave, "cell 0 1 2 1,growx,aligny center");

    JButton btnSaveAs = new JButton(AppGui.saveAsSeasonAction());
    add(btnSaveAs, "cell 2 1 2 1,growx,aligny center");

    JButton btnClose = new JButton(AppGui.closeSeasonAction());
    add(btnClose, "cell 1 2 2 1,growx,aligny center");
  }
}