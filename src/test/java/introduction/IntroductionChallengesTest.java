package introduction;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntroductionChallengesTest {



	@Test
	public void currencyConverter() {
		double payment = 12324.134;
		assertTrue(IntroductionChallenges.currencyConverter(payment).equals("SUCCESS"));
	}
	
//	@Test
//	public void calculator() {
//		assertTrue(2.0 == IntroductionChallenges.calculator(1,1,"+"));
//	}
//	

}
