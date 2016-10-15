package org.vbc4me.awanna.gui.forms.season;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import net.miginfocom.swing.MigLayout;

public class SeasonEditForm extends JPanel {
	private static final long serialVersionUID = -6531861712233753720L;

	
	public JLabel lblSessionStartDate;
	public JLabel lblSessionEndDate;
	public JLabel lblNoOfActivities;
	public JLabel lblNoOfStudents;
	public JLabel lblNumberOfStaff;
	public JLabel lblNoOfStaff;
	private JLabel lblDisplayNumberActivities;
	private JLabel lblDisplayNumberStudents;
	private JLabel lblDisplayNumberStaff;
	private DatePicker startdatePicker;
	private DatePicker enddatePicker;
	
	public SeasonEditForm() {
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][]"));
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
		
		startdatePicker = new DatePicker();
        startdatePicker.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent event) {
                if (event.getNewDate() != null) {
                    enddatePicker.setDate(startdatePicker.getDate().plusWeeks(24));
                } else {
                    enddatePicker.clear();
                }
            }
        });
		infoPanel.add(startdatePicker, "cell 3 2");
		
		enddatePicker = new DatePicker();
		infoPanel.add(enddatePicker, "cell 3 3");

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
		
		lblDisplayNumberActivities = new JLabel("");
		infoPanel.add(lblDisplayNumberActivities, "cell 3 4");
		
		lblDisplayNumberStudents = new JLabel("");
		infoPanel.add(lblDisplayNumberStudents, "cell 3 5");
		
		lblDisplayNumberStaff = new JLabel("");
		infoPanel.add(lblDisplayNumberStaff, "cell 3 6");
		
	}
	
}
