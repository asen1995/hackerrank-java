package algorithums;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlgorithumChallengesTest {


    @Test
    public void testCompareTriplets() {
//        17 28 30
//        99 16 8
//
        final List<Integer> aliceRatings = Arrays.asList(17, 28, 30);
        final List<Integer> bobRatings = Arrays.asList(99, 16, 8);
        AlgorithumChallenges algorithumChallenges = new AlgorithumChallenges();
        final List<Integer> result = algorithumChallenges.compareTriplets(aliceRatings, bobRatings);

//        2 1
        assertEquals(result.get(0), Integer.valueOf(2));
        assertEquals(result.get(2), Integer.valueOf(1));
    }
}
