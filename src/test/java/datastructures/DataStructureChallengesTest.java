package datastructures;

import datastructures.tree.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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
}
