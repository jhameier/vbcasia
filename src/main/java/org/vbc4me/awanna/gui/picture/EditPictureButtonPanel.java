package org.vbc4me.awanna.gui.picture;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class EditPictureButtonPanel extends JPanel {
    private static final long serialVersionUID = 8369053030542399183L;

    public EditPictureButtonPanel(EditActionListener editActionListener) {

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        add(panel);
        panel.setLayout(new MigLayout("", "[79px][75px]", "[30px][30px][30px]"));

        JButton btnExpand = new JButton("Expand +");
        btnExpand.setActionCommand(editActionListener.EXPAND);
        btnExpand.addActionListener(editActionListener);
        panel.add(btnExpand, "flowy,cell 0 0,growx,aligny center");

        JButton btnReduce = new JButton("Reduce -");
        btnReduce.setActionCommand(editActionListener.REDUCE);
        btnReduce.addActionListener(editActionListener);
        panel.add(btnReduce, "flowy,cell 1 0,growx,aligny center");

        JButton btnRotateCw = new JButton("Rotate CW");
        btnRotateCw.setActionCommand(editActionListener.CLOCKWISE);
        btnRotateCw.addActionListener(editActionListener);
        panel.add(btnRotateCw, "cell 0 2,growx,aligny center");

        JButton btnRotateCcw = new JButton("Rotate CCW");
        btnRotateCcw.setActionCommand(editActionListener.COUNTER_CLOCKWISE);
        btnRotateCcw.addActionListener(editActionListener);
        panel.add(btnRotateCcw, "cell 1 2,growx,aligny center");

        Component verticalStrut = Box.createVerticalStrut(20);
        panel.add(verticalStrut, "cell 0 1 2 1,grow");

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        add(panel_1);
        panel_1.setLayout(new MigLayout("", "[50px][50px][50px][50px]", "[30px][30px][30px]"));

        JButton btnShiftUp = new JButton("Shift Up");
        btnShiftUp.setActionCommand(editActionListener.UP);
        btnShiftUp.addActionListener(editActionListener);
        panel_1.add(btnShiftUp, "cell 1 0 2 1,growx");

        JButton btnShiftLeft = new JButton("Shift Left");
        btnShiftLeft.setActionCommand(editActionListener.LEFT);
        btnShiftLeft.addActionListener(editActionListener);
        panel_1.add(btnShiftLeft, "cell 0 1 2 1,growx");

        JButton btnShiftRight = new JButton("Shift Right");
        btnShiftRight.setActionCommand(editActionListener.RIGHT);
        btnShiftRight.addActionListener(editActionListener);
        panel_1.add(btnShiftRight, "cell 2 1 2 1,growx");

        JButton btnShiftDown = new JButton("Shift Down");
        btnShiftDown.setActionCommand(editActionListener.DOWN);
        btnShiftDown.addActionListener(editActionListener);
        panel_1.add(btnShiftDown, "cell 1 2 2 1,growx");

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        add(panel_2);
        panel_2.setLayout(new MigLayout("", "[89px]", "[30px][30px][30px]"));

        JButton btnSave = new JButton("Save Image");
        btnSave.setActionCommand(editActionListener.SAVE);
        btnSave.addActionListener(editActionListener);
        panel_2.add(btnSave, "cell 0 0,growx,aligny center");

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setActionCommand(editActionListener.CANCEL);
        btnCancel.addActionListener(editActionListener);
        panel_2.add(btnCancel, "cell 0 1,growx,aligny center");
    }

}
