package org.vbc4me.awanna.facets;

import org.joda.money.Money;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a single transaction where money is received or credited to an account.
 */
public class Transaction {

  private LocalDateTime datetime;
  private Type type;
  private Money amount;
  private UUID activityId;
  private String description;

  /**
   * Return a {@link Builder} to help in the instantiation of a new {@link Transaction}.
   */
  public static Builder builder() {
    return new Builder();
  }

  private Transaction(Builder builder) {
    this.datetime = builder.datetime;
    this.type = builder.type;
    this.amount = builder.amount;
    this.activityId = builder.activityId;
    this.description = builder.description;
  }

  /**
   * Return the {@link LocalDate date} of this {@link Transaction}.
   */
  public LocalDate date() {
    return datetime.toLocalDate();
  }

  /**
   * Return the {@link LocalTime time} of this {@link Transaction}.
   */
  public LocalTime time() {
    return datetime.toLocalTime();
  }

  /**
   * Return the date and time in {@code LocalDateTime} format.
   */
  public LocalDateTime dateTime() {
    return datetime;
  }

  /**
   * Return the {@link Type} of {@link Transaction} this is (CREDIT or DEBIT)
   */
  public String type() {
    return type.name();
  }

  /**
   * Return the {@link Money amount} of this {@link Transaction}.
   */
  public Money amount() {
    return amount;
  }

  /**
   * Return the {@link UUID activity id} associated with this {@link Transaction}.
   */
  public UUID activityId() {
    return activityId;
  }

  /**
   * Return the description associated with this {@link Transaction}.
   */
  public String description() {
    return description;
  }

  /**
   * A classification for a {@link Transaction}.  A {@code Transaction} can either have money credited to an account
   * (added back) or debited (subtracted from).
   */
  public enum Type {
    CREDIT, DEBIT
  }

  /**
   * Helper to instantiate an new {@link Transaction}.
   */
  public static class Builder {
    private UUID id;
    private LocalDateTime datetime;
    private Type type;
    private Money amount;
    private UUID activityId;
    private String description;

    /**
     * The {@link UUID unique identifier} for this {@link Transaction}.  The {@code UUID} will be automaticly
     * generated if one isn't supplied.  Return this builder for method chaining.
     */
    public Builder trasactionId(UUID id) {
      this.id = id;
      return this;
    }

    /**
     * Add the date and time to this {@link Transaction} (Required).  Return this builder for method chaining.
     */
    public Builder datetime(LocalDateTime datetime) {
      this.datetime = datetime;
      return this;
    }

    /**
     * Classification for this {@link Transaction}.  If a type is not set, this {@code Transaction} will default to a
     * {@link Type#CREDIT}.  Return this builder for method chaining.
     */
    public Builder type(Type type) {
      this.type = type;
      return this;
    }

    /**
     * The {@link Money monitary amount} for this  {@link Transaction} (Required).
     * Return this builder for method chaining.
     */
    public Builder amount(Money amount) {
      this.amount = amount;
      return this;
    }

    /**
     * The {@link UUID id} of the activity to link to this {@link Transaction}.
     * Return this builder for method chaining.
     */
    public Builder activityId(UUID activityId) {
      this.activityId = activityId;
      return this;
    }

    /**
     * The description describing this {@link Transaction} (Required).  Return this builder for method chaining.
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Returns a fully qualified {@link Transaction}.
     */
    public Transaction create() {
      if (id == null) {
        id = UUID.randomUUID();
      }
      if (type == null) {
        type = Type.DEBIT;
      }
      Objects.requireNonNull(datetime);
      Objects.requireNonNull(type);
      Objects.requireNonNull(amount);
      Objects.requireNonNull(description);
      return new Transaction(this);
    }
  }

}
