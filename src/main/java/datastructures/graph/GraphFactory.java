package datastructures.graph;

public class GraphFactory {
    static Node createGraph() {

        Node rootNode = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node1.getAdjacentNodes().add(node3);
        node1.getAdjacentNodes().add(node4);

        node2.getAdjacentNodes().add(node1);

        node3.getAdjacentNodes().add(node2);
        node3.getAdjacentNodes().add(node4);

        rootNode.getAdjacentNodes().add(node1);
        rootNode.getAdjacentNodes().add(node4);
        rootNode.getAdjacentNodes().add(node5);

        return rootNode;

    }
}
