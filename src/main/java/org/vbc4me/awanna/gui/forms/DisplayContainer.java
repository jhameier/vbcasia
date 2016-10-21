package org.vbc4me.awanna.gui.forms;

import javax.swing.JPanel;
import javax.swing.table.TableModel;

/**
 * Immutable container for holding the currently loaded content, button panels and the
 * currently loaded table model. A new container must be created to change the currently
 * loaded components. Changing a single component can be accomplished by the use of the
 * internal methods to update which returns a new panel with the updated components.
 */
public class DisplayContainer {
	
	private final JPanel content;
	private final JPanel buttonPanel;
	private final TableModel tableModel;
	
	public DisplayContainer(JPanel panel, JPanel btnPanel, TableModel model) {
		content = panel;
		buttonPanel = btnPanel;
		tableModel = model;
	}
	
	/**
	 * @return the content
	 */
	public JPanel getContent() {
		return content;
	}

	/**
	 * @return the buttonPanel
	 */
	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	/**
	 * @return the tableModel
	 */
	public TableModel getTableModel() {
		return tableModel;
	}

    /**
     * Returns a new container with the original content and button panels with
     * an updated table model.
     */
	public DisplayContainer updateTableModel(TableModel model) {
        return new DisplayContainer(content, buttonPanel, model);
    }

    /**
     * Returns a new container with the original button panel and table model with
     * an updated content panel.
     */
    public DisplayContainer updateContentPanel(JPanel panel) {
        return new DisplayContainer(panel, buttonPanel, tableModel);
    }

    /**
     * Returns a new container with the original content panel and table model with
     * an updated button panel.
     */
    public DisplayContainer updateButtonPanel(JPanel panel) {
        return new DisplayContainer(content, panel, tableModel);
    }

    /**
     * Returns a new container with only the original table model and with
     * updated content and button panels.
     */
    public DisplayContainer updateContentAndButtonPanels(JPanel panel, JPanel button) {
        return new DisplayContainer(panel, button, tableModel);
    }
}
