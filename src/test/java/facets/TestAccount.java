package facets;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;
import org.vbc4me.awanna.facets.Account;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;

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
	  UUID uuid = UUID.fromString("c5ece936-2018-44dd-8000-e3ecb29efaf2");
		Account account = new Account(uuid);
		assertEquals(Money.zero(USD), account.balance());
		assertEquals(account.id(), uuid);
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
	public void transactionInsertAddsAndSubtractsFromAccount() {
		Account account = new Account();
		account.adjustBalance(Money.of(USD, 5.00));
		Assert.assertEquals(Money.of(USD, 5.00), account.balance());
		
		Activity activity1 = Activity.builder()
        .name("Debit")
        .description("A debit transaction")
        .cost(1.51)
        .date(LocalDate.of(2017, 12, 2))
        .time(LocalTime.of(12, 0))
        .create();
		Transaction debit_transaction = Transaction.builder()
        .activityId(activity1.id())
        .datetime(LocalDateTime.of(activity1.date(), activity1.time()))
        .amount(activity1.cost())
        .description(activity1.description())
				.create();
		account.insertTransaction(debit_transaction);
		Assert.assertEquals(Money.of(USD, 3.49), account.balance());

		Transaction credit_transaction = Transaction.builder()
        .type(Transaction.Type.CREDIT)
        .description("A credit transaction")
        .amount(Money.of(USD,1.25))
        .datetime(LocalDateTime.of(2017, 11, 3, 13, 51))
        .create();
		account.insertTransaction(credit_transaction);
		Assert.assertEquals(Money.of(USD, 4.74), account.balance());
	}

	@Test
  public void test() {
	  Money money = Money.zero(USD);
    System.out.println(money.toString());
    money = money.plus(Money.of(USD, .5));
    System.out.println(money.toString());
    money = money.plus(Money.of(USD, 6.21));
    System.out.println(money.toString());
    String m = money.toString();
    money = Money.parse(m).plus(Money.of(USD, .1));
    System.out.println(money.toString());

    for (int i = 0; i < 10; i++) {
      System.out.println(UUID.randomUUID());
    }
  }
}
