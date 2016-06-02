package org.vbc4me.awanna.account;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * An activity is an event that is planned for participation of a student and
 * staff members including a date, time and a name for the activity.
 *
 * @author John Hameier 2015
 */
public class Activity {
	private final LocalDate date;
	private final LocalTime time;
	private final String activity;
	private final double cost;

	public static Builder build() {
		return new Builder();
	}

	private Activity(Builder builder) {
		this.date = builder.date;
		this.time = builder.time;
		this.activity = builder.activity;
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
	public String activity() {
		return activity;
	}

	/**
	 * Returns the cost of this activity
	 */
	public double cost() {
		return cost;
	}

	/**
	 * Duplicates an exact copy of this Activity. A duplicate copy is
	 * specificity an exact duplicate of the internal data.
	 */
	@Override
	public Activity clone() throws CloneNotSupportedException {
		return (Activity) super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Activity))
			return false;

		Activity activity = (Activity) obj;

		return Double.compare(activity.cost, cost) == 0 && date.equals(activity.date) && time.equals(activity.time)
				&& this.activity.equals(activity.activity);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = date.hashCode();
		result = 31 * result + time.hashCode();
		result = 31 * result + activity.hashCode();
		temp = Double.doubleToLongBits(cost);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public static class Builder {
		private LocalDate date;
		private LocalTime time;
		private String activity;
		private double cost;

		public Builder date(LocalDate date) {
			this.date = date;
			return this;
		}

		public Builder time(LocalTime time) {
			this.time = time;
			return this;
		}

		public Builder activity(String name) {
			this.activity = name;
			return this;
		}

		public Builder cost(double cost) {
			this.cost = cost;
			return this;
		}

		public Activity create() {
			Objects.requireNonNull(date);
			Objects.requireNonNull(time);
			Objects.requireNonNull(activity);
			Objects.requireNonNull(cost);
			return new Activity(this);
		}
	}

}
