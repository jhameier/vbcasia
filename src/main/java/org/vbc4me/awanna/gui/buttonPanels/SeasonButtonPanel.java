package org.vbc4me.awanna.gui.buttonPanels;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.actions.season.NewSeasonAction;
import org.vbc4me.awanna.gui.actions.season.OpenSeasonAction;
import org.vbc4me.awanna.gui.actions.season.SaveSeasonAction;

public class SeasonButtonPanel extends JPanel {
  private static final long serialVersionUID = -169212683318427227L;

  public static JButton btnNew = new JButton("New");
  public static JButton btnOpen = new JButton("Open");
  public static JButton btnSave = new JButton("Save");
  public static JButton btnClose = new JButton("Close");

  public SeasonButtonPanel(PrimaryGuiPanel frame) {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

    Component horizontalStrut = Box.createHorizontalStrut(1);
    add(horizontalStrut);

    Action newSeasonAction = new NewSeasonAction(frame);
    btnNew.setAction(newSeasonAction);
    add(btnNew);

    Component horizontalStrut_1 = Box.createHorizontalStrut(5);
    add(horizontalStrut_1);

    Action openSeasonAction = new OpenSeasonAction(frame);
    btnOpen.setAction(openSeasonAction);
    add(btnOpen);

    Component horizontalStrut_2 = Box.createHorizontalStrut(5);
    add(horizontalStrut_2);

    Action saveSeasonAction = new SaveSeasonAction(frame);
    btnSave.setAction(saveSeasonAction);
    add(btnSave);

    Component horizontalStrut_3 = Box.createHorizontalStrut(5);
    add(horizontalStrut_3);

//    Action closeSeasonAction = new CloseSeasonAction(frame);
//    btnClose.setAction(closeSeasonAction);
    add(btnClose);
  }
}