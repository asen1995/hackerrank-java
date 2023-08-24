package introduction;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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


}
