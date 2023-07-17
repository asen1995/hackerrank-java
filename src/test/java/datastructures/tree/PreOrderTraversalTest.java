package datastructures.tree;

import org.junit.Test;

public class PreOrderTraversalTest {

    @Test
    public void testTraverse() {

        final Node root = BinaryTreeFactory.createMockBinaryTree();

        Traversal traversal = new PreOrderTraversal();
        traversal.traverse(root);
    }
}
