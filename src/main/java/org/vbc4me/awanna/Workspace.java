package org.vbc4me.awanna;

import org.vbc4me.awanna.account.Season;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.DisplayContainer;

/**
 * Represents the current status of the application. The open Season, session and all the components needed to 
 * make this application flow from a starting state to and ending state.
 */
public final class Workspace {
	private static DisplayContainer container;
	private static Season season;
	
	public Workspace() {	}
	
	/**
	 * Sets the current working container. This is the components that are currently being displayed within the {@link AppGui gui}. 
	 * Any time the display is changed this container is to be updated to allow access to all components of the application to the 
	 * current workspace components. 
	 */
	public static void setContainer(DisplayContainer dcontainer) {
		container = dcontainer;
	}
	
	/**
	 * Returns the current workspace container holding the current gui components. This allows access to all components of the 
	 * application to the currently displayed content
	 */
	public static DisplayContainer container() {
		return container;
	}
	
	/**
	 * Returns whether this workspace as an active season or not.
	 */
	public static boolean isOpen() {
		if (season == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the currently active season.
	 * @return
	 */
	public static Season season() {
		return season;
	}
}
