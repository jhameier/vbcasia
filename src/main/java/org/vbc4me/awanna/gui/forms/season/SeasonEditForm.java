package org.vbc4me.awanna.gui.forms.season;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import org.vbc4me.awanna.gui.forms.DisplayPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class SeasonEditForm extends JPanel {
	private static final long serialVersionUID = -6531861712233753720L;
	public JPanel infoPanel;
	public DisplayPanel tablePanel;
	
	public JLabel lblSessionStartDate;
	public JLabel lblSessionEndDate;
	public JLabel lblNoOfActivities;
	public JLabel lblNoOfStudents;
	public JLabel lblNumberOfStaff;
	public JLabel lblNoOfStaff;
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private JLabel lblDisplayNumberActivities;
	private JLabel lblDisplayNumberStudents;
	private JLabel lblDisplayNumberStaff;
	
	public SeasonEditForm() {
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new MigLayout("", "[][][][]", "[][][][][][][]"));
		add(infoPanel);
		
		JLabel lblSeason = new JLabel("Season");
		lblSeason.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblSeason, "cell 0 0,alignx right,aligny center");
		
		JLabel lblSession = new JLabel("Session:");
		lblSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoPanel.add(lblSession, "cell 1 1,alignx right,aligny center");
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblStartDate, "cell 1 2 2 1,alignx right,aligny center");
		
		lblSessionStartDate = new JLabel("");
		lblSessionStartDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblSessionStartDate, "flowx,cell 3 2");
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblEndDate, "cell 1 3 2 1,alignx right,aligny center");
		
		lblSessionEndDate = new JLabel("");
		lblSessionEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblSessionEndDate, "flowx,cell 3 3");
		
		JLabel lblNumberOfActivities = new JLabel("Number of Activities:");
		lblNumberOfActivities.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblNumberOfActivities, "cell 1 4 2 1,alignx right,aligny center");
		
		lblNoOfActivities = new JLabel("");
		infoPanel.add(lblNoOfActivities, "flowx,cell 3 4");
		
		JLabel lblNumberOfStudents = new JLabel("Number of Students:");
		infoPanel.add(lblNumberOfStudents, "cell 1 5 2 1,alignx right,aligny center");
		
		lblNoOfStudents = new JLabel("");
		infoPanel.add(lblNoOfStudents, "flowx,cell 3 5");
		
		lblNumberOfStaff = new JLabel("Number of Staff:");
		infoPanel.add(lblNumberOfStaff, "cell 1 6 2 1,alignx right,aligny center");
		
		lblNoOfStaff = new JLabel("");
		infoPanel.add(lblNoOfStaff, "flowx,cell 3 6");
		
		tablePanel = new DisplayPanel();
		add(infoPanel);
		
		txtStartDate = new JTextField();
		infoPanel.add(txtStartDate, "cell 3 2");
		txtStartDate.setColumns(10);
		
		txtEndDate = new JTextField();
		infoPanel.add(txtEndDate, "cell 3 3,aligny top");
		txtEndDate.setColumns(10);
		
		lblDisplayNumberActivities = new JLabel("");
		infoPanel.add(lblDisplayNumberActivities, "cell 3 4");
		
		lblDisplayNumberStudents = new JLabel("");
		infoPanel.add(lblDisplayNumberStudents, "cell 3 5");
		
		lblDisplayNumberStaff = new JLabel("");
		infoPanel.add(lblDisplayNumberStaff, "cell 3 6");
	}
	
}
