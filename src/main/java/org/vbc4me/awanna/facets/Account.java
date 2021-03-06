package org.vbc4me.awanna.facets;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Holds information about a students financial info such as transactions and balanced owed.
 */
public class Account {
  private final UUID id;
  private final CurrencyUnit USD = CurrencyUnit.of("USD");
  private final Map<LocalDate, Transaction> transactions = new HashMap<>();
  private Money balance;

  public Account() {
    this(UUID.randomUUID());
  }

  public Account(UUID id) {
    this.id = Objects.requireNonNull(id);
    this.balance = Money.zero(USD);
  }

  /**
   * Inserts a {@link Transaction} into this account; The amount from this transaction is added or subtracted from this
   * {@link Account accounts} balance depending on the type of {@code transaction} this is.
   */
  public void insertTransaction(Transaction transaction) {
    this.transactions.put(transaction.date(), transaction);
    switch (transaction.type()) {
      case CREDIT:
        add(transaction.amount());
        break;
      case DEBIT:
        subtract(transaction.amount());
        break;
      default:
        throw new IllegalArgumentException("Unknown transaction type: " + transaction.type());
    }
  }

  /**
   * Returns a listing of all the transactions tied to this account
   *
   * @return an unmodifiable copy of this accounts transactions.
   */
  public Map<LocalDate, Transaction> transactions() {
    return Collections.unmodifiableMap(transactions);
  }

  /**
   * Adds the <tt>amount</tt> to this <tt>accountBalance</tt>.
   */
  public void add(Money amount) {
    balance = balance.plus(amount);
  }

  /**
   * Subtracts the <tt>amount</tt> from this <tt>accountBalance</tt>.
   */
  public void subtract(Money amount) {
    balance = balance.minus(amount);
  }

  /**
   * Set the account <tt>balance</tt> to an exact amount.
   */
  public void adjustBalance(Money amount) {
    balance = amount;
  }

  /**
   * Returns this accounts balance
   */
  public Money balance() {
    return balance;
  }

  /**
   * Return the {@link UUID id} for this {@link Account}.
   */
  public UUID id() {
    return id;
  }
}
