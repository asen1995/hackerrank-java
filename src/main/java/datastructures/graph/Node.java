package datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Integer representation;
    private List<Node> adjacentNodes;

    private boolean visited;

    public Node(Integer representation) {
        this.representation = representation;
        this.adjacentNodes = new ArrayList<>();
        this.visited = false;
    }

    public Integer getRepresentation() {
        return representation;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public String toString() {
        return "Node " + representation;
    }
}
