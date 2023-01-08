package datastructures;

import datastructures.tree.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DataStructureChallengesTest {

    private final DataStructureChallenges dataStructureChallenges = new DataStructureChallenges();

    @Test
    public void reverseArray() {
        assertEquals(Arrays.asList(2, 3, 4, 1), dataStructureChallenges.reverseArray(Arrays.asList(1, 4, 3, 2)));
    }

    @Test
    public void hourglassSum() {
        assertEquals(19, dataStructureChallenges.hourglassSum(Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0))));
    }


    @Test
    public void rotateLeft() {
        assertEquals(Arrays.asList(5, 1, 2, 3, 4), dataStructureChallenges.rotateLeft(4, Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void matchingStrings() {
        assertEquals(Arrays.asList(2, 1, 0), dataStructureChallenges.matchingStrings(Arrays.asList("aba", "baba", "aba", "xzxb"), Arrays.asList("aba", "xzxb", "ab")));
    }

    @Test
    public void arrayManipulation() {
        assertEquals(200, dataStructureChallenges.arrayManipulation(5, Arrays.asList(
                Arrays.asList(1, 2, 100),
                Arrays.asList(2, 5, 100),
                Arrays.asList(3, 4, 100))));
    }

    @Test
    public void preOrderTraversal() {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
        dataStructureChallenges.preOrder(root);
    }

    @Test
    public void postOrderTraversal() {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
        dataStructureChallenges.postOrder(root);
    }

    @Test
    public void inOrderTraversal() {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
        dataStructureChallenges.inOrder(root);
    }

    @Test
    public void heightOfBinaryTree() {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
        assertEquals(4, dataStructureChallenges.height(root));
    }

    @Test
    public void topView() {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
        dataStructureChallenges.topView(root);
    }

    @Test
    public void levelOrderTraversal() {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
        dataStructureChallenges.levelOrder(root);
    }

    @Test
    public void insertNodeAtTail() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(302);
        head.next = tail;
        SinglyLinkedListNode node = dataStructureChallenges.insertNodeAtTail(head, 164);
        assertEquals(141, node.data);
        assertEquals(302, node.next.data);
        assertEquals(164, node.next.next.data);
    }

    @Test
    public void insertNodeAtHead() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(302);
        head.next = tail;
        SinglyLinkedListNode node = dataStructureChallenges.insertNodeAtHead(head, 164);
        assertEquals(164, node.data);
        assertEquals(141, node.next.data);
        assertEquals(302, node.next.next.data);
    }

    @Test
    public void insertNodeAtPosition() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(302);
        head.next = tail;
        SinglyLinkedListNode node = dataStructureChallenges.insertNodeAtPosition(head, 164, 1);
        assertEquals(141, node.data);
        assertEquals(164, node.next.data);
        assertEquals(302, node.next.next.data);
    }

    @Test
    public void deleteNode() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(302);
        head.next = tail;
        SinglyLinkedListNode node = dataStructureChallenges.deleteNode(head, 1);
        assertEquals(141, node.data);
        assertNull(node.next);
    }

    @Test
    public void reversePrint() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(302);
        head.next = tail;

        //bigger list
        SinglyLinkedListNode node = new SinglyLinkedListNode(164);
        tail.next = node;
        tail = node;
        node = new SinglyLinkedListNode(530);
        tail.next = node;
        tail = node;
        node = new SinglyLinkedListNode(474);
        tail.next = node;
        tail = node;

        //track milliseconds of execution time
        long startTime = System.currentTimeMillis();
        dataStructureChallenges.reversePrint(head);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Execution time: " + duration + " milliseconds");
    }

    @Test
    public void reverse() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(302);
        head.next = tail;

        //bigger list
        SinglyLinkedListNode node = new SinglyLinkedListNode(164);
        tail.next = node;
        tail = node;
        node = new SinglyLinkedListNode(530);
        tail.next = node;
        tail = node;
        node = new SinglyLinkedListNode(474);
        tail.next = node;
        tail = node;

        //track milliseconds of execution time
        long startTime = System.currentTimeMillis();
        SinglyLinkedListNode reversed = dataStructureChallenges.reverse(head);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Execution time: " + duration + " milliseconds");
        assertEquals(474, reversed.data);
        assertEquals(530, reversed.next.data);
        assertEquals(164, reversed.next.next.data);
        assertEquals(302, reversed.next.next.next.data);
        assertEquals(141, reversed.next.next.next.next.data);
    }

    @Test
    public void compareTwoLinkedLists() {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail1 = new SinglyLinkedListNode(302);
        head1.next = tail1;

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(141);
        SinglyLinkedListNode tail2 = new SinglyLinkedListNode(302);
        head2.next = tail2;

        assertTrue(dataStructureChallenges.compareLists(head1, head2));
    }

    @Test
    public void mergeTwoSortedLinkedLists() {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode tail1 = new SinglyLinkedListNode(2);
        head1.next = tail1;
        SinglyLinkedListNode node = new SinglyLinkedListNode(3);
        tail1.next = node;
        tail1 = node;
        node = new SinglyLinkedListNode(4);
        tail1.next = node;
        tail1 = node;
        node = new SinglyLinkedListNode(5);
        tail1.next = node;
        tail1 = node;

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(6);
        SinglyLinkedListNode tail2 = new SinglyLinkedListNode(7);
        head2.next = tail2;
        node = new SinglyLinkedListNode(8);
        tail2.next = node;
        tail2 = node;
        node = new SinglyLinkedListNode(9);
        tail2.next = node;
        tail2 = node;
        node = new SinglyLinkedListNode(10);
        tail2.next = node;
        tail2 = node;

        SinglyLinkedListNode merged = dataStructureChallenges.mergeLists(head1, head2);
        assertEquals(1, merged.data);
        assertEquals(2, merged.next.data);
        assertEquals(3, merged.next.next.data);
        assertEquals(4, merged.next.next.next.data);
        assertEquals(5, merged.next.next.next.next.data);
        assertEquals(6, merged.next.next.next.next.next.data);
        assertEquals(7, merged.next.next.next.next.next.next.data);
        assertEquals(8, merged.next.next.next.next.next.next.next.data);
        assertEquals(9, merged.next.next.next.next.next.next.next.next.data);
        assertEquals(10, merged.next.next.next.next.next.next.next.next.next.data);
    }

}
