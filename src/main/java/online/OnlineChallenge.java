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


    static char[] reverseWordsMirror(char[] arr) {

        mirror(0,arr.length - 1 , arr);

        int wordBegin = 0;
        int endBegin = 0;

        while (wordBegin < arr.length &&  arr[wordBegin] == ' '){
            wordBegin++;
        }

        for(int i = wordBegin; i < arr.length ; i++){

            if(arr[i] == ' ' ){
                endBegin = i - 1;

                mirror(wordBegin, endBegin,arr);

                wordBegin = i;

                while(i < arr.length && arr[i] == ' ' ){
                    i++;
                    wordBegin++;
                }
            }

        }

        if(wordBegin < arr.length){
            mirror(wordBegin, arr.length - 1,arr);
        }

        return arr;
    }

    private static void mirror(int begin, int end, char[] arr) {

        while(begin < end){

            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;

            begin++;
            end--;
        }
    }

}
