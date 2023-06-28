package introduction;

import java.util.List;
import java.util.Stack;

public class IntroductionChallenges {


    private static boolean isItValidBracket(String input) {

        List<Character> openingBrackets = new Stack<>();

        for (Character character : input.toCharArray()) {

            switch (character) {
                case ')': {
                    if (openingBrackets.isEmpty()) return false;
                    removeFromTailIfExists('(', openingBrackets);
                    break;
                }
                case ']': {

                    if (openingBrackets.isEmpty()) return false;
                    removeFromTailIfExists('[', openingBrackets);
                    break;
                }
                case '}': {
                    if (openingBrackets.isEmpty()) return false;
                    removeFromTailIfExists('{', openingBrackets);
                    break;
                }
                default: {
                    openingBrackets.add(character);
                }

            }


        }

        if (!openingBrackets.isEmpty()) return false;

        return true;
    }

    private static void removeFromTailIfExists(Character closingBracket, List<Character> openingBrackets) {
        if (openingBrackets.get(openingBrackets.size() - 1).equals(closingBracket)) {
            openingBrackets.remove(openingBrackets.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new IntroductionChallenges().longestPalindrome("babad"));

    }

    public String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        String longestPalidrome = "";

        for (int i = 0; i < s.length() - 1; i++) {

            for (int j = i + 1; j < s.length(); j++) {

                final String substring = s.substring(i, j);

                if (isPalidrome(substring) && substring.length() > longestPalidrome.length()) {
                    longestPalidrome = substring;
                }

            }

        }

        return longestPalidrome;
    }

    private boolean isPalidrome(String string) {

        int start = 0;
        int end = string.length() - 1;

        while (start < end) {
            //comparing
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public int reverse(int x) {

        int reversed = 0;

        while (x != 0) {

            int pop = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            reversed = reversed * 10 + pop;

        }

        return reversed;
    }

    int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }

    int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    int digitSum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + digitSum(n / 10);

    }


    int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);

    }

}
