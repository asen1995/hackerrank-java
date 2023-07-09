package introduction;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Stack;
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
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://en.wikipedia.org/wiki/"))
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        responseFuture.thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

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

    int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);

    }
}
