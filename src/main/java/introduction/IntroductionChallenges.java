package introduction;

import model.BracketValidator;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class IntroductionChallenges {


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

    public boolean isItValidBracket(String input) {
        BracketValidator bracketValidator = new BracketValidator();
        return bracketValidator.isValid(input);
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

    int calculateSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calculateSum(n - 1);
    }

    int calculateSum(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        return list.get(0) + calculateSum(list.subList(1, list.size()));
    }


    int calculateSum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        return array[0] + calculateSum(subArray(array));
    }

    private int[] subArray(int[] array) {
        int[] subArray = new int[array.length - 1];
        System.arraycopy(array, 1, subArray, 0, array.length - 1);
        return subArray;
    }

    int calculateSum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }
        return array[index] + calculateSum(array, index + 1);
    }


}
