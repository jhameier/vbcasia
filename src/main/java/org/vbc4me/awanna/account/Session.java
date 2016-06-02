package org.vbc4me.awanna.account;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a logical amount of time including a set of activities that will
 * take place within the given time period.
 */
public class Session {

  private LocalDate startDate;
  private LocalDate endDate;
  private Map<LocalDate, Activity> activities = new HashMap<>();
  private boolean open = true;

  /**
   * Constructs the session but without activities or start date.
   */
  public Session() {
  }

  /**
   * Creates a new session with a start date but without activities associated
   * with it. The end date is automatically calculated for 6 months from the
   * start date. The end date can be adjusted when necessary.
   *
   * @param date that this session starts on
   */
  public Session(LocalDate date) {
    this.startDate = date;
    this.endDate = date.plusWeeks(24);
  }

  /**
   * Sets the start date of this Session. If the end date has not already been
   * set will set the end date to 24 weeks from this start date (6 months).
   *
   * @param date to set as the start date
   */
  public void startDate(LocalDate date) {
    checkIfSessionIsOpen();
    this.startDate = date;
    if (endDate() == null) {
      this.endDate = startDate().plusWeeks(24);
    }
  }

  /**
   * Sets the end date of this Session
   *
   * @param date to set as the ending date
   */
  public void endDate(LocalDate date) {
    checkIfSessionIsOpen();
    this.endDate = date;
  }

  /**
   * Adds the amount of units to this start date. The ChronoUnit can be in the
   * form of Minutes, Hours, Days, Years etc
   *
   * @param amount to add to the start date
   * @param unit   of measure to use in the operation
   */
  public void addToStartDate(Long amount, ChronoUnit unit) {
    checkIfSessionIsOpen();
    this.startDate.plus(amount, unit);
  }

  /**
   * Subtracts the amount of units to this start date. The ChronoUnit can be
   * in the form of Minutes, Hours, Days, Years etc
   *
   * @param amount to subtract from the start date
   * @param unit   of measure to use in the operation
   */
  public void subtractFromStartDate(Long amount, ChronoUnit unit) {
    checkIfSessionIsOpen();
    this.startDate.minus(amount, unit);
  }

  /**
   * Adds the amount of units to this end date. The ChronoUnit can be in the
   * form of Minutes, Hours, Days, Years etc
   *
   * @param amount to add to the start date
   * @param unit   of measure to use in the operation
   */
  public void addToEndDate(Long amount, ChronoUnit unit) {
    checkIfSessionIsOpen();
    this.endDate.plus(amount, unit);
  }

  /**
   * This <em>sessions</em> start date.
   *
   * @return the start date associated with this session
   */
  public LocalDate startDate() {
    return startDate;
  }

  /**
   * This <em>sessions</em> end date
   *
   * @return the end date
   */
  public LocalDate endDate() {
    return endDate;
  }

  /**
   * Adds an activity to this Session
   *
   * @param date     of this activity
   * @param activity for members
   */
  public void addActivity(LocalDate date, LocalTime time, String activity, double cost) {
    checkIfSessionIsOpen();
    Activity act = Activity.build().date(date).time(time).activity(activity).cost(cost).create();
    activities.put(act.date(), act);
  }



  /**
   * @param date to search for
   * @return the activity for the given date
   * @throws IllegalArgumentException
   */
  public Activity getActivity(LocalDate date) {
    if (activities.get(date) != null) {
      return activities.get(date);
    } else {
      throw new IllegalArgumentException("No Activity Found");
    }
  }

  /**
   * Checks if this session is still open. This will return nothing if this session is open but
   * conversely will throw an {@link IllegalAccessError} if it has been closed.
   */
  private void checkIfSessionIsOpen() {
    if(!open) {
      throw new IllegalAccessError("You can not add an activity to a closed session");
    }
  }

  /**
   * Returns if this session is open and available to add and modify students, staff and activities.
   */
  public boolean sessionIsOpen() {
    return open;
  }

  /**
   * Closes this session. Closed sessions can not be modified in anyway after it has been closed.
   */
  public void closeSession() {
    this.open = false;
  }

  /**
   * This will reopen a session if it is closed. This should only be used in rare circumstances that
   * require addition information to be added. Add data in an open session is logged for backup purposes.
   */
  public void reopenSession() {
    this.open = true;
  }


}
