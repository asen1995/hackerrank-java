package datastructures.graph;

public class Graph {


    public static void main(String[] args) {

        final Node root = GraphFactory.createGraph();

        GraphSearch search = new BFS();

        search.search(root);
    }
}
