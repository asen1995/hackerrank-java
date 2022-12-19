package datastructures;

import java.util.ArrayList;
import java.util.List;

public class DataStructureChallenges {

    public List<Integer> reverseArray(List<Integer> a) {

        List<Integer> reversed = new ArrayList<>();

        for (int i = a.size() - 1; i >= 0; i--) {

            reversed.add(a.get(i));
        }

        return reversed;


    }

}
