package org.vbc4me.awanna.account;

import org.joda.money.Money;

/**
 * A class to represent a single transaction where money is received or credited
 * to an account.
 */
public class Transaction {
	
	public enum TYPE {
		CREDIT, DEBIT
	}
	
	private TYPE type;
	private Activity activity;
	
	public Transaction(Transaction.TYPE type, Activity activity) {
		this.type = type;
		this.activity = activity;
	}
	
	/**
	 * Returns the type of transaction this is (CREDIT or DEBIT)
	 */
	public String type() {
		return type.name();
	}
	
	/**
	 * Returns the amount of this transaction
	 */
	public Money amount() {
		return activity.cost();
	}
	
	/**
	 * Returns the activity associated with this account
	 */
	public Activity activity() {
		return activity;
	}
	
}
