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

    public int myAtoi(String s) {

        int index = 0;
        int sign = 1;
        int total = 0;

        //1. Empty string
        if (s.length() == 0) return 0;

        //2. Remove Spaces
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        if (index == s.length()) return 0;

        //3. Handle signs
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while (index < s.length()) {

            int digit = s.charAt(index) - '0';

            if (digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total ||
                    Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }

        return total * sign;
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
