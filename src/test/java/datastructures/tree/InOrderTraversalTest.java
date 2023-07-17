package datastructures.tree;

import org.junit.Test;

public class InOrderTraversalTest {

    @Test
    public void testInOrderTraversal() {

        final Node root = BinaryTreeFactory.createMockBinaryTree();

        Traversal traversal = new InOrderTraversal();
        traversal.traverse(root);

    }
}
