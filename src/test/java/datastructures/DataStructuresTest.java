package datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataStructuresTest {

    @Test
    public void arrayListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());

    }

    @Test
    public void linkedListTest() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1, 22);
        assertEquals(22, list.get(1).intValue());
        ((LinkedList<Integer>) list).addFirst(33);

        assertEquals(33, list.get(0).intValue());
    }

    @Test
    public void dequeueTest() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        deque.addFirst(22);
        assertEquals(22, deque.getFirst().intValue());
        deque.addLast(33);
        assertEquals(33, deque.getLast().intValue());

    }


}
