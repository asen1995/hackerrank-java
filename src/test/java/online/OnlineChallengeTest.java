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
        int[] input = {0, 0, 3, 4, 0, 4, 2};
        int[] expected = {3, 4, 4, 2, 0, 0, 0};
        assertArrayEquals(expected, onlineChallenge.moveZeroesToEndOfArray(input));
    }


    @Test
    public void AESEncryptionTest() throws Exception {
        String input = "abc";

        String expected = "muBf811uywyOj1MhILpyfw==";
        AESEncryption aesEncryption = new AESEncryption();
        String actual = aesEncryption.encrypt(input);

        assertArrayEquals(expected.toCharArray(), actual.toCharArray());
    }

    @Test
    public void AESDecryptionTest() throws Exception {

        String input = "muBf811uywyOj1MhILpyfw==";
        String expected = "abc";

        AESEncryption aesEncryption = new AESEncryption();
        String actual = aesEncryption.decrypt(input);

        assertArrayEquals(expected.toCharArray(), actual.toCharArray());
    }
}
