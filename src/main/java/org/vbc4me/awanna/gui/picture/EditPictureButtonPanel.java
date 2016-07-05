package org.vbc4me.awanna.gui.picture;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import org.vbc4me.awanna.gui.picture.PictureEditPanel.EditActionListener;

import net.miginfocom.swing.MigLayout;

public class EditPictureButtonPanel extends JPanel{
	private static final long serialVersionUID = 8369053030542399183L;

	public EditPictureButtonPanel(EditActionListener editListener) {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		add(panel);
		panel.setLayout(new MigLayout("", "[79px][75px]", "[30px][30px][30px]"));
		
		JButton btnExpand = new JButton("Expand +");
		btnExpand.setActionCommand(editListener.EXPAND);
		btnExpand.addActionListener(editListener);
		panel.add(btnExpand, "flowy,cell 0 0,growx,aligny center");
		
		JButton btnReduce = new JButton("Reduce -");
		btnReduce.setActionCommand(editListener.REDUCE);
		btnReduce.addActionListener(editListener);
		panel.add(btnReduce, "flowy,cell 1 0,growx,aligny center");
		
		JButton btnRotateCw = new JButton("Rotate CW");
		btnRotateCw.setActionCommand(editListener.CLOCKWISE);
		btnRotateCw.addActionListener(editListener);
		panel.add(btnRotateCw, "cell 0 2,growx,aligny center");
		
		JButton btnRotateCcw = new JButton("Rotate CCW");
		btnRotateCcw.setActionCommand(editListener.COUNTER_CLOCKWISE);
		btnRotateCcw.addActionListener(editListener);
		panel.add(btnRotateCcw, "cell 1 2,growx,aligny center");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, "cell 0 1 2 1,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		add(panel_1);
		panel_1.setLayout(new MigLayout("", "[50px][50px][50px][50px]", "[30px][30px][30px]"));
		
		JButton btnShiftUp = new JButton("Shift Up");
		btnShiftUp.setActionCommand(editListener.UP);
		btnShiftUp.addActionListener(editListener);
		panel_1.add(btnShiftUp, "cell 1 0 2 1,growx");
		
		JButton btnShiftLeft = new JButton("Shift Left");
		btnShiftLeft.setActionCommand(editListener.LEFT);
		btnShiftLeft.addActionListener(editListener);
		panel_1.add(btnShiftLeft, "cell 0 1 2 1,growx");
		
		JButton btnShiftRight = new JButton("Shift Right");
		btnShiftRight.setActionCommand(editListener.RIGHT);
		btnShiftRight.addActionListener(editListener);
		panel_1.add(btnShiftRight, "cell 2 1 2 1,growx");
		
		JButton btnShiftDown = new JButton("Shift Down");
		btnShiftDown.setActionCommand(editListener.DOWN);
		btnShiftDown.addActionListener(editListener);
		panel_1.add(btnShiftDown, "cell 1 2 2 1,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		add(panel_2);
		panel_2.setLayout(new MigLayout("", "[89px]", "[30px][30px][30px]"));
		
		JButton btnSave = new JButton("Save Image");
		btnSave.setActionCommand(editListener.SAVE);
		btnSave.addActionListener(editListener);
		panel_2.add(btnSave, "cell 0 0,growx,aligny center");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setActionCommand(editListener.CANCEL);
		btnCancel.addActionListener(editListener);
		panel_2.add(btnCancel, "cell 0 1,growx,aligny center");	
	}
	
}
