package algorithums;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class AlgorithmChallenges {


    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        if (a.size() != 3 || b.size() != 3) {
            throw new IllegalArgumentException("the two arrays needs to have 3 elements each!");
        }

        int aRates = 0, bRates = 0;

        for (int rateIndex = 0; rateIndex < 3; rateIndex++) {
            if (a.get(rateIndex) > b.get(rateIndex)) {
                aRates++;
            } else if (a.get(rateIndex) < b.get(rateIndex)) {
                bRates++;
            }
        }
        return Arrays.asList(aRates, bRates);
    }

    public long aVeryBigSum(List<Long> ar) {
        return ar.stream().mapToLong(Long::longValue).sum();
    }

    public int diagonalDifference(List<List<Integer>> arr) {

        int leftDiagonal = 0, rightDiagonal = 0;
        final int matrixMax = arr.size();

        //3 dimensional array example of diagonals

        //        0 0
        //        1 1
        //        2 2

        //         2 0
        //         1 1
        //         0 2


        for (int iteration = 0, leftDiagonalIndex = 0, rightDiagonalIndex = matrixMax - 1; iteration < matrixMax; iteration++) {

            leftDiagonal += arr.get(leftDiagonalIndex).get(iteration);
            rightDiagonal += arr.get(rightDiagonalIndex).get(iteration);

            leftDiagonalIndex++;
            rightDiagonalIndex--;
        }

        return Math.abs(leftDiagonal - rightDiagonal);
    }


    public void plusMinus(List<Integer> arr) {
        final int arraySize = arr.size();

        int positives = 0, negatives = 0, zeroes = 0;

        for (final Integer number : arr) {
            if (number > 0) {
                positives++;
            } else if (number < 0) {
                negatives++;
            } else {
                zeroes++;
            }
        }

        int roundingOffsets = 5;

        System.out.println(new BigDecimal(Double.toString((double) positives / arraySize)).setScale(roundingOffsets, RoundingMode.HALF_UP));
        System.out.println(new BigDecimal(Double.toString((double) negatives / arraySize)).setScale(roundingOffsets, RoundingMode.HALF_UP));
        System.out.println(new BigDecimal(Double.toString((double) zeroes / arraySize)).setScale(roundingOffsets, RoundingMode.HALF_UP));

    }


    public void staircase(int n) {

        int treeCellsPerRow = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < (n - treeCellsPerRow); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < treeCellsPerRow; j++) {
                System.out.print("#");
            }
            System.out.println();
            treeCellsPerRow++;
        }

        //
        //     #
        //    ##
        //   ###
        //  ####
        // #####
        //######
    }

    public void miniMaxSum(List<Integer> arr) {

        long min = Long.MAX_VALUE, max = Long.MIN_VALUE, sum = 0;

        for (final Integer number : arr) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        System.out.println((sum - max) + " " + (sum - min));
    }

    public int birthdayCakeCandles(List<Integer> candles) {

        //        3 2 1 3

        int maxCandleSize = 0, maxHeightCount = 0;

        for (final Integer currentCandle : candles) {

            if (currentCandle > maxCandleSize) {
                maxCandleSize = currentCandle;
                maxHeightCount = 1;
            } else if (currentCandle == maxCandleSize) {
                maxHeightCount++;
            }

        }

        return maxHeightCount;
    }

    public String timeConversion(String s) {

        if (!s.endsWith("AM") && !s.endsWith("PM")) {
            throw new IllegalArgumentException("the time format is not valid!");
        }

        boolean isAM = s.endsWith("AM");
        final String[] hms = s.replace("PM", "").replace("AM", "").split(":");

        if (hms.length != 3) {
            throw new IllegalArgumentException("the time format is not valid!");
        }
        if (hms[0].equals("12")) {
            if (isAM) {
                hms[0] = "00";
            }else{
                hms[0] = "12";
            }
        } else {
            hms[0] = String.valueOf(Integer.parseInt(hms[0]) + 12);
        }

        return String.join(":", hms);
    }
}
