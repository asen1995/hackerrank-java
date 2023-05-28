package algorithums;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class AlgorithmChallenges {


    public String dayOfProgrammer(int year) {

        if (year < 1700 || year > 2700) {
            throw new IllegalArgumentException("Invalid year");
        }

        if (year == 1918) {
            return "26.09.1918";
        }

        if (year < 1918) {
            if (year % 4 == 0) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        } else {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        }
    }

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

        boolean isAM = s.endsWith("AM");

        s = s.replace("AM", "").replace("PM", "");

        String[] timeParts = s.split(":");

        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        if (isAM) {
            if (hours == 12) {
                hours = 0;
            }
        } else {
            if (hours != 12) {
                hours += 12;
            }
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> roundedGrades = new ArrayList<>();

        for (Integer grade : grades) {
            if (grade >= 38) {
                int nextMultipleOfFile = grade;
                while (nextMultipleOfFile % 5 != 0) {
                    nextMultipleOfFile++;
                }
                roundedGrades.add(((nextMultipleOfFile - grade) < 3) ? nextMultipleOfFile : grade);
            } else {
                roundedGrades.add(grade);
            }
        }

        return roundedGrades;
    }

    public void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

        int applesOnHouse = 0, orangesOnHouse = 0;

        for (final Integer apple : apples) {
            if (apple + a >= s && apple + a <= t) {
                applesOnHouse++;
            }
        }

        for (final Integer orange : oranges) {
            if (orange + b >= s && orange + b <= t) {
                orangesOnHouse++;
            }
        }

        System.out.println(applesOnHouse);
        System.out.println(orangesOnHouse);

    }

    public String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 > v2) {
            int distance = x1 - x2;
            //  0 - 4 = -4
            int speed = v1 - v2;
            //  3 - 2 = 1
            if (distance % speed == 0) {
                //  -4 % 1 == 0
                return "YES";
            }
        }
        return "NO";
    }

    public int getTotalX(List<Integer> a, List<Integer> b) {

        int totalX = 0;

        for (int i = 1; i <= 100; i++) {

            boolean isFactor = true;

            for (final Integer number : a) {
                if (i % number != 0) {
                    isFactor = false;
                    break;
                }
            }

            if (isFactor) {
                for (final Integer number : b) {
                    if (number % i != 0) {
                        isFactor = false;
                        break;
                    }
                }
            }

            if (isFactor) {
                totalX++;
            }
        }

        return totalX;

    }

    public List<Integer> breakingRecords(List<Integer> scores) {

        int breakingBestRecords = 0, breakingWorstRecord = 0;

        int bestRecord = scores.get(0);
        int worstRecord = scores.get(0);

        for (int scoreIndex = 1; scoreIndex < scores.size(); scoreIndex++) {

            final Integer score = scores.get(scoreIndex);

            if (score > bestRecord) {

                bestRecord = score;
                breakingBestRecords++;

            } else if (score < worstRecord) {
                breakingWorstRecord++;
                worstRecord = score;
            }

        }

        return Arrays.asList(breakingBestRecords, breakingWorstRecord);
    }

    public int birthday(List<Integer> s, int d, int m) {

        int totalWays = 0;

        for (int i = 0; i < s.size(); i++) {

            int sum = 0;

            for (int j = i; j < i + m; j++) {
                if (j < s.size()) {
                    sum += s.get(j);
                }
            }

            if (sum == d) {
                totalWays++;
            }

        }

        return totalWays;
    }

    public int divisibleSumPairs(int n, int k, List<Integer> ar) {

        int divisibleSubPairs = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                final Integer firstNumber = ar.get(i);
                final Integer secondNumber = ar.get(j);

                if (((firstNumber + secondNumber) % k == 0)) {
                    divisibleSubPairs++;
                }

            }

        }


        return divisibleSubPairs;
    }

    public String solution(String S) {

        if (S == null || S.length() < 2) {
            throw new IllegalStateException("Invalid input");
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            final Character currentChar = S.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, currentChar);
            } else return String.valueOf(currentChar);
        }

        throw new IllegalArgumentException("No duplicate found");
    }

    public int migratoryBirds(List<Integer> arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (final Integer bird : arr) {
            if (!map.containsKey(bird)) {
                map.put(bird, 1);
            } else {
                map.put(bird, map.get(bird) + 1);
            }
        }

        int maxCount = 0, maxBird = 0;

        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxBird = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                if (entry.getKey() < maxBird) {
                    maxBird = entry.getKey();
                }
            }
        }

        return maxBird;
    }


    public void bonAppetit(List<Integer> bill, int k, int b) {

        //b - what brian bill Anna
        //k - what Anna decided not to eat

        int annaWillNotEatMealIndex = bill.get(k);
        int sumToBePayedByEachPerson = (bill.stream().mapToInt(Integer::intValue).sum() - annaWillNotEatMealIndex) / 2;

        if (sumToBePayedByEachPerson == b) {
            System.out.print("Bon Appetit");
        } else {
            System.out.println((b - sumToBePayedByEachPerson));
        }

    }

    public int sockMerchant(int n, List<Integer> ar) {

        // number of sock pairs

        int numberOfPairs = 0;

        Map<Integer, Integer> socksColorMap = new HashMap<>();

        for (Integer sockColor : ar) {
            if (socksColorMap.containsKey(sockColor)) {
                numberOfPairs++;
                socksColorMap.remove(sockColor);

            } else {
                socksColorMap.put(sockColor, 1);
            }
        }


        return numberOfPairs;
    }


    public int pageCount(int numberOfPages, int searchedPageNumber) {

        int numberOfTurnsFromFront = 0;
        int numberOfTurnsFromBack = 0;

        if (searchedPageNumber == 1 || searchedPageNumber == numberOfPages) {
            return 0;
        }

        if (searchedPageNumber % 2 == 0) {
            numberOfTurnsFromFront = searchedPageNumber / 2;
        } else {
            numberOfTurnsFromFront = (searchedPageNumber - 1) / 2;
        }

        if (numberOfPages % 2 == 0) {
            if (searchedPageNumber % 2 == 0) {
                numberOfTurnsFromBack = (numberOfPages - searchedPageNumber) / 2;
            } else {
                numberOfTurnsFromBack = (numberOfPages - searchedPageNumber + 1) / 2;
            }
        } else {
            numberOfTurnsFromBack = (numberOfPages - searchedPageNumber) / 2;
        }

        return Math.min(numberOfTurnsFromFront, numberOfTurnsFromBack);
    }

    public int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }


    public int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }


    public int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public String reverseStringRecursion(String string) {

        if (string.length() == 1) {
            return string;
        }
        return reverseStringRecursion(string.substring(1, string.length())) + string.charAt(0);
    }

    public String reverseString(String string) {

        if (string == null || string.isEmpty() || string.length() == 1) return string;

        int left = 0;
        int right = string.length() - 1;

        char[] charArray = string.toCharArray();

        while (left < right) {

            final char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;

        }

        return new String(charArray);
    }

    public int binarySearch(int[] array, int i) {

        if (array.length == 0) return -1;

        int left = 0;
        int right = array.length - 1;


        while (left <= right) {


            int middle = (left + right) / 2;

            if (array[middle] == i) {
                return middle;
            }

            if (i > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }


        return -1;


    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public String buildPalindrome(String st) {
        String reverse = new StringBuilder(st).reverse().toString();
        String palindrome = st;
        int i = 0;
        while (!palindrome.equals(reverse)) {
            palindrome = st + reverse.substring(reverse.length() - i);
            reverse = new StringBuilder(palindrome).reverse().toString();
            i++;
        }
        return palindrome;
    }


    int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        return sum - arrSum;
    }
}
