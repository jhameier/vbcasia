package org.vbc4me.awanna.gui.forms.season;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class SeasonDisplayForm extends JPanel {
	private static final long serialVersionUID = 8042688560259906107L;
	
	public static JLabel lblSessionStartDate;
	public static JLabel lblSessionEndDate;
	public static JLabel lblNoOfActivities;
	public static JLabel lblNoOfStudents;
	public static JLabel lblNumberOfStaff;
	public static JLabel lblNoOfStaff;
	
	public SeasonDisplayForm() {
		
		JPanel infoPanel = new JPanel();
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
		infoPanel.add(lblSessionStartDate, "cell 3 2");
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblEndDate, "cell 1 3 2 1,alignx right,aligny center");
		
		lblSessionEndDate = new JLabel("");
		lblSessionEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblSessionEndDate, "cell 3 3");
		
		JLabel lblNumberOfActivities = new JLabel("Number of Activities:");
		lblNumberOfActivities.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblNumberOfActivities, "cell 1 4 2 1,alignx right,aligny center");
		
		lblNoOfActivities = new JLabel("");
		infoPanel.add(lblNoOfActivities, "cell 3 4");
		
		JLabel lblNumberOfStudents = new JLabel("Number of Students:");
		infoPanel.add(lblNumberOfStudents, "cell 1 5 2 1,alignx right,aligny center");
		
		lblNoOfStudents = new JLabel("");
		infoPanel.add(lblNoOfStudents, "cell 3 5");
		
		lblNumberOfStaff = new JLabel("Number of Staff:");
		infoPanel.add(lblNumberOfStaff, "cell 1 6 2 1,alignx right,aligny center");
		
		lblNoOfStaff = new JLabel("");
		infoPanel.add(lblNoOfStaff, "cell 3 6");
		
	}
	
}
