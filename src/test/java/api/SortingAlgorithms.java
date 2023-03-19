package api;

public class SortingAlgorithms {

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return arr;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        return left;
    }


    public static int[] quickSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return arr;
        }
        int pivot = arr[n - 1];
        int[] left = new int[n];
        int[] right = new int[n];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < pivot) {
                left[leftIndex] = arr[i];
                leftIndex++;
            } else {
                right[rightIndex] = arr[i];
                rightIndex++;
            }
        }
        int[] leftSorted = quickSort(left);
        int[] rightSorted = quickSort(right);
        int[] result = new int[n];
        for (int i = 0; i < leftIndex; i++) {
            result[i] = leftSorted[i];
        }
        result[leftIndex] = pivot;
        for (int i = 0; i < rightIndex; i++) {
            result[leftIndex + 1 + i] = rightSorted[i];
        }
        return result;
    }



}
