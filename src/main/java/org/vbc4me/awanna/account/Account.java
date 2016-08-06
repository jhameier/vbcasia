package org.vbc4me.awanna.account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  Holds information about a students financial info such as transactions and balanced owed.
 */
public class Account {

	private BigDecimal balance;
	private Map<LocalDate, Transaction> transactions = new HashMap<>();

	public Account() {
		this.balance = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Inserts a {@link Transaction} into this account; The amount from this transaction is added or subtracted 
	 * from this {@link Account accounts} balance depending on the type of {@code transaction} this is.
	 */
	public void insertTransaction(Transaction transaction) {
		this.transactions.put(transaction.activity().date(), transaction);
		switch (transaction.type()) {
			case "CREDIT":
				add(transaction.amount());
				break;
			case "DEBIT":
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
	 */
	public void add(BigDecimal amount) {
		balance = balance.add(amount);
		balance.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Subtracts the <tt>amount</tt> from this <tt>accountBalance</tt>.
	 */
	public void subtract(BigDecimal amount) {
		balance = balance.subtract(amount);
		balance.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Set the account <tt>balance</tt> to an exact amount.
	 */
	public void adjustBalance(BigDecimal amount) {
		balance = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
 	*  Returns this accounts balance
	 */
	public BigDecimal balance() {
		return balance;
	}

}
