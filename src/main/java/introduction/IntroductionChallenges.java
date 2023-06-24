package introduction;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;

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

           for(int i = 0 ; i < s.length() - 1; i++){

               for(int j = i + 1 ; j < s.length() ; j++){

                   final String substring = s.substring(i, j);

                   if(isPalidrome(substring) && substring.length() > longestPalidrome.length()){
                       longestPalidrome = substring;
                   }

               }

           }

           return longestPalidrome;
    }

    private boolean isPalidrome(String string) {

        int start = 0;
        int end = string.length() - 1;

        while(start < end){
            //comparing
            if(string.charAt(start) != string.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
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
