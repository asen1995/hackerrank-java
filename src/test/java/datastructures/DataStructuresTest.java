package datastructures;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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

    @Test
    public void arrayDeque() {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 100; i++) {
            deque.addFirst(i);
        }

        final Integer integer = deque.pollLast();
        assertEquals(0, integer.intValue());
    }

    @Test
    public void arrayListWithTwoThreads() {
        List<Integer> list = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotEquals(20000, list.size()); // not thread safe so the two threads override each other
    }

    @Test
    public void vectorTest() throws InterruptedException {
        Vector<Integer> threadSaveVector = new Vector<>();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                System.out.println("Thread 1 " + i);
                threadSaveVector.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {

                System.out.println("Thread 2 " + i);
                threadSaveVector.add(i);
            }
        });

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        assertEquals(1000, threadSaveVector.size());
    }

    @Test
    public void stackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
        assertEquals(3, stack.peek().intValue());
        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }

    @Test
    public void priorityQueueTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        assertEquals(1, priorityQueue.peek().intValue());
        assertEquals(1, priorityQueue.poll().intValue());
        assertEquals(2, priorityQueue.poll().intValue());
        assertEquals(3, priorityQueue.poll().intValue());
    }


    @Test
    public void treeSetTest() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);

        assertEquals(1, treeSet.first().intValue());
        assertEquals(3, treeSet.last().intValue());
    }

    @Test
    public void hashSetTest() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(55);
        hashSet.add(355);

        assertEquals(5, hashSet.size());
        assertTrue(hashSet.contains(55));
    }

    @Test
    public void linkedHashSetTest() {
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(55);
        linkedHashSet.add(355);

        assertEquals(5, linkedHashSet.size());
        assertTrue(linkedHashSet.contains(55));
    }


    @Test
    public void treeMapTest() {
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        treeMap.put(4, "four");
        treeMap.put(5, "five");

        assertEquals(5, treeMap.size());
        assertEquals("one", treeMap.get(1));
        assertEquals("two", treeMap.get(2));
        assertEquals("three", treeMap.get(3));
        assertEquals("four", treeMap.get(4));
        assertEquals("five", treeMap.get(5));
    }
}
