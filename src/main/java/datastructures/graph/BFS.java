package datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS implements GraphSearch {
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
