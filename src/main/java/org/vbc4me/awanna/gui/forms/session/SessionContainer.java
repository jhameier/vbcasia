package org.vbc4me.awanna.gui.forms.session;

/**
 * Creates the Session Information Container.
 */
public final class SessionContainer {
  // FIXME pass in frame
  public static final SessionButtonPanel buttonPanel = new SessionButtonPanel(null);
  public static final SessionBlankForm blankForm = new SessionBlankForm();
  public static final SessionDisplayForm displayForm = new SessionDisplayForm();
  public static final SessionEditForm editForm = new SessionEditForm();
  public static final SessionTableModel tableModel = new SessionTableModel();

  public SessionContainer() {
  }

}
