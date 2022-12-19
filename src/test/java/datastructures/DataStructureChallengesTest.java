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

}
