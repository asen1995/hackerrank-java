package algorithums;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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

    public static String dayOfProgrammer(int year) {

        //                 visokostna
       // 1918 >  12.09 or 13.09
       // 1918 < 26.09 or 27.09

       int day = 0;

       if(year == 1918 ){
           day = 26;
       }else {

           day = (year % 4 == 0)? 12 : 13;
       }

       return String.format("%d.09.%d", day, year);
    }
}
