package org.vbc4me.awanna.account;

/**
 * A class to represent a single transaction where money is received or credited
 * to an account.
 */
public class Transaction {
	
	public enum TYPE {
		CREDIT, DEBIT
	}
	
	private TYPE type;
	private double amount;
	private Activity activity;
	
	public Transaction(Transaction.TYPE type, double amount, Activity activity) {
		this.type = type;
		this.amount = amount;
		this.activity = activity;
	}
	
	/**
	 * Returns the type of transaction this is (Credit or Debit)
	 */
	public String type() {
		return type.toString();
	}
	
	/**
	 * Returns the amount of this transaction
	 */
	public double amount() {
		return amount;
	}
	
	/**
	 * Returns the activity associated with this account
	 */
	public Activity activity() {
		return activity;
	}
	
}
