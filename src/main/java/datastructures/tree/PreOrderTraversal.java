package datastructures.tree;

public class PreOrderTraversal implements Traversal {
    @Override
    public void traverse(Node root) {

        if (root != null) {
            System.out.println(root.getData());
            traverse(root.left);
            traverse(root.right);
        }

    }
}
