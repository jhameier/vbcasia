package facets;

import org.junit.Test;
import org.vbc4me.awanna.facets.Club;

import junit.framework.Assert;

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
		Assert.assertEquals("Puggles", puggles.getName());
		Assert.assertEquals("Cubbies", cubbies.getName());
		Assert.assertEquals("Sparks", sparks.getName());
		Assert.assertEquals("T&T", tandt.getName());
		Assert.assertEquals("Trek", trek.getName());
		Assert.assertEquals("Journey", journey.getName());
	}
	
	@Test
	public void TestClubNamesExist() {
		Assert.assertEquals(Club.PUGGLES, Club.get("Puggles"));
		Assert.assertEquals(Club.CUBBIES, Club.get("Cubbies"));
		Assert.assertEquals(Club.SPARKS, Club.get("Sparks"));
		Assert.assertEquals(Club.TANDT, Club.get("T&T"));
		Assert.assertEquals(Club.TREK, Club.get("Trek"));
		Assert.assertEquals(Club.JOURNEY, Club.get("Journey"));
	}
	
}
