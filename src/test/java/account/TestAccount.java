package account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;
import org.vbc4me.awanna.facets.Account;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Transaction;

/**
 * Test class for {@link Account}.
 */
public class TestAccount {
	private CurrencyUnit USD = CurrencyUnit.of("USD");
	
	/**
	 * Test the {@link Account} constructor.
	 */
	@Test
	public void initialBalance() {
		Account account = new Account();
		Assert.assertEquals(Money.zero(USD), account.balance());
	}
	
	/**
	 * Test the {@link Account #add(BigDecimal)} method.
	 */
	@Test
	public void addAmount() {
		Account account = new Account();
		Money dollarTwelve = Money.of(USD, 1.12);
		account.add(dollarTwelve);
		Assert.assertEquals(dollarTwelve, account.balance());
		Money tenSeventyFive = Money.of(USD, 10.75);
		account.add(tenSeventyFive);
		Assert.assertEquals(Money.of(USD, 11.87), account.balance());	
	}
	
	/**
	 * Test the {@link Account #subtract(BigDecimal)} method.
	 */
	@Test
	public void subtractAmount() {
		Account account = new Account();
		account.add(Money.of(USD, 15.75));
		account.subtract(Money.of(USD, 5.75));
		Assert.assertEquals(Money.of(USD, 10.00), account.balance());
		account .subtract(Money.of(USD, 3.72));
		Assert.assertEquals(Money.of(USD, 6.28), account.balance());
	}
	
	/**
	 * Test the {@link Account #adjustBalance(BigDecimal)} method.
	 */
	@Test
	public void adjustBalance() {
		Account account = new Account();
		account.adjustBalance(Money.of(USD, 19.57));
		Assert.assertEquals(Money.of(USD, 19.57), account.balance());
		account.adjustBalance(Money.of(USD, 14.78));
		Assert.assertEquals(Money.of(USD, 14.78), account.balance());
	}
	
	/**
	 * Test the {@link Account #insertTransaction(Transaction)} method.
	 */
	@Test
	public void insertTransaction() {
		Account account = new Account();
		account.adjustBalance(Money.of(USD, 5.00));
		Assert.assertEquals(Money.of(USD, 5.00), account.balance());
		
		Activity activity1 = 
										Activity.builder().name("Debit").cost(1.51).date(LocalDate.now()).time(LocalTime.now()).create();
		Transaction debit_transaction = new Transaction(Transaction.TYPE.DEBIT, activity1);
		account.insertTransaction(debit_transaction);
		Assert.assertEquals(Money.of(USD, 3.49), account.balance());
				
		Activity activity2 = 
										 Activity.builder().name("Credit").cost(1.25).date(LocalDate.now()).time(LocalTime.now()).create();
		Transaction credit_transaction = new Transaction(Transaction.TYPE.CREDIT, activity2);
		account.insertTransaction(credit_transaction);
		Assert.assertEquals(Money.of(USD, 4.74), account.balance());
	}
}
