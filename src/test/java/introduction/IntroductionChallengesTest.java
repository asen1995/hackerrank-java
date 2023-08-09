package introduction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntroductionChallengesTest {

	@Test
	public void testingValidBrackets() {
		IntroductionChallenges introductionChallenges = new IntroductionChallenges();
		final boolean itValidBracket = introductionChallenges.isItValidBracket("()[]{}");
		assertTrue(itValidBracket);
	}

	@Test
	public void testingInvalidBrackets() {
		IntroductionChallenges introductionChallenges = new IntroductionChallenges();
		final boolean itValidBracket = introductionChallenges.isItValidBracket("([)]");
		assertFalse(itValidBracket);
	}

	@Test
	public void testingFactorial() {
		IntroductionChallenges introductionChallenges = new IntroductionChallenges();
		final int factorial = introductionChallenges.factorial(3);
		assertTrue(factorial == 6);
	}

}
