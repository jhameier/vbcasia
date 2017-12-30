package facets;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

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
    Activity debitActivity = Activity.builder()
        .name("Debit")
        .description("debit")
        .cost(1.52)
        .date(date)
        .time(time)
        .create();
    Transaction expected = Transaction.builder()
        .activityId(debitActivity.id())
        .amount(debitActivity.cost())
        .datetime(LocalDateTime.of(debitActivity.date(), debitActivity.time()))
        .description(debitActivity.description())
        .create();
    assertEquals(expected.type(), Transaction.Type.DEBIT);
  }

  /**
   * Test for Credit Transaction creation.
   */
  @Test
  public void TestCreditTransaction() {
    Transaction expected = Transaction.builder()
        .type(Transaction.Type.CREDIT)
        .datetime(LocalDateTime.of(date, time))
        .description("Credit transaction")
        .amount(Money.of(CurrencyUnit.USD, 6.95))
        .create();
    assertEquals(expected.type(), Transaction.Type.CREDIT);
    assertEquals(expected.date(), date);
    assertEquals(expected.time(), time);
    assertEquals(expected.description(), "Credit transaction");
    assertEquals(expected.amount(), Money.of(CurrencyUnit.USD, 6.95));
  }

  /**
   * Test {@link Activity} attachment.
   */
  @Test
  public void TestTransactionActivity() {

    Activity activity = Activity.builder()
        .name("Debit")
        .description("debit")
        .cost(16.84)
        .date(date)
        .time(time)
        .create();
    Transaction expected = Transaction.builder().from(activity);
    assertEquals(expected.activityId(), activity.id());
    assertEquals(expected.amount(), activity.cost());
    assertEquals(expected.description(), activity.description());
    assertEquals(expected.date(), activity.date());
    assertEquals(expected.time(), activity.time());
    assertEquals(expected.type(), Transaction.Type.DEBIT);
  }
}
