package datastructures.graph;

/**
 * <p>
 * This is a specific implementation of the GraphSearch interface for DFS
 * </p>
 * author: Asen Nikolaev
 */
public class DFS implements GraphSearch {

    /**
     * <p>
     * This method implements the DFS algorithm
     * </p>
     * @param root - the root node of the graph
     */
    @Override
    public void search(Node root) {

        if (root == null) return;

        System.out.println(root);
        root.visit();

        for (Node adjacent : root.getAdjacentNodes()) {
            if (!adjacent.isVisited())
                search(adjacent);
        }

    }
}
