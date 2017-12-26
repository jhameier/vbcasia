package facets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.vbc4me.awanna.facets.Club;

/**
 * Test class for {@link Club}.
 */
public class TestClub {
	
	/**
	 * Test that all enum values return correctly.
	 */
	@Test
	public void TestClubCreation() {
		Club puggles = Club.PUGGLES; 
		Club cubbies = Club.CUBBIES;
		Club sparks = Club.SPARKS;
		Club tandt = Club.TANDT;
		Club trek = Club.TREK;
		Club journey = Club.JOURNEY;
		assertEquals("Puggles", puggles.getName());
		assertEquals("Cubbies", cubbies.getName());
		assertEquals("Sparks", sparks.getName());
		assertEquals("T&T", tandt.getName());
		assertEquals("Trek", trek.getName());
		assertEquals("Journey", journey.getName());
	}
	
	@Test
	public void TestClubNamesExist() {
		assertEquals(Club.PUGGLES, Club.get("Puggles"));
		assertEquals(Club.CUBBIES, Club.get("Cubbies"));
		assertEquals(Club.SPARKS, Club.get("Sparks"));
		assertEquals(Club.TANDT, Club.get("T&T"));
		assertEquals(Club.TREK, Club.get("Trek"));
		assertEquals(Club.JOURNEY, Club.get("Journey"));
	}
	
}
