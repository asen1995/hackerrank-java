package datastructures;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DataStructureChallengesTest {

    private final DataStructureChallenges dataStructureChallenges = new DataStructureChallenges();

    @Test
    public void reverseArray() {
        assertEquals(Arrays.asList(2,3,4,1), dataStructureChallenges.reverseArray(Arrays.asList(1, 4, 3, 2)));
    }

    @Test
    public void hourglassSum() {
        assertEquals(19, dataStructureChallenges.hourglassSum(Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0))));
    }
}
