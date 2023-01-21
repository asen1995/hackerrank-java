package online;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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
        int[] input = {3, 3, 1, 0, -2};
        int[] expected = {3, 3, 1, -2, 0};
        assertArrayEquals(expected, onlineChallenge.moveZeroesToEndOfArray(input));
    }
    @Test
    public void moveZeroesToEndOfArraySecondExample() {
        int[] input = {0 ,0 ,3 ,4 ,0 ,4 ,2 };
        int[] expected = {3 ,4 ,4 ,2 ,0 ,0 ,0 };
        assertArrayEquals(expected, onlineChallenge.moveZeroesToEndOfArray(input));
    }

    @Test
    public void mergeSortedArrays() {
        int[] input1 = {1, 3, 4, 5};
        int[] input2 = {2, 6, 7, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, onlineChallenge.mergeSortedArrays(input1, input2));
    }

}
