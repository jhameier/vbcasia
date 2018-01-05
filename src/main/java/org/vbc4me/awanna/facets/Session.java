package org.vbc4me.awanna.facets;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;


/**
 * Represents a logical amount of time including a set of activities that will take place within the given time period.
 */
public final class Session {

  private UUID id;
  private LocalDate startDate;
  private LocalDate endDate;
  private Map<LocalDate, Activity> activities;

  private Session(Builder builder) {
    this.id = builder.id;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.activities = builder.activities;
  }

  /**
   * Returns a {@link Builder} for {@code Session}s.
   */
  public static Builder builder() {
    return new Builder();
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
    this.endDate = date;
  }

  /**
   * Adds/subtracts the amount of units to this end date. The ChronoUnit can be in the form of Minutes, Hours, Days,
   * Years etc
   *
   * @param amount of time to move the start date (a negative number will be subtracted from the date)
   * @param unit of measure to use in the operation
   */
  public void moveEndDate(Long amount, ChronoUnit unit) {
    if (amount < 0) {
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
   * Returns this {@link Session sessions} end date
   */
  public LocalDate endDate() {
    return endDate;
  }

  /**
   * Adds an {@link Activity} to this {@code Session}.
   */
  public void addActivity(LocalDate date, LocalTime time, String name, double cost) {
    activities.put(date, Activity.builder().date(date).time(time).name(name).cost(cost).create());
  }

  /**
   * Returns an {@link Optional} {@link Activity} if one is found on the date specified else returns an {@link
   * Optional#empty()}.
   */
  public Optional<Activity> getActivity(LocalDate date) {
    if (activities.containsKey(date)) {
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
   * A builder to help in the instantiation of a new {@link Session}.
   */
  public static class Builder {

    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Map<LocalDate, Activity> activities = new TreeMap<>();

    /**
     * The {@link UUID} to associate with this {@link Session}.  Returns this builder for method chaining.
     */
    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    /**
     * The {@link LocalDate starting date} to associate with this {@link Session}.   Returns this builder for method
     * chaining.
     */
    public Builder startDate(LocalDate date) {
      this.startDate = date;
      return this;
    }

    /**
     * The {@link LocalDate ending date} to asscoicate with this {@link Session}.    Returns this builder for method
     * chaining.
     */
    public Builder endDate(LocalDate date) {
      this.endDate = date;
      return this;
    }

    /**
     * Adds an {@link Activity} to the list of Activities associated with this {@link Session}.  Returns this builder
     * for method chaining.
     */
    public Builder activity(Activity activity) {
      this.activities.put(activity.date(), activity);
      return this;
    }

    /**
     * Returns an new fully qualified {@link Session}.
     */
    public Session build() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      Objects.requireNonNull(startDate);
      Objects.requireNonNull(endDate);
      return new Session(this);
    }
  }
}
