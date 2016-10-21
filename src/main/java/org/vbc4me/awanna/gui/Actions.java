package org.vbc4me.awanna.gui;

import javax.swing.Action;
import java.util.HashMap;
import java.util.Map;

/**
 * Container to hold all the actions associated with the application. This allows
 * containing all the actions in once place so that we only instantiate a single action
 * for the application and we can pass this around to make it easier to get to components
 * throughout this application lifecycle.
 */
public final class Actions {
    public final static Map<String, Action> container = new HashMap<>();
}
