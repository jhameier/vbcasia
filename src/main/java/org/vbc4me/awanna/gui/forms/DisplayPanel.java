package org.vbc4me.awanna.gui.forms;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * This class handles the various spreadsheet styles and JPanels to display. This uses a
 * JSplitPane to handle the proper display setup for this panel to
 * display correctly. This is a generic shell for a table, and can be changed by
 * passing in new table models to display different types of data in different
 * ways by calling setTableDisplay(TableModel) and passing in the model of the
 * data that needs to be displayed.
 *
 * @author John Hameier 2016
 */
public final class DisplayPanel extends JPanel {
	private static final long serialVersionUID = -3284524458172373047L;
	private final static JTable table = new JTable();
	private final static JPanel panel = new JPanel(new BorderLayout());
	private final JSplitPane splitPane;
	
	public DisplayPanel() {
		setLayout(new BorderLayout());
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		/*
		 * Upper scroll pane holds a panel with a border layout. We place in this
		 * panel's BorderLayout.CENTER so that we can change what is displayed 
		 * in the upper portion of the window.
		 */
		final JScrollPane upperScrollPane = new JScrollPane(panel);
		
		/*
		 * Lower scroll pane holds a table and is place inside a panel's
		 * BorderLayout.CENTER so that the table can display correctly.
		 * By changing the TableModel of the table, the table will display
		 * different types of data in a custom spreadsheet style layout.
		 */
		final JScrollPane lowerScrollPane = new JScrollPane(table);
		
		splitPane.setTopComponent(upperScrollPane);
		splitPane.setBottomComponent(lowerScrollPane);
	}
	
	/**
	 * Sets the data model for this panels table display. By passing in
	 * different models, this table display can show various types of tables
	 * without creating a separate JTable for each view needed.
	 */
	public void updateLowerDisplay(TableModel dataModel) {
		table.setModel(dataModel);
		splitPane.setDividerLocation(0.60);
		table.revalidate();
	}
	
	/**
	 * Sets the upper display with the panel passed in, using the layout provided. The display uses
	 * a Border Layout so a proper uses example {@code BorderLayout.WEST}. 
	 */
	public void updateUpperDisplay(JPanel display, String layout) {
		panel.removeAll();
		panel.add(display, layout);
		splitPane.setDividerLocation(0.60);
		panel.revalidate();
	}
	
	/**
	 * Initializes the entire panel with a dual display setup. The top panel will hold
	 * a standard JPanel (usually used to display text information) and the
	 * lower section is for holding a {@link JTable} for displaying spreadsheet
	 * style data. It should be noted that the tableModel is what is passed in and
	 * the table is updated with the then data set and layout.
	 */
	public void updateBothDisplays(JPanel textPanel, String layout, TableModel dataModel) {
		panel.removeAll();
		panel.add(textPanel, layout);
		table.setModel(dataModel);
		splitPane.setDividerLocation(0.60);
	}
	
}
