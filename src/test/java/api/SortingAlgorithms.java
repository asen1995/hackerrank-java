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



    public static int[] quickSort(int[] array) {
        int numberOfElements = array.length;
        if (numberOfElements < 2) {
            return array;
        }
        int pivot = array[numberOfElements - 1];
        int[] left = new int[numberOfElements];
        int[] right = new int[numberOfElements];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < numberOfElements - 1; i++) {
            if (array[i] < pivot) {
                left[leftIndex] = array[i];
                leftIndex++;
            } else {
                right[rightIndex] = array[i];
                rightIndex++;
            }
        }
        int[] leftSorted = quickSort(left);
        int[] rightSorted = quickSort(right);
        int[] result = new int[numberOfElements];
        for (int i = 0; i < leftIndex; i++) {
            result[i] = leftSorted[i];
        }
        result[leftIndex] = pivot;
        for (int i = 0; i < rightIndex; i++) {
            result[leftIndex + 1 + i] = rightSorted[i];
        }
        return result;
    }

    public static int[] mergeSort(int[] array) {
        int numberOfElements = array.length;
        if (numberOfElements < 2) {
            return array;
        }
        int middle = numberOfElements / 2;
        int[] left = new int[middle];
        int[] right = new int[numberOfElements - middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < numberOfElements; i++) {
            right[i - middle] = array[i];
        }
        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);
        return merge(leftSorted, rightSorted);
    }

    private static int[] merge(int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength + rightLength];
        int resultIndex = 0;
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }
        while (leftIndex < leftLength) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex < rightLength) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        return result;
    }
}
