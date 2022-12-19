package datastructures;

import java.util.Collections;
import java.util.List;

public class DataStructureChallenges {

    public static int hourglassSum(List<List<Integer>> arr) {

//        assertEquals(19, dataStructureChallenges.hourglassSum(Arrays.asList(
//                Arrays.asList(1, 1, 1, 0, 0, 0),
//                Arrays.asList(0, 1, 0, 0, 0, 0),
//                Arrays.asList(1, 1, 1, 0, 0, 0),
//                Arrays.asList(0, 0, 2, 4, 4, 0),
//                Arrays.asList(0, 0, 0, 2, 0, 0),
//                Arrays.asList(0, 0, 1, 2, 4, 0))));
//
        int maxSum = Integer.MIN_VALUE;;

        final int numberOfArrays = arr.size();

        for (int i = 0; i < numberOfArrays - 2; i++) {

            for (int j = 0; j < numberOfArrays - 2; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1) +
                        arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                if(sum > maxSum){
                    maxSum = sum;
                }
            }

        }


        return maxSum;

    }

    public List<Integer> reverseArray(List<Integer> a) {
        Collections.reverse(a);
        return a;
    }
}
