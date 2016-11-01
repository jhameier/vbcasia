package org.vbc4me.awanna.gui.forms.season;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import java.time.LocalDate;

public class SeasonEditForm extends JPanel {
	private static final long serialVersionUID = -6531861712233753720L;

    private DatePicker startdatePicker;
	private DatePicker enddatePicker;
    private JTextField nameField;

	public SeasonEditForm() {

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][]"));
		add(infoPanel);
		
		JLabel lblSeason = new JLabel("Season");
		lblSeason.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblSeason, "cell 0 0,alignx right,aligny center");
		
		JLabel lblSession = new JLabel("Session:");
		lblSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoPanel.add(lblSession, "cell 1 1,alignx right,aligny center");

        JLabel lblName = new JLabel("Name:");
		infoPanel.add(lblName, "cell 2 1,alignx trailing,aligny center");

		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameField.setColumns(10);
        nameField.setSize(nameField.getWidth(), 25);
		LocalDate date = LocalDate.now();
		String name = "Awanna Season " + date.getYear();
		nameField.setText(name);
		infoPanel.add(nameField, "cell 3 1,growx");
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblStartDate, "cell 1 2 2 1,alignx right,aligny center");

        JLabel lblSessionStartDate = new JLabel("");
		lblSessionStartDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblSessionStartDate, "flowx,cell 3 2");
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblEndDate, "cell 1 3 2 1,alignx right,aligny center");

        JLabel lblSessionEndDate = new JLabel("");
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
                    enddatePicker.setDate(startdatePicker.getDate().plusMonths(9));
                    SeasonButtonPanel.createAction.setEnabled(true);
                } else {
                    enddatePicker.clear();
					SeasonButtonPanel.createAction.setEnabled(true);
                }
            }
        });
		infoPanel.add(startdatePicker, "cell 3 2");
		
		enddatePicker = new DatePicker();
		infoPanel.add(enddatePicker, "cell 3 3");

        JLabel lblNoOfActivities = new JLabel("");
		infoPanel.add(lblNoOfActivities, "flowx,cell 3 4");
		
		JLabel lblNumberOfStudents = new JLabel("Number of Students:");
		infoPanel.add(lblNumberOfStudents, "cell 1 5 2 1,alignx right,aligny center");

        JLabel lblNoOfStudents = new JLabel("");
		infoPanel.add(lblNoOfStudents, "flowx,cell 3 5");

        JLabel lblNumberOfStaff = new JLabel("Number of Staff:");
		infoPanel.add(lblNumberOfStaff, "cell 1 6 2 1,alignx right,aligny center");

        JLabel lblNoOfStaff = new JLabel("");
		infoPanel.add(lblNoOfStaff, "flowx,cell 3 6");

        JLabel lblDisplayNumberActivities = new JLabel("");
		infoPanel.add(lblDisplayNumberActivities, "cell 3 4");

        JLabel lblDisplayNumberStudents = new JLabel("");
		infoPanel.add(lblDisplayNumberStudents, "cell 3 5");

        JLabel lblDisplayNumberStaff = new JLabel("");
		infoPanel.add(lblDisplayNumberStaff, "cell 3 6");
	}

	public LocalDate startDate() {
        return startdatePicker.getDate();
    }

    public LocalDate endDate() {
        return enddatePicker.getDate();
    }

}
