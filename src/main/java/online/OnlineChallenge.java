package online;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineChallenge {

    static int[] arrayOfArrayProducts(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            // no values to multiply if n equals to 0 or 1
            return new int[]{};
        }

        int[] productArr = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            productArr[i] = product;
            product *= arr[i];
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            productArr[i] *= product;
            product *= arr[i];
        }

        return productArr;
    }

    static int[] findDuplicates(int[] arr1, int[] arr2) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {

            if (binarySearch(arr1[i], arr2) != -1) {
                result.add(arr1[i]);
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static int binarySearch(int target, int[] arr) {

        int begin = 0;
        int end = arr.length;

        while (begin <= end) {

            int middle = (begin + end) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (target > arr[middle]) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }


        }

        return -1;
    }


    public int[] moveZeroesToEndOfArray(int[] arr) {


        //we have pointer from the start that counts the non zeroes


        int nextNonZero = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {

                int temp = arr[i];
                arr[i] = arr[nextNonZero];
                arr[nextNonZero] = temp;
                nextNonZero++;
            }
        }

        return arr;
    }

    static char[] reverseWordsWithStack(char[] arr) {
        //using a stack

        Stack<Character> stack = new Stack<>();

        int beginWord = 0;
        int endWord = 0;

        while(beginWord < arr.length && arr[beginWord] == ' '){
            stack.push(' ');
            beginWord++;
        }

        for(int i = beginWord; i < arr.length; i++){


            if(arr[i] == ' '){

                endWord = i - 1;

                for(int j = endWord ; j >= beginWord ; j--){
                    stack.push(arr[j]);
                }
                while (arr[i] == ' ' && i < arr.length){
                    stack.push(' ');
                    i++;
                }

                beginWord = i;

            }
        }

        if(beginWord < arr.length){
            endWord = arr.length - 1;

            for(int i = endWord ; i >= beginWord; i--){
                stack.push(arr[i]);
            }
        }

        char[] result = new char[arr.length];

        for(int i = 0; i < arr.length ;i++) {
            result[i] = stack.pop();
        }
        return result;
    }


    static char[] reverseWords(char[] arr) {

        //2 point

        char[] result = new char[arr.length];
        int resultIndex = 0;

        int endOfWord = arr.length;

        for(int i = arr.length - 1 ; i >= 0 ; i--){

            if(arr[i] == ' '){

                for(int j = i + 1 ; j < endOfWord ; j++ ){

                    result[resultIndex] = arr[j];
                    resultIndex++;
                }

                // we can have one or more spaces
                while (i >= 0 && arr[i] == ' ') {
                    result[resultIndex++] = ' ';
                    i--;
                }

                endOfWord = i + 1;

            }



        }

        if (endOfWord > 0) {
            for (int i = 0; i < endOfWord; i++) {
                result[resultIndex++] = arr[i];
            }
        }


        return result;

    }

    public static void main(String[] args) {
        char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        char[] result = reverseWords(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
