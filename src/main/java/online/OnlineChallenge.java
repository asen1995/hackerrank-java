package online;

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


}
