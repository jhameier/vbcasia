package org.vbc4me.awanna.gui.forms.season;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.facets.Season;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SeasonDisplayForm extends JPanel {

  private static final long serialVersionUID = 8042688560259906107L;
  private static JLabel lblSeasonName;
  private static JLabel lblSessionStartDate;
  private static JLabel lblSessionEndDate;
  private static JLabel lblNoOfActivities;
  private static JLabel lblNoOfStudents;
  private static JLabel lblNoOfStaff;

  public SeasonDisplayForm() {
    setBorder(new LineBorder(new Color(0, 0, 0)));
    setAlignmentX(LEFT_ALIGNMENT);

    JPanel infoPanel = new JPanel();
    infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
    infoPanel.setLayout(new MigLayout("", "[][][][]", "[][][][][][][]"));
    add(infoPanel);

    JLabel lblSeason = new JLabel("Season");
    lblSeason.setFont(new Font("Tahoma", Font.BOLD, 16));
    infoPanel.add(lblSeason, "cell 0 0,alignx right,aligny center");

    JLabel lblSession = new JLabel("Session:");
    lblSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoPanel.add(lblSession, "cell 1 1,alignx right,aligny center");

    lblSeasonName = new JLabel("");
    infoPanel.add(lblSeasonName, "cell 2 1 2 1");

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
    lblNoOfActivities.setFont(new Font("Tahoma", Font.PLAIN, 12));
    infoPanel.add(lblNoOfActivities, "cell 3 4");

    JLabel lblNumberOfStudents = new JLabel("Number of Students:");
    lblNumberOfStudents.setFont(new Font("Tahoma", Font.PLAIN, 12));
    infoPanel.add(lblNumberOfStudents, "cell 1 5 2 1,alignx right,aligny center");

    lblNoOfStudents = new JLabel("");
    lblNoOfStudents.setFont(new Font("Tahoma", Font.PLAIN, 12));
    infoPanel.add(lblNoOfStudents, "cell 3 5");

    JLabel lblNumberOfStaff = new JLabel("Number of Staff:");
    lblNumberOfStaff.setFont(new Font("Tahoma", Font.PLAIN, 12));
    infoPanel.add(lblNumberOfStaff, "cell 1 6 2 1,alignx right,aligny center");

    lblNoOfStaff = new JLabel("");
    lblNoOfStaff.setFont(new Font("Tahoma", Font.PLAIN, 12));
    infoPanel.add(lblNoOfStaff, "cell 3 6");
  }

  public static SeasonDisplayForm createForm(Season season) {
    SeasonDisplayForm form = new SeasonDisplayForm();
    lblSeasonName.setText(season.name());
    lblSessionStartDate.setText(season.session().startDate().toString());
    lblSessionEndDate.setText(season.session().endDate().toString());
    lblNoOfActivities.setText(String.valueOf(season.session().activities().size()));
    lblNoOfStudents.setText(String.valueOf(season.students().size()));
    lblNoOfStaff.setText(String.valueOf(season.staff().size()));
    return form;
  }

}
