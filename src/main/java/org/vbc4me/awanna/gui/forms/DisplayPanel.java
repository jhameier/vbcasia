package org.vbc4me.awanna.gui.forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
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
	private final JTable table = new JTable();
	private final JPanel contentPanel = new JPanel();
	private final JSplitPane splitPane;
	private JPanel bottomLeftPanel;
	private JPanel upperLeftPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel upperRightPanel;
	private JPanel lowerRightPanel;
	
	public DisplayPanel() {
		setLayout(new BorderLayout());
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		/*
		 * Upper scroll pane holds 3 panels, 1 panel with a border layout for content and the other for the button panel. 
		 * 
		 *  | ------------------- | -------------------- |
		 *  |                               |                                |
		 *  |-------------------- | -------------------- |
		 *  |                               |                                |
		 *  |-------------------- | -------------------- |
		 *  |                                                                 |
		 *  |                                                                 |
		 *  | ------------------------------------------ |
		 */
		final JScrollPane upperScrollPane = new JScrollPane(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		
		leftPanel = new JPanel();
		contentPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		upperLeftPanel = new JPanel();
		leftPanel.add(upperLeftPanel);
		FlowLayout fl_leftUpperPanel = (FlowLayout) upperLeftPanel.getLayout();
		fl_leftUpperPanel.setAlignment(FlowLayout.LEADING);
		upperLeftPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		bottomLeftPanel = new JPanel();
		leftPanel.add(bottomLeftPanel);
		FlowLayout fl_leftBottomPanel = (FlowLayout) bottomLeftPanel.getLayout();
		fl_leftBottomPanel.setAlignment(FlowLayout.LEADING);
		bottomLeftPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		rightPanel = new JPanel();
		contentPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		upperRightPanel = new JPanel();
		rightPanel.add(upperRightPanel);
		
		lowerRightPanel = new JPanel();
		rightPanel.add(lowerRightPanel);
		
		
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
	public void updateTableDisplay(TableModel dataModel) {
		table.setModel(dataModel);
		table.revalidate();
	}
		
	/**
	 * Sets the left bottom panel.
	 */
	public void updateBottomLeft(JPanel panel) {
		bottomLeftPanel.removeAll();
		bottomLeftPanel.add(panel);
		splitPane.setDividerLocation(-1);
	}
	
	/**
	 *  Sets the left upper panel. 
	 */
	public void updateUpperLeft(JPanel panel) {
		upperLeftPanel.removeAll();
		upperLeftPanel.add(panel);
		splitPane.setDividerLocation(-1);
	}
	
	/**
	 * Sets the right lower panel.
	 */
	public void updateLowerRight(JPanel panel) {
		lowerRightPanel.removeAll();
		lowerRightPanel.add(panel);
		splitPane.setDividerLocation(-1);
	}
	
	/**
	 * Sets the right upper panel.
	 */
	public void updateUpperRight(JPanel panel) {
		upperRightPanel.removeAll();
		upperRightPanel.add(panel);
		splitPane.setDividerLocation(-1);
	}
	/**
	 * Updates the upper content and button panels. The content panel requires a layout option to be set such as 
	 * {@code BorderLayout.WEST}.
	 */
	public void updateUpperDisplay(JPanel content, JPanel btnPanel) {
		upperLeftPanel.removeAll();
		upperLeftPanel.add(btnPanel);
		bottomLeftPanel.removeAll();
		bottomLeftPanel.add(content);
		splitPane.setDividerLocation(-1);
	}
	
	/**
	 * Initializes the entire panel with a dual display setup. The top panel will hold
	 * a standard JPanel (usually used to display text information) and the
	 * lower section is for holding a {@link JTable} for displaying spreadsheet
	 * style data. It should be noted that the tableModel is what is passed in and
	 * the table is updated with the then data set and layout.
	 */
	public void updateAllDisplays(JPanel content, JPanel btnPanel, JPanel sidePanel, TableModel model) {
		upperLeftPanel.removeAll();
		upperLeftPanel.add(btnPanel);
		
		bottomLeftPanel.removeAll();
		bottomLeftPanel.add(content);
		
		lowerRightPanel.removeAll();
		lowerRightPanel.add(sidePanel);
		
		table.removeAll();
		table.setModel(model);
		
		contentPanel.revalidate();
		table.revalidate();
		splitPane.setDividerLocation(-1);
	}
}
