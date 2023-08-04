package model;

import java.util.List;
import java.util.Stack;

public class BracketValidator {

    private final List<Character> openingBrackets;

    public BracketValidator() {
        openingBrackets = new Stack<>();
    }

    public boolean isValid(String input) {

        for (Character character : input.toCharArray()) {

            switch (character) {
                case ')': {
                    if (thereIsNoOpeningBracketsInTheStack(openingBrackets)) return false;
                    removeFromTailIfExists('(', openingBrackets);
                    break;
                }
                case ']': {

                    if (thereIsNoOpeningBracketsInTheStack(openingBrackets)) return false;
                    removeFromTailIfExists('[', openingBrackets);
                    break;
                }
                case '}': {
                    if (thereIsNoOpeningBracketsInTheStack(openingBrackets)) return false;
                    removeFromTailIfExists('{', openingBrackets);
                    break;
                }
                default: {
                    openingBrackets.add(character);
                }

            }


        }

        if (!thereIsNoOpeningBracketsInTheStack(openingBrackets)) return false;

        return true;

    }

    private boolean thereIsNoOpeningBracketsInTheStack(List<Character> openingBrackets) {
        return openingBrackets.isEmpty();
    }

    private void removeFromTailIfExists(Character closingBracket, List<Character> openingBrackets) {
        if (openingBrackets.get(openingBrackets.size() - 1).equals(closingBracket)) {
            openingBrackets.remove(openingBrackets.size() - 1);
        }
    }

}
