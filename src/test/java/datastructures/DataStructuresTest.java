package datastructures;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class DataStructuresTest {

    @Test
    public void arrayListTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());

    }

}
