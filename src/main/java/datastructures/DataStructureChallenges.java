package datastructures;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        int maxSum = Integer.MIN_VALUE;
        final int numberOfArrays = arr.size();

        var collect = Stream.of(3).collect(Collectors.toList());

        var hashmap = Collections.singletonMap(1, 1);

        for (int i = 0; i < numberOfArrays - 2; i++) {

            for (int j = 0; j < numberOfArrays - 2; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1) +
                        arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

        }


        return maxSum;

    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> rotatedList = new ArrayList<>();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            rotatedList.add(arr.get((i + d) % size));
        }
        return rotatedList;
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

        Map<String, Integer> mapOfStrings = new HashMap<>(stringList.size());

        for (String inputString : stringList) {
            if (mapOfStrings.containsKey(inputString)) {
                Integer count = mapOfStrings.get(inputString);
                count += 1;
                mapOfStrings.put(inputString, count);
            } else {
                mapOfStrings.put(inputString, 1);
            }
        }

        List<Integer> result = new LinkedList<>();

        for (String query : queries) {
            result.add(mapOfStrings.getOrDefault(query, 0));
        }

        return result;

    }

    public List<Integer> reverseArray(List<Integer> a) {
        Collections.reverse(a);
        return a;
    }

    public long arrayManipulation(int n, List<List<Integer>> queries) {

        List<Integer> array = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            array.add(0);
        }

        for(List<Integer> query : queries){
            int startIndex = query.get(0) - 1;
            int endIndex = query.get(1);
            int increasedValue = query.get(2);

            for(int i = startIndex ; i < endIndex; i++){
                array.set(i, array.get(i) + increasedValue);
            }
        }

        return array.stream().max(Integer::compareTo).get();
    }

}
