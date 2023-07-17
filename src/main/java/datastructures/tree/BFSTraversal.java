package datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal implements Traversal {
    @Override
    public void traverse(Node root) {

        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            final Node node = queue.poll();
            System.out.println(node.getData());

            addToQueueIfExists(node.left, queue);
            addToQueueIfExists(node.right, queue);

        }

    }

    private void addToQueueIfExists(Node node, Queue<Node> queue) {
        if (node != null) {
            queue.add(node);
        }
    }
}
