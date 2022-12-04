package algorithums;

import java.util.Arrays;
import java.util.List;

public class AlgorithumChallenges {


    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        if (a.size() != 3 || b.size() != 3) {
            throw new IllegalArgumentException("the two arrays needs to have 3 elements each!");
        }

        int aRates = 0, bRates = 0;

        for (int rateIndex = 0; rateIndex < 3; rateIndex++) {
            if (a.get(rateIndex) > b.get(rateIndex)) {
                aRates++;
            } else if (a.get(rateIndex) < b.get(rateIndex)) {
                bRates++;
            }
        }
        return Arrays.asList(aRates, bRates);
    }
}
