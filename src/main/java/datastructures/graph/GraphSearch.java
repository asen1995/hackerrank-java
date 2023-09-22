package datastructures.graph;

/**
 * <p>
 * This is graph search interface that all specific implementations should implement
 * and provide their own implementation of the search method
 * </p>
 * author: Asen Nikolaev
 */
public interface GraphSearch {

    /**
     * <p>
     * This method should be implemented by all specific implementations of the GraphSearch interface
     * </p>
     * @param root - the root node of the graph
     */
    void search(Node root);
}
