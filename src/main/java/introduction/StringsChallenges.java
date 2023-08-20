package introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsChallenges {


    //examples of ANAGRAM is   CAT = ACT , elbow = below
    static boolean isAnagram(String a, String b) {

        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        //upperCase both words for easier comparing
        String firstWord = a.toUpperCase();
        StringBuilder secondWord = new StringBuilder(b.toUpperCase());

        for (int i = 0; i < firstWord.length(); i++) {

            String letter = String.valueOf(firstWord.charAt(i)).toUpperCase();
            int indexOfLetterInsideStringBuilder = secondWord.indexOf(letter);
            if (indexOfLetterInsideStringBuilder != -1) {
                secondWord.deleteCharAt(indexOfLetterInsideStringBuilder);
            } else {
                return false;
            }

        }
        return true;
    }

    //we need to print all tokens from string sentence and split them by space and special characters
    public static void splitStringIntoTokens(String s) {

        String trimmedSentense = s.trim();

        if (trimmedSentense == null || trimmedSentense.isEmpty()) {
            System.out.println("0");

        } else {

            String rexeg = "[! ,?._'@]+"; // split by all this characters

            String[] splitWordsFromSentence = trimmedSentense.split(rexeg);
            System.out.println(splitWordsFromSentence.length);
            for (String splittedString : splitWordsFromSentence) {
                System.out.println(splittedString);
            }

        }
    }


    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        int lenght = 0;

        smallest = s.substring(lenght, lenght + k);
        lenght++;

        while ((lenght + k) < s.length() - 1) {
            String secondStringForCompare = s.substring(lenght, lenght + k);
            if (secondStringForCompare.compareTo(smallest) < 0) { // smaller
                smallest = secondStringForCompare;
            }
            lenght++;
        }

        return smallest + "\n" + largest;
    }

    //check if its a valid regex pattern
    public static void isItAValidPattern(List<String> listOfRegularExpressions) {
        List<String> listOfRegularExdpressions = new ArrayList();
        for (String regex : listOfRegularExpressions) {

            try {
                getCompile(regex);
                System.out.println("Valid");

            } catch (java.util.regex.PatternSyntaxException e) {
                System.out.println("Invalid"); // if pattern compile throws exception, the regex is invalid
            }
        }

    }

    private static Pattern getCompile(String regex) {
        return Pattern.compile(regex);
    }

    public static String removeDuplicateWords(String sentence) {
        String regexMatchingDuplicateWords = "\\b(\\w+)(\\s+\\1\\b)*";

        Pattern p = Pattern.compile(regexMatchingDuplicateWords, Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(sentence);

        while (m.find()) {
            sentence = sentence.replaceAll(m.group(0), m.group(1));
        }
        return sentence;

    }

    public void removeTagsFromSentence(String line) {

        String regexForMatchingTags = "<(.+)>([^<]+)</\\1>";

        Pattern p = Pattern.compile(regexForMatchingTags);


        Matcher m = p.matcher(line);
        boolean found = false;
        while (m.find()) {
            line = line.replaceAll(m.group(0), m.group(2));
            found = true;
        }
        if (!found) {
            System.out.println("None");
        } else {
            System.out.println(line);
        }

    }

    public String getPoints(String[] games) {
        int points = 0;
        for (String game : games) {
            String[] split = game.split(":");
            int firstTeam = Integer.parseInt(split[0]);
            int secondTeam = Integer.parseInt(split[1]);
            if (firstTeam > secondTeam) {
                points += 3;
            } else if (firstTeam == secondTeam) {
                points += 1;
            }
        }
        return String.valueOf(points);
    }

    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private void merge(int[] array, int[] left, int[] right) {
        int a = 0;
        int b = 0;
        int c = 0;

        while (a < left.length && b < right.length) {
            if (left[a] < right[b]) {
                array[c] = left[a];
                a++;
            } else {
                array[c] = right[b];
                b++;
            }
            c++;
        }

        while (a < left.length) {
            array[c] = left[a];
            a++;
            c++;
        }

        while (b < right.length) {
            array[c] = right[b];
            b++;
            c++;
        }
    }

    private int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    private int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
}

