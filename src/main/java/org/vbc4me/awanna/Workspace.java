package org.vbc4me.awanna;

import org.vbc4me.awanna.account.Season;

/**
 * Represents the current status of the application. The open Season, session and all the components needed to 
 * make this application flow from a starting state to and ending state.
 */
public class Workspace {
	private static Season season;
	
	public Workspace() {	}
	
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
