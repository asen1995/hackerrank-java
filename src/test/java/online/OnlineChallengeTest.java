package online;

import org.junit.Test;

import static org.junit.Assert.*;

public class OnlineChallengeTest {

    private OnlineChallenge onlineChallenge = new OnlineChallenge();

    @Test
    public void arrayOfArrayProducts() {
        int[] input = {8, 10, 2};
        int[] expected = {20, 16, 80};
        assertArrayEquals(expected, onlineChallenge.arrayOfArrayProducts(input));
    }

    @Test
    public void moveZeroesToEndOfArray() {
        int[] input = {0, 3, 1, 0, -2};
        int[] expected = {3, 1, -2, 0, 0};
        assertArrayEquals(expected, onlineChallenge.moveZeroesToEndOfArray(input));
    }

}
