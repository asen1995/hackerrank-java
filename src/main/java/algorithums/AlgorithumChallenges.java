package algorithums;

import java.util.Arrays;
import java.util.List;

public class AlgorithumChallenges {


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
        final int matrixMax = 3;

        //        0 0
        //        1 1
        //        2 2

        //         2 0
        //         1 1
        //         0 2


        for (int i = 0, j = 0; i < matrixMax; i++, j++) {
            leftDiagonal += arr.get(i).get(j);
        }

        for (int i = matrixMax - 1, j = 0; i >= 0; i--, j++) {
            rightDiagonal += arr.get(i).get(j);
        }

        return Math.abs(leftDiagonal - rightDiagonal);
    }
}
