package facets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;
import org.vbc4me.awanna.facets.Activity;

public class TestActivity {
	private LocalDate date = LocalDate.now();
	private LocalTime time = LocalTime.now();
	/**
	 * Test {@link Activity} construction
	 */
	@Test
	public void TestActivityBuild() {
		Activity activity = Activity.builder().name("Test1").description("test1").cost(1.23).date(date).time(time).create();
		assertEquals("Test1", activity.name());
		assertEquals(activity.cost(), Money.of(CurrencyUnit.USD, 1.23));
		assertEquals(date, activity.date());
		assertEquals(time, activity.time());
	}
	
	/**
	 * Test {@link Activity} name exception
	 */
	@Test (expected = NullPointerException.class)
	public void TestActivityNameThrows() {
		@SuppressWarnings("unused")
		Activity activity = Activity.builder().cost(1.23).date(date).time(time).create();
	}
	
	/**
	 * Test {@link Activity} cost exception
	 */
	@Test (expected = NullPointerException.class)
	public void TestActivityCostThrows() {
		@SuppressWarnings("unused")
		Activity activity = Activity.builder().name("Test").date(date).time(time).create();
	}
	
	/**
	 * Test {@link Activity} date exception
	 */
	@Test (expected = NullPointerException.class)
	public void TestActivityDateThrows() {
		@SuppressWarnings("unused")
		Activity activity = Activity.builder().name("Test").cost(1.23).time(time).create();
	}
	
	/**
	 * Test {@link Activity} time exception
	 */
	@Test (expected = NullPointerException.class)
	public void TestActivityTimeThrows() {
		@SuppressWarnings("unused")
		Activity activity = Activity.builder().name("Test").cost(1.23).date(date).create();
	}
	
	/**
	 * Test {@link 	Activity #equals(Object)}.
	 */
	@Test
	public void TestIsEqualTo() {
		Activity expected = Activity.builder().name("Test1").description("test1").cost(1.23).date(date).time(time).create();
		Activity actual = null;		
		try {
			actual = expected.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		assertFalse(expected.equals(actual));
		assertTrue(expected.isEqualTo(actual));
	}
	
	/**
	 * Test {@link Activity #createActivities(double, LocalTime, double)} throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestCreateActivitiesMissingDateThrows() {
		Activity.createActivities(null, 20, time, 1.23);
	}
	
	/**
	 * Test {@link Activity #createActivities(LocalDate, LocalTime, double)} throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestCreateActivitiesMissingWeeksThrows() {
		Activity.createActivities(date, new Double(null), time, 2.34);
	}
	
	/**
	 * Test {@link Activity #createActivities(LocalDate, double, double)} throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestCreateActivitiesMissingTimeThrows() {
		Activity.createActivities(date, 20, null, 3.45);
	}
	
	/**
	 * Test {@link Activity #createActivities(LocalDate, double, LocalTime)} throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestCreateActivitiesMissingCostThrows() {
		Activity.createActivities(date, 25, time, new Double(null));
	}
	
	/**
	 * Test {@link Activity #createActivities(LocalDate, double, LocalTime, double)}.
	 */
	@Test
	public void TestCreateActivities() {
		Map<LocalDate, Activity> activities = Activity.createActivities(date, 20, time, 1.59);
		assertEquals(20, activities.size());
		SortedSet<LocalDate> keys = new TreeSet<>(activities.keySet());
		Iterator<LocalDate> key = keys.iterator();
		int week = -1;
		while(key.hasNext()) {
			week++;
			Activity activity = activities.get(key.next());
			assertEquals(date.plusWeeks(week), activity.date());
			assertEquals(time, activity.time());
			assertEquals(new BigDecimal(1.59).setScale(2, BigDecimal.ROUND_HALF_UP), activity.cost().getAmount());
			assertEquals("Activity " + week, activity.name());
		}
	}
}
