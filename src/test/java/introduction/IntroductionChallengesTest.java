package introduction;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntroductionChallengesTest {

	@Test
	public void generateInvoiceNumber() {
		String day = IntroductionChallenges.findDay(8, 14, 2017);
		
		assertTrue(day.equals("MONDAY"));
		
	}
}
