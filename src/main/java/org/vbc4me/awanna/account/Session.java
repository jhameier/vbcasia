package org.vbc4me.awanna.account;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	 * Creates a new session with a start date but without activities associated
	 * with it. The end date is automatically calculated for 6 months from the
	 * start date. The end date can be adjusted when necessary.
	 *
	 * @param date
	 *            that this session starts on
	 */
	public Session(LocalDate date) {
		this.startDate = date;
		this.endDate = date.plusWeeks(24);
	}
	
	/**
	 * Sets the end date of this Session
	 *
	 * @param date
	 *            to set as the ending date
	 */
	public void endDate(LocalDate date) {
		checkIfSessionIsOpen();
		this.endDate = date;
	}
	
	/**
	 * Adds/subtracts the amount of units to this end date. The ChronoUnit can be in the
	 * form of Minutes, Hours, Days, Years etc
	 *
	 * @param amount of time to move the start date (a negative number will be subtracted from the date)
	 * @param unit  of measure to use in the operation
	 */
	public void moveEndDate(Long amount, ChronoUnit unit) {
		checkIfSessionIsOpen();
		if(amount < 0) {
			this.endDate.minus(amount * -1, unit);
			return;
		}
		this.endDate.plus(amount, unit);
	}
	
	/**
	 * Returns this {@link Session sessions} start date.
	 */
	public LocalDate startDate() {
		return startDate;
	}
	
	/**
	 *  Returns this {@link Session sessions} end date
	 */
	public LocalDate endDate() {
		return endDate;
	}
	
	/**
	 * Adds an activity to this Session
	 *
	 * @param date  of this activity
	 * @param activity for members to participate in
	 */
	public void addActivity(LocalDate date, LocalTime time, String activity, double cost) {
		checkIfSessionIsOpen();
		Activity act = Activity.build().date(date).time(time).activity(activity).cost(cost).create();
		activities.put(act.date(), act);
	}
	
	/**
	 *  Returns an activity if one is found on the given date passed. If not an empty object will be returned
	 */
	public Optional<Activity> getActivity(LocalDate date) {
		if (activities.get(date) != null) {
			return Optional.of(activities.get(date));
		}
		return Optional.empty();
	}
	
	/**
	 * Checks if this session is still open. This will return nothing if this
	 * session is open but conversely will throw an {@link IllegalAccessError}
	 * if it has been closed.
	 */
	private void checkIfSessionIsOpen() {
		if (!open) {
			throw new IllegalAccessError("You can not add an activity to a closed session");
		}
	}
	
	/**
	 * Returns if this session is open and available to add and modify students,
	 * staff and activities.
	 */
	public boolean sessionIsOpen() {
		return open;
	}
	
	/**
	 * Closes this session. Closed sessions can not be modified in anyway after
	 * it has been closed.
	 */
	public void closeSession() {
		this.open = false;
	}
	
	/**
	 * This will reopen a session if it is closed. This should only be used in
	 * rare circumstances that require addition information to be added. Add
	 * data in an open session is logged for backup purposes.
	 */
	public void reopenSession() {
		this.open = true;
	}
	
}
