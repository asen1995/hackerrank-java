package datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * This is a specific implementation of the GraphSearch interface for BFS
 * </p>
 * author: Asen Nikolaev
 */
public class BFS implements GraphSearch {

    /**
     * <p>
     * This method implements the BFS algorithm
     * </p>
     * @param root - the root node of the graph
     */
    @Override
    public void search(Node root) {

        Queue<Node> queue = new LinkedList<>();

        root.visit();

        queue.add(root);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();

            System.out.println(node);

            for (Node adjacent : node.getAdjacentNodes()) {
                if (!adjacent.isVisited()) {
                    adjacent.visit();
                    queue.add(adjacent);
                }
            }
        }
    }
}
