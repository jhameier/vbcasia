package org.vbc4me.awanna.gui.forms.season;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DashboardButtonPanel extends JPanel {
	private static final long serialVersionUID = -3094138577322028959L;
	public DashboardButtonPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new MigLayout("", "[218.00px]", "[29px][29px][29px]"));
		
		JPanel panelActivity = new JPanel();
		panelActivity.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelActivity.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(panelActivity, "cell 0 0,alignx left,aligny center");
		panelActivity.setLayout(new MigLayout("", "[50px:n,center][75px:n,center][75px:n,center]", "[23px]"));
		
		JLabel lblActivity = new JLabel("Activity");
		panelActivity.add(lblActivity, "cell 0 0,alignx right,aligny center");
		
		JButton btnActivityCreate = new JButton("Create");
		panelActivity.add(btnActivityCreate, "cell 1 0,growx,aligny center");
		
		JButton btnActivityOpen = new JButton("Open");
		panelActivity.add(btnActivityOpen, "cell 2 0,growx,aligny center");
		
		/* ********************************************************************** */
		JPanel panelStudent = new JPanel();
		panelStudent.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelStudent.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(panelStudent, "cell 0 1,alignx left,aligny center");
		panelStudent.setLayout(new MigLayout("", "[50px:n,center][75px:n,center][75px:n,center]", "[23px]"));
		
		JLabel lblStudent = new JLabel("Student");
		panelStudent.add(lblStudent, "cell 0 0,alignx right,aligny center");
		
		JButton btnStudentCreate = new JButton("Create");
		panelStudent.add(btnStudentCreate, "cell 1 0,growx,aligny center");
		
		JButton btnStudentOpen = new JButton("Open");
		panelStudent.add(btnStudentOpen, "cell 2 0,growx,aligny center");
		
		/* ********************************************************************** */
		
		JPanel panelStaff = new JPanel();
		panelStaff.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelStaff.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(panelStaff, "cell 0 2,growx,aligny center");
		panelStaff.setLayout(new MigLayout("", "[50px:n,center][75px:n,center][75px:n,center]", "[23px]"));
		
		JLabel lblStaff = new JLabel("Staff");
		panelStaff.add(lblStaff, "cell 0 0,alignx right,aligny center");
		
		JButton btnStaffCreate = new JButton("Create");
		panelStaff.add(btnStaffCreate, "cell 1 0,growx,aligny center");
		
		JButton btnStaffOpen = new JButton("Open");
		panelStaff.add(btnStaffOpen, "cell 2 0,growx,aligny center");
	}
	
}
