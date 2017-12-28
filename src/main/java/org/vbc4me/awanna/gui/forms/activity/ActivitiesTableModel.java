package org.vbc4me.awanna.gui.forms.activity;

import org.vbc4me.awanna.facets.Activity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public final class ActivitiesTableModel extends AbstractTableModel {
    public static final int DATE = 0;
    public static final int TIME = 1;
    public static final int ACTIVITY = 2;
    private static final long serialVersionUID = 8530443718844287586L;
    private String[] columnNames = {"Date", "Time", "Activity"};
    private List<Activity> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Activity activity = data.get(row);
        switch (column) {
            case DATE:
                return activity.date();
            case TIME:
                return activity.time();
            case ACTIVITY:
                return activity.name();
        }
        return null;
    }

    public void addData(Activity activity) {
        data.add(activity);
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
     * @param row    number of the cell
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
                return Boolean.class;
            case 1:
            case 2:
            case 3:
                return String.class;
            case 4:
                return Double.class;
            default:
                return Object.class;
        }
    }
}
