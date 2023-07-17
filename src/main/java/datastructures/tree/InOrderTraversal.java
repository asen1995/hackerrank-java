package datastructures.tree;

public class InOrderTraversal implements Traversal {
    @Override
    public void traverse(Node root) {

        if(root != null){
            traverse(root.left);
            System.out.println(root.getData());
            traverse(root.right);
        }
    }
}
