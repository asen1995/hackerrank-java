package algorithums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AlgorithmChallengesTest {


    private final AlgorithmChallenges algorithmChallenges = new AlgorithmChallenges();

    @Test
    public void testCompareTriplets() {

        //        Sample Input
        //        17 28 30
        //        99 16 8

        final List<Integer> aliceRatings = Arrays.asList(17, 28, 30);
        final List<Integer> bobRatings = Arrays.asList(99, 16, 8);
        final List<Integer> result = algorithmChallenges.compareTriplets(aliceRatings, bobRatings);


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
        final long result = algorithmChallenges.aVeryBigSum(inputLongNumbers);

        assertEquals(5000000015L, result);
    }


    @Test
    public void diagonalDifference() {

        //        Sample Input
        //
        //        3
        //        11 2 4
        //        4 5 6
        //        10 8 -12

        //  sample output
        //15

        List<List<Integer>> arr = new ArrayList<>(3);

        arr.add(Arrays.asList(11, 2, 4));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(10, 8, -12));

        final int result = algorithmChallenges.diagonalDifference(arr);

        assertEquals(15, result);
    }


    @Test
    public void plusMinus() {

//        Sample Input
//        -4 3 -9 0 4 1


//        Sample Output
//
//        0.500000
//        0.333333
//        0.166667
        final List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);
        algorithmChallenges.plusMinus(arr);


    }


    @Test
    public void stairCase() {

        //print stairCase

        //
        //     #
        //    ##
        //   ###
        //  ####
        // #####
        //######
        algorithmChallenges.staircase(6);

    }

    @Test
    public void minMaxSum() {

//        Sample Input
//
//        1 2 3 4 5
//
//        Sample Output
//
//        10 14

        algorithmChallenges.miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void birthdayCakeCandles() {
        //        Sample Input 0
        //
        //        4
        //        3 2 1 3
        //
        //        Sample Output 0
        //
        //        2

        final int result = algorithmChallenges.birthdayCakeCandles(Arrays.asList(3, 2, 1, 3));
        assertEquals(2, result);
    }

    @Test
    public void timeConversion() {
        //        Sample Input 0
        //
        //        07:05:45PM
        //
        //        Sample Output 0
        //
        //        19:05:45

        final String result = algorithmChallenges.timeConversion("07:05:45PM");
        assertEquals("19:05:45", result);
    }

    @Test
    public void timeConversionAM() {
        //        Sample Input 0
        //
        //        12:05:39AM
        //
        //        Sample Output 0
        //
        //        00:05:39

        final String result = algorithmChallenges.timeConversion("12:05:39AM");
        assertEquals("00:05:39", result);
    }

    @Test
    public void countApplesAndOranges() {
        algorithmChallenges.countApplesAndOranges(7, 11, 5, 15, Arrays.asList(-2, 2, 1), Arrays.asList(5, -6));
    }

    @Test
    public void gradingStudents() {
        algorithmChallenges.gradingStudents(Arrays.asList(73, 67, 38, 33));
    }

    @Test
    public void kangaroo() {
        //        Sample Input 0
        //
        //        0 3 4 2
        //
        //        Sample Output 0
        //
        //        YES

        final String result = algorithmChallenges.kangaroo(0, 3, 4, 2);
        assertEquals("YES", result);
    }

    @Test
    public void getTotalX() {
        algorithmChallenges.getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96));
    }

    @Test
    public void breakingRecords() {
        assertEquals(Arrays.asList(2, 4), algorithmChallenges.breakingRecords(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1)));
    }

    @Test
    public void birthday() {
        assertEquals(2, algorithmChallenges.birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2));
    }

    @Test
    public void divisibleSumPairs() {
        assertEquals(5, algorithmChallenges.divisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));
        assertEquals(3, algorithmChallenges.divisibleSumPairs(6, 5, Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void solution() {
        //assertEquals("a", algorithmChallenges.solution("aba"));
        assertEquals("i", algorithmChallenges.solution("codility"));
    }

    @Test
    public void migratoryBirds() {
        assertEquals(4, algorithmChallenges.migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3)));
    }

    @Test
    public void dayOfProgrammer() {
        assertEquals("12.09.2016", algorithmChallenges.dayOfProgrammer(2016));
        assertEquals("13.09.2017", algorithmChallenges.dayOfProgrammer(2017));
        assertEquals("12.09.2019", algorithmChallenges.dayOfProgrammer(2019));
        assertEquals("12.09.2020", algorithmChallenges.dayOfProgrammer(2020));
    }

    @Test
    public void bonAppetit() {
        algorithmChallenges.bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
    }

    @Test
    public void sockMerchant() {
        assertEquals(3, algorithmChallenges.sockMerchant(9, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }

    @Test
    public void pageCount() {
        assertEquals(1, algorithmChallenges.pageCount(6, 2));
        assertEquals(0, algorithmChallenges.pageCount(5, 4));
    }

    @Test
    public void selectionSort() {
        assertArrayEquals(algorithmChallenges.selectionSort(new int[]{5, 321, 543, 5464, 7, 8, 99, 4, 3, 2, 1}), new int[]{1, 2, 3, 4, 5, 7, 8, 99, 321, 543, 5464});
    }

    @Test
    public void reverseString() {
        assertEquals("olleh", algorithmChallenges.reverseString("hello"));
    }
}
