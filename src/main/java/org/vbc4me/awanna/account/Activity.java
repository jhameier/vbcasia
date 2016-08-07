package org.vbc4me.awanna.account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * An activity is an event that is planned for participation of a student and
 * staff members including a date, time and a name for the activity.
 *
 * @author John Hameier 2015
 */
public class Activity {
	private final LocalDate date;
	private final LocalTime time;
	private final String name;
	private final BigDecimal cost;

	/** 
	 * Returns an  Activity builder to aid in the creation of a new {@link Activity}.
	 */
	public static Builder build() {
		return new Builder();
	}

	/**
	 * Return a Sessions worth of {@link Activity activities} sorted by the start date and containing the number of weeks,
	 *  specific time (which is applied to all activities) and cost (which is applied to all activities). Weeks are automatically
	 *  incremented.
	 */
	public static SortedMap<LocalDate, Activity>createActivities(LocalDate date, double numberOfWeeks, LocalTime time, double cost) {
		Objects.requireNonNull(date);
		Objects.requireNonNull(numberOfWeeks);
		Objects.requireNonNull(time);
		Objects.requireNonNull(cost);
		SortedMap<LocalDate, Activity> activities = new TreeMap<>();
		for(int week = 0; week < numberOfWeeks; week++) {
			Activity activity = Activity.build()
															.date(date.plusWeeks(week))
															.time(time)
															.name("Activity " + week)
															.cost(cost)
															.create();
			activities.put(activity.date(),activity);
		}
		return activities;
	}
	
	private Activity(Builder builder) {
		this.date = builder.date;
		this.time = builder.time;
		this.name = builder.name;
		this.cost = builder.cost;
	}

	/**
	 * Returns the date associated with this activity.
	 */
	public LocalDate date() {
		return date;
	}

	/**
	 * Returns the start time associated with this activity.
	 */
	public LocalTime time() {
		return time;
	}

	/**
	 * Return the name of this activity.
	 */
	public String name() {
		return name;
	}

	/**
	 * Returns the cost of this activity
	 */
	public BigDecimal cost() {
		return cost;
	}

	/**
	 * Duplicates an exact copy of this Activity. A duplicate copy is
	 * specificity an exact duplicate of the internal data.
	 */
	@Override
	public Activity clone() throws CloneNotSupportedException {
		return Activity.build().name(name).cost(cost.doubleValue()).date(date).time(time).create();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Activity))
			return false;

		Activity activity = (Activity) obj;

		return cost.equals(activity.cost) && date.equals(activity.date) && time.equals(activity.time)
				&& this.name.equals(activity.name);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = date.hashCode();
		result = 31 * result + time.hashCode();
		result = 31 * result + name.hashCode();
		temp = 31 + result + cost.hashCode();
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public static class Builder {
		private LocalDate date;
		private LocalTime time;
		private String name;
		private BigDecimal cost;

		public Builder date(LocalDate date) {
			this.date = date;
			return this;
		}

		public Builder time(LocalTime time) {
			this.time = time;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder cost(double cost) {
			this.cost = new BigDecimal(cost).setScale(2, BigDecimal.ROUND_HALF_UP);
			return this;
		}

		public Activity create() {
			Objects.requireNonNull(date);
			Objects.requireNonNull(time);
			Objects.requireNonNull(name);
			Objects.requireNonNull(cost);
			return new Activity(this);
		}
	}

}
