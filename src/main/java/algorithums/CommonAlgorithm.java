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
}
