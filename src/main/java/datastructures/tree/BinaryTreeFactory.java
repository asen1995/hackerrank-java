package datastructures.tree;

public class BinaryTreeFactory {

    public static Node createMockBinaryTree() {


        Node leaf = new Node(3, null, null);
        Node leaf2 = new Node(7, null, null);


        Node leaf3 = new Node(30, null, null);

        Node subtree1 = new Node(5, leaf, leaf2);

        Node subtree2 = new Node(20, null, leaf3);


        Node root = new Node(10, subtree1, subtree2);

        return root;

    }
}
