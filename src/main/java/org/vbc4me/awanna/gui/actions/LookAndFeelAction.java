package org.vbc4me.awanna.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public final class LookAndFeelAction extends AbstractAction {
  private static final long serialVersionUID = -1288201101615570596L;
  private JFrame frame;

  public LookAndFeelAction(JFrame frame) {
    this.frame = frame;
    putValue(NAME, "Look and Feel");
    putValue(SHORT_DESCRIPTION, "Changes the windows appearance");
  }

  public void actionPerformed(ActionEvent e) {
    LookAndFeelInit(e.getActionCommand());
  }

  /**
   * Set the look and feel windowing theme
   *
   * @param name of look and feel to change to
   */
  private void LookAndFeelInit(String name) {
    try {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if (name.equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          SwingUtilities.updateComponentTreeUI(frame);
          frame.pack();
          break;
        }
      }
    } catch (Exception e) {
      try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }

  }
}