package datastructures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BFSTraversalTest {

    @Test
    public void bfsTraversalTest() {

        final Node root = BinaryTreeFactory.createMockBinaryTree();

        Traversal traversal = new BFSTraversal();
        traversal.traverse(root);
    }
}
