package datastructures.graph;

public class Graph {


    public static void main(String[] args) {

        final Node root = GraphFactory.createGraph();

        GraphSearch search = new DFS();

        search.search(root);
    }
}
