package algorithums;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommonAlgorithmTest {

    final CommonAlgorithm commonAlgorithms = new CommonAlgorithm();

    @Test
    public void binarySearch() {
        assertEquals(8, commonAlgorithms.binarySearch(66, Arrays.asList(4, 66, 44, 33, 22, 77, 55, 2, 34, 37)));
    }
    @Test
    public void binarySearchNonExistent() {
        assertEquals(-1, commonAlgorithms.binarySearch(56, Arrays.asList(4, 66, 44, 33, 22, 77, 55, 2, 34, 37)));
    }

    @Test
    public void isPalidrome() {
        assertTrue(commonAlgorithms.isPalidrome("racecar"));
    }

}
