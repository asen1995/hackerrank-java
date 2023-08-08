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

    int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }


    int calculateSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calculateSum(n - 1);
    }
}
