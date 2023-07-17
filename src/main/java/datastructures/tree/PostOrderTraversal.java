package datastructures.tree;

public class PostOrderTraversal implements Traversal {
    @Override
    public void traverse(Node root) {
        if (root != null) {
            traverse(root.left);
            traverse(root.right);
            System.out.println(root.getData());
        }
    }
}
