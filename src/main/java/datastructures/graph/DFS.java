package datastructures.graph;

public class DFS implements GraphSearch {
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
