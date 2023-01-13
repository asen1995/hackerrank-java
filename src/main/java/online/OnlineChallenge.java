package online;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};
        int[] result = findDuplicates(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
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
}
