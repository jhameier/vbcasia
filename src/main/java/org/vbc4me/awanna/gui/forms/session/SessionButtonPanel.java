package org.vbc4me.awanna.gui.forms.session;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.forms.session.actions.NewSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.OpenSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveAsSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveSessionAction;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SessionButtonPanel extends JPanel {

  public final static NewSessionAction newAction = new NewSessionAction(null);
  public final static OpenSessionAction openAction = new OpenSessionAction(null);
  public final static SaveSessionAction saveAction = new SaveSessionAction(null);
  public final static SaveAsSessionAction saveAsAction = new SaveAsSessionAction(null);
  private static final long serialVersionUID = -169212683318427227L;
  private final Container frame;

  public SessionButtonPanel(Container frame) {
    this.frame = frame;
    setBorder(new LineBorder(new Color(0, 0, 0)));
    setLayout(new MigLayout("", "[50px][50px][50px][50px]", "[23px][][]"));

    JButton btnNew = new JButton(newAction);
    btnNew.setText("Create Session");
    add(btnNew, "cell 0 0 2 1,growx,aligny center");

    JButton btnOpen = new JButton(openAction);
    add(btnOpen, "cell 2 0 2 1,growx,aligny center");

    JButton btnSave = new JButton(saveAction);
    add(btnSave, "cell 0 1 2 1,growx,aligny center");

    JButton btnSaveAs = new JButton(saveAsAction);
    add(btnSaveAs, "cell 2 1 2 1,growx,aligny center");
  }
}