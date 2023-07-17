package datastructures.tree;

import org.junit.Test;

public class PostOrderTraversalTest {

    @Test
    public void testPostOrderTraversal() {

        final Node root = BinaryTreeFactory.createMockBinaryTree();

        Traversal traversal = new PostOrderTraversal();
        traversal.traverse(root);
    }
}
