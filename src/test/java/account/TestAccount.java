package account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;
import org.vbc4me.awanna.account.Account;
import org.vbc4me.awanna.account.Activity;
import org.vbc4me.awanna.account.Transaction;

/**
 * Test class for {@link Account}.
 */
public class TestAccount {
	
	/**
	 * Test the {@link Account} constructor.
	 */
	@Test
	public void initialBalance() {
		Account account = new Account();
		Assert.assertEquals(amount(0.00), account.balance());
	}
	
	/**
	 * Test the {@link Account #add(BigDecimal)} method.
	 */
	@Test
	public void addAmount() {
		Account account = new Account();
		BigDecimal dollarTwelve =amount(1.12);
		account.add(dollarTwelve);
		Assert.assertEquals(dollarTwelve, account.balance());
		BigDecimal tenSeventyFive = amount(10.75);
		account.add(tenSeventyFive);
		Assert.assertEquals(amount(11.87), account.balance());	
	}
	
	/**
	 * Test the {@link Account #subtract(BigDecimal)} method.
	 */
	@Test
	public void subtractAmount() {
		Account account = new Account();
		account.add(amount(15.75));
		account.subtract(amount(5.75));
		Assert.assertEquals(amount(10.00), account.balance());
		account .subtract(amount(3.72));
		Assert.assertEquals(amount(6.28), account.balance());
	}
	
	/**
	 * Test the {@link Account #adjustBalance(BigDecimal)} method.
	 */
	@Test
	public void adjustBalance() {
		Account account = new Account();
		account.adjustBalance(amount(19.57));
		Assert.assertEquals(amount(19.57), account.balance());
		account.adjustBalance(amount(14.78));
		Assert.assertEquals(amount(14.78), account.balance());
	}
	
	/**
	 * Test the {@link Account #insertTransaction(Transaction)} method.
	 */
	@Test
	public void insertTransaction() {
		Account account = new Account();
		account.adjustBalance(amount(5.00));
		Assert.assertEquals(amount(5.00), account.balance());
		
		Activity activity1 = 
										Activity.build().activity("Debit").cost(1.51).date(LocalDate.now()).time(LocalTime.now()).create();
		Transaction debit_transaction = new Transaction(Transaction.TYPE.DEBIT, activity1);
		account.insertTransaction(debit_transaction);
		Assert.assertEquals(amount(3.49), account.balance());
				
		Activity activity2 = 
										 Activity.build().activity("Credit").cost(1.25).date(LocalDate.now()).time(LocalTime.now()).create();
		Transaction credit_transaction = new Transaction(Transaction.TYPE.CREDIT, activity2);
		account.insertTransaction(credit_transaction);
		Assert.assertEquals(amount(4.74), account.balance());
	}
	
	/**
	 *  Returns a new {@link BigDecimal} from the {@link Double double} value passed in.
	 */
	private BigDecimal amount(double val) {
		return new BigDecimal(val).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
}
