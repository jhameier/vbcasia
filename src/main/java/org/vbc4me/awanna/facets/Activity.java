package org.vbc4me.awanna.facets;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * An activity is an event that is planned for participation of a student and staff members including a date, time and a
 * name for the activity.
 *
 * @author John Hameier 2015
 */
public class Activity {

  private final UUID id;
  private final LocalDate date;
  private final LocalTime time;
  private final String name;
  private final String description;
  private final Money cost;

  private Activity(Builder builder) {
    this.id = builder.id;
    this.date = builder.date;
    this.time = builder.time;
    this.name = builder.name;
    this.description = builder.description;
    this.cost = builder.cost;
  }

  /**
   * Returns an  Activity builder to aid in the creation of a new {@link Activity}.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Return a Sessions worth of {@link Activity activities} sorted by the start date and containing the number of weeks,
   * specific time (which is applied to all activities) and cost (which is applied to all activities).  Weeks are
   * automatically incremented.
   */
  public static SortedMap<LocalDate, Activity> createActivities(LocalDate date, double numberOfWeeks,
      LocalTime time, double cost) {
    Objects.requireNonNull(date);
    Objects.requireNonNull(time);
    SortedMap<LocalDate, Activity> activities = new TreeMap<>();
    for (int week = 0; week < numberOfWeeks; week++) {
      Activity activity = Activity.builder()
          .date(date.plusWeeks(week))
          .time(time)
          .name("Activity " + week)
          .description("description " + week)
          .cost(cost)
          .create();
      activities.put(activity.date(), activity);
    }
    return activities;
  }

  /**
   * Returns the date associated with this {@link Activity}.  Any changes to the returned value will not effect the
   * {@link LocalDate date} associated with this {@link Activity}.  If the date needs to change use the provided method
   * {@link #changeDate(LocalDate)}.
   */
  public LocalDate date() {
    return LocalDate.parse(date.toString());
  }

  /**
   * Returns a new {@link Activity} with the {@link LocalDate date}.
   */
  public Activity changeDate(LocalDate date) {
    return Activity.builder()
        .id(this.id)
        .date(date)
        .time(this.time)
        .name(this.name)
        .description(this.description)
        .cost(this.cost)
        .create();
  }

  /**
   * Returns the start time associated with this {@link Activity}.  Any changes to the returned value will not effect
   * the {@link LocalTime time} associated with this {@link Activity}.  If the time need to change use the provided
   * method {@link #changeTime(LocalTime)}.
   */
  public LocalTime time() {
    return LocalTime.parse(time.toString());
  }

  /**
   * Returns a new {@link Activity} with the {@link LocalTime time}.
   */
  public Activity changeTime(LocalTime time) {
    return Activity.builder()
        .id(this.id)
        .date(this.date)
        .time(time)
        .name(this.name)
        .description(this.description)
        .cost(this.cost)
        .create();
  }

  /**
   * Returns a new {@link Activity} with the {@link LocalDate date} and {@link LocalTime time}.
   */
  public Activity changeDateAndTime(LocalDate date, LocalTime time) {
    return Activity.builder()
        .id(this.id)
        .date(date)
        .time(time)
        .name(this.name)
        .description(this.description)
        .cost(this.cost)
        .create();
  }

  /**
   * Return the name of this actions.
   */
  public String name() {
    return name;
  }

  public String description() {
    return description;
  }

  /**
   * Returns the cost of this actions
   */
  public Money cost() {
    return cost;
  }

  /**
   * Duplicates an exact copy of this Activity. A duplicate copy is specificity an exact duplicate of the internal
   * data.
   */
  @Override
  public Activity clone() throws CloneNotSupportedException {
    return Activity.builder().name(name).description(description).cost(cost).date(date).time(time).create();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Activity)) {
      return false;
    }

    Activity activity = (Activity) obj;

    return id.equals(activity.id)
        && date.equals(activity.date)
        && time.equals(activity.time)
        && name.equals(activity.name)
        && description.equals(activity.description)
        && cost.equals(activity.cost);
  }

  /**
   * Returns true if the contents (other than {@link UUID}) are the same, false otherwise.
   */
  public boolean isEqualTo(Activity activity) {
    return date.equals(activity.date)
        && time.equals(activity.time)
        && name.equals(activity.name)
        && description.equals(activity.description)
        && cost.equals(activity.cost);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;

    result = id.hashCode();
    result = 31 * result + date.hashCode();
    result = 31 * result + time.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + description.hashCode();
    temp = 31 + result + cost.hashCode();
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  public static class Builder {

    private UUID id;
    private LocalDate date;
    private LocalTime time;
    private String name;
    private String description;
    private Money cost;

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

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

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder cost(double cost) {
      this.cost = Money.of(CurrencyUnit.USD, cost);
      return this;
    }

    public Builder cost(Money cost) {
      this.cost = cost;
      return this;
    }

    public Activity create() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      Objects.requireNonNull(date);
      Objects.requireNonNull(time);
      Objects.requireNonNull(name);
      Objects.requireNonNull(description);
      Objects.requireNonNull(cost);
      return new Activity(this);
    }
  }

}
