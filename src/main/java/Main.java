import java.util.Stack;

public class Main {


//    You are given 2 integers. Count the number of all the 1s in the binary representation of the product of two numbers.//
//    Both integers are non-negative.Example: 3 * 7 = 21 (10101).//
//    Therefore, the result should be 3.public int countOnes(int a, int b) {}

    public static void main(String[] args) {

//        System.out.println(new Main().solution("13 DUP 4 POP 5 DUP + DUP + -"));
        System.out.println(new Main().solution("5 POP"));
    }

    public int solution(String S) {

        //
        final String[] sequenceOperations = S.split(" ");

        Stack<Integer> numbersStack = new Stack<>();

        final int machineErrorCode = -1;

        for (String element : sequenceOperations) {

            switch (element.trim()) {

                case "DUP": {

                    if (numbersStack.isEmpty()) {
                        return machineErrorCode;
                    }
                    numbersStack.push(numbersStack.peek());

                    break;
                }
                case "POP": {
                    if (numbersStack.isEmpty()) {
                        return machineErrorCode;
                    }
                    numbersStack.pop();

                    break;
                }
                case "+": {
                    if (numbersStack.size() < 2) {
                        return machineErrorCode;
                    }

                    final Integer tail = numbersStack.pop();
                    final Integer secondToTail = numbersStack.pop();

                    numbersStack.push(tail + secondToTail);
                    break;
                }
                case "-": {

                    if (numbersStack.size() < 2) {
                        return machineErrorCode;
                    }


                    final Integer tail = numbersStack.pop();
                    final Integer secondToTail = numbersStack.pop();

                    numbersStack.push(tail - secondToTail);

                    break;
                }

                default: {
                    try {
                        numbersStack.push(Integer.parseInt(element));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid operation " + element);
                    }
                }


            }


        }

        return numbersStack.isEmpty() ? machineErrorCode : numbersStack.pop();
    }
}
