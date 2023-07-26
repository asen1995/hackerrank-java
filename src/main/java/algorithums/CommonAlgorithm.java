package algorithums;

import java.util.Collections;
import java.util.List;

public class CommonAlgorithm {

    public int binarySearch(int search, List<Integer> list) {

        Collections.sort(list);

        int left = 0, right = list.size() - 1;

        while (left <= right) {

            int middleIndex = (right + left) / 2;
            if (list.get(middleIndex) == search) {
                return middleIndex;

            } else if (list.get(middleIndex) > search) {
                right = middleIndex - 1;
            } else {
                left = middleIndex + 1;
            }


        }

        return -1;
    }

    public boolean isPalindrome(String word){

        int left = 0, right = word.length() - 1 ;

        while (left <= right){
            if(word.charAt(left) != word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {
        CommonAlgorithm commonAlgorithm = new CommonAlgorithm();
        System.out.println(commonAlgorithm.isPalindrome("madam"));
    }
}
