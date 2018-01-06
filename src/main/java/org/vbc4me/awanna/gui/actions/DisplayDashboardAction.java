package org.vbc4me.awanna.gui.actions;

import org.vbc4me.awanna.gui.AppGui;

import javax.swing.AbstractAction;
import java.awt.Container;
import java.awt.event.ActionEvent;

public final class DisplayDashboardAction extends AbstractAction {

  private static final long serialVersionUID = -1288201101615570596L;
  private Container frame;

  public DisplayDashboardAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Season Dashboard");
    putValue(SHORT_DESCRIPTION, "Displays Information about the current season");
  }

  public void actionPerformed(ActionEvent e) {
    AppGui.displayDashboard();
  }
}