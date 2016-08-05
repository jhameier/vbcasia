package org.vbc4me.awanna.account;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  Holds information about a students financial info such as transactions and balanced owed.
 */
public class Account {

	private Double balance;
	private Map<LocalDate, Transaction> transactions = new HashMap<>();

	public Account() {
		this.balance = 0.00;
	}

	/**
	 * Inserts a {@link Transaction} into this account; The amount from this transaction is added or subtracted 
	 * from this {@link Account accounts} balance depending on the type of {@code transaction} this is.
	 */
	public void insertTransaction(Transaction transaction) {
		this.transactions.put(transaction.activity().date(), transaction);
		switch (transaction.type()) {
			case "debit":
				add(transaction.amount());
				break;
			case "credit":
				subtract(transaction.amount());
				break;
			default: throw new IllegalArgumentException("Unknown transaction type: " + transaction.type());
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
	 * 
	 * @param amount
	 *            to add
	 */
	public void add(double amount) {
		balance = balance + amount;
	}

	/**
	 * Subtracts the <tt>amount</tt> from this <tt>accountBalance</tt>.
	 * 
	 * @param amount
	 *            to subtract
	 */
	public void subtract(double amount) {
		balance = balance - amount;
	}

	/**
	 * Set the account <tt>balance</tt> to an exact amount.
	 * 
	 * @param amount
	 *            to set account balance to
	 */
	public void adjustBalance(double amount) {
		balance = amount;
	}

	/**
	 * @return this accounts balance
	 */
	public double balance() {
		return balance;
	}

}
