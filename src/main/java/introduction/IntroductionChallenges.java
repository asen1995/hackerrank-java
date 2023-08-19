package introduction;

import model.BracketValidator;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class IntroductionChallenges {

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
}
