package org.vbc4me.awanna.gui.forms.staff;

import org.vbc4me.awanna.facets.Staff;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StaffTableModel extends AbstractTableModel {

  private static final int LAST_NAME = 0;
  private static final int FIRST_NAME = 1;
  private static final int CLUB_NAME = 2;
  private static final long serialVersionUID = 4272448093197382220L;
  private String[] columnNames;
  private List<Staff> data;

  public StaffTableModel() {
    this.columnNames = new String[]{"Last Name", "First Name", "Club"};
    data = new ArrayList<>();
  }

  public void addData(Staff staff) {
    data.add(staff);
  }

  @Override
  public int getRowCount() {
    return data.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  /**
   * Returns the name of this column
   *
   * @param column number to get name of
   * @return name of the column indexed
   */
  public String getColumnName(int column) {
    return columnNames[column];
  }

  /**
   * Returns if the cell is able to be edited by the user
   *
   * @param row number of the cell
   * @param column number of the cell
   * @return if this cell is able to be edited
   */
  public boolean isCellEditable(int row, int column) {
    return false;
  }

  /**
   * Returns the type of class that is associated with the data in a column
   */
  public Class<?> getColumnClass(int column) {
    switch (column) {
      case 0:
      case 1:
      case 2:
        return String.class;
      default:
        return Object.class;
    }

  }

  @Override
  public Object getValueAt(int row, int column) {
    Staff staff = data.get(row);
    switch (column) {
      case LAST_NAME:
        return staff.lastName();
      case FIRST_NAME:
        return staff.firstName();
      case CLUB_NAME:
        return staff.assignedClub();
      default:
        return null;
    }
  }

}
