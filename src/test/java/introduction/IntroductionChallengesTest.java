package introduction;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntroductionChallengesTest {

	@Test
	public void findDayOfWeek() {
		String day = IntroductionChallenges.findDayOfWeek(8, 14, 2017);

		assertTrue(day.equals("MONDAY"));

		String test2 = IntroductionChallenges.findDayOfWeek(2, 6, 2022);

		assertTrue(test2.equals("SUNDAY"));

	}

	@Test
	public void currencyConverter() {
		double payment = 12324.134;
		assertTrue(IntroductionChallenges.currencyConverter(payment).equals("SUCCESS"));
	}
	
	@Test
	public void calculator() {
		assertTrue(0.0 == IntroductionChallenges.calculator(1,1,"+"));
	}
	

}
