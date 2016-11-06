package org.vbc4me.awanna.facets;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a logical amount of time including a set of activities that will
 * take place within the given time period.
 */
public final class Session {
	
	private UUID id;
	private LocalDate startDate;
	private LocalDate endDate;
	private Map<LocalDate, Activity> activities = new HashMap<>();
	private boolean open = true;

	
	/**
	 * Creates a new Session with the given start date.
	 * The end date is calculated based on the number of weeks passed in.
	 * The end date can be adjusted when necessary. 
	 * 
	 * <p>The new session will have no activities associated with it and these must be added.
	 */
	public Session(LocalDate date, int numOfWeeks) {
        this.id = UUID.randomUUID();
		this.startDate = date;
		this.endDate = date.plusWeeks(numOfWeeks);
	}

    /**
     * Creates a new Session with the given start and end dates.
     * The end date can be adjusted when necessary.
     *
     * <p>The new session will have no activities associated with it and these must be added.
     */
	public Session(LocalDate start, LocalDate end) {
        this.id = UUID.randomUUID();
        this.startDate = start;
        this.endDate = end;
    }
	
	/**
	 * Return the unique id for this {@link Session}.
	 */
	public UUID id() {
		return id;
	}
	
	/**
	 * Sets the end date of this Session to a specific date.
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
	 * Adds an actions to this Session
	 *
	 * @param date  of this actions
	 * @param activity for members to participate in
	 */
	public void addActivity(LocalDate date, LocalTime time, String activity, double cost) {
		checkIfSessionIsOpen();
		Activity act = Activity.build().date(date).time(time).name(activity).cost(cost).create();
		activities.put(act.date(), act);
	}
	
	/**
	 *  Returns an actions if one is found on the date specified. If not an empty object will be returned
	 */
	public Optional<Activity> getActivity(LocalDate date) {
		if (activities.get(date) != null) {
			return Optional.of(activities.get(date));
		}
		return Optional.empty();
	}
	
	/**
	 * Returns all the {@link Activity activities} associated with this {@link Session}.
	 */
	public Map<LocalDate, Activity> activities() {
		return activities;
	}
	
	/**
	 * Checks if this actions is still open. This will return nothing if this
	 * actions is open but conversely will throw an {@link IllegalAccessError}
	 * if it has been closed. This is here in an attempt to keep someone from performing
	 * operations on an already closed actions and it is left to the programmer to control
	 * the program flow in order to avoid this from being called after a actions has been closed.
	 * the {@link #sessionIsOpen()} method should be called in order to avoid this from being
	 * thrown.
	 */
	private void checkIfSessionIsOpen() {
		if (!open) {
			throw new IllegalAccessError("You can not add an actions to a closed actions");
		}
	}
	
	/**
	 * Returns if this actions is open and available to add and modify students,
	 * staff and activities.
	 */
	public boolean sessionIsOpen() {
		return open;
	}
	
	/**
	 * Closes this actions. Closed sessions can not be modified in anyway after
	 * it has been closed.
	 */
	public void closeSession() {
		open = false;
	}
	
	/**
	 * This will reopen a actions if it is closed. This should only be used in
	 * rare circumstances that require addition information to be added. Add
	 * data in an open actions is logged for backup purposes.
	 */
	protected void reopenSession() {
		open = true;
	}
	
}
