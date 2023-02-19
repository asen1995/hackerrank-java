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
                Pattern compile = Pattern.compile(regex);
                System.out.println("Valid");

            } catch (java.util.regex.PatternSyntaxException e) {
                System.out.println("Invalid"); // if pattern compile throws exception, the regex is invalid
            }
        }

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

    public static void removeTagsFromSentence(String line) {

        String regexForMatchingTags = "<(.+)>(([^<>]+))</\\1>";

        Matcher m = Pattern.compile(regexForMatchingTags).matcher(line);

        if (!m.find()) {
            System.out.println("None");
        }

        m.reset();
        while (m.find()) {
            System.out.println(m.group(2)); // prints the content of html tags
        }
    }


    public void testSpeedOfString(){
        {


            final int n = 100000;

            long start = System.currentTimeMillis();

            String string = "a";
            for(int i = 0; i< n; i++) {
                string = string + "a";
            }

            long end = System.currentTimeMillis();
            System.out.println("String concatenation took " + (end-start) + " ms");



            String formatString = "a%s";

            start = System.currentTimeMillis();

            for(int i = 0; i< n; i++) {
                formatString = String.format(formatString, "a%s");
            }

            end = System.currentTimeMillis();

            System.out.println("String format took " + (end-start) + " ms");


            StringBuilder sb = new StringBuilder("a");
            start = System.currentTimeMillis();

            for(int i = 0; i< n; i++) {
                sb.append("a");
            }

            end = System.currentTimeMillis();
            System.out.println("StringBuilder took " + (end-start) + " ms");


            StringBuffer sbf = new StringBuffer("a");
            start = System.currentTimeMillis();

            for(int i = 0; i< n; i++) {
                sbf.append("a");
            }

            end = System.currentTimeMillis();
            System.out.println("StringBuffer took " + (end-start) + " ms");

        }
    }


    public int[] getArrayWithNumbers(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }


    public static void main(String[] args) {
        StringsChallenges stringsChallenges = new StringsChallenges();
        stringsChallenges.testSpeedOfString();
    }




}
