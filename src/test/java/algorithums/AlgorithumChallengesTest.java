package algorithums;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlgorithumChallengesTest {


    private final AlgorithumChallenges algorithumChallenges = new AlgorithumChallenges();

    @Test
    public void testCompareTriplets() {

        //        Sample Input
        //        17 28 30
        //        99 16 8

        final List<Integer> aliceRatings = Arrays.asList(17, 28, 30);
        final List<Integer> bobRatings = Arrays.asList(99, 16, 8);
        final List<Integer> result = algorithumChallenges.compareTriplets(aliceRatings, bobRatings);


        //      Sample Output
        //        2 1
        assertEquals(result.get(0), Integer.valueOf(2));
        assertEquals(result.get(1), Integer.valueOf(1));
    }

    @Test
    public void aVeryBigSum() {

        //Sample Input
        //1000000001 1000000002 1000000003 1000000004 1000000005

        //Output 5000000015

        final List<Long> inputLongNumbers = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        final long result = algorithumChallenges.aVeryBigSum(inputLongNumbers);

        assertEquals(5000000015L, result);
    }

}
