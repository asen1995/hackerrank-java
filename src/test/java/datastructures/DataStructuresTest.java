package datastructures;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void arrayDeque(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < 100; i++){
            deque.addFirst(i);
        }

        final Integer integer = deque.pollLast();
        assertEquals(0, integer.intValue());
    }

    @Test
    public void arrayListWithTwoThreads(){
        List<Integer> list = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                list.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
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
           for(int i = 0; i < 500; i++){
               System.out.println("Thread 1 " + i);
               threadSaveVector.add(i);
           }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 500; i++){

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
    public void stackTest(){
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
}
