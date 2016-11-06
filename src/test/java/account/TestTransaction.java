package account;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Transaction;

/**
 * Test class for {@link Transaction}.
 */
public class TestTransaction {
	private LocalDate date = LocalDate.now();
	private LocalTime time = LocalTime.now();
	
	/**
	 * Test for Debit  Transaction creation.
	 */
	@Test
	public void TestDebitTransaction() {
		Activity debitActivity = Activity.builder().name("Debit").cost(1.52).date(date).time(time).create();
		Transaction transaction = new Transaction(Transaction.TYPE.DEBIT, debitActivity);
		Assert.assertEquals(Transaction.TYPE.DEBIT.name(), transaction.type());
	}
	
	/**
	 * Test for Credit Transaction creation.
	 */
	@Test
	public void TestCreditTransaction() {
		Activity creditActivity = Activity.builder().name("Credit").cost(6.95).date(date).time(time).create();
		Transaction transaction = new Transaction(Transaction.TYPE.CREDIT, creditActivity);
		Assert.assertEquals(Transaction.TYPE.CREDIT.name(), transaction.type());
	}
	
	/**
	 * Test {@link Activity} attachment.
	 */
	@Test
	public void TestTransactionActivity() {
		Activity activity = Activity.builder().name("Debit").cost(16.84).date(date).time(time).create();
		Transaction transaction = new Transaction(Transaction.TYPE.DEBIT, activity);
		Assert.assertEquals(activity, transaction.activity());
		Assert.assertEquals(activity.cost(), transaction.activity().cost());
	}
}
