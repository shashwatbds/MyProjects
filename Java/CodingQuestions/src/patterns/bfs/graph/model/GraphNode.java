package patterns.bfs.graph.model;

import collections.binarytree.Node;

import java.util.*;

public class GraphNode<T> {

    private T t;
    private Set<GraphNode<T>> neighbours;

    public GraphNode(T t) {
        this.t = t;
        this.neighbours = new HashSet<>();
    }

    public void connect(GraphNode<T> t) {
        if(this == t) {
            throw new IllegalArgumentException("Can't connect to itself");
        }

        this.neighbours.add(t);
        t.neighbours.add(this);
    }

    public static <T> Optional<GraphNode<T>> search(T t, GraphNode<T> root) {
        Queue<GraphNode<T>> queue = new ArrayDeque<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        queue.add(root);

        GraphNode<T> currentNode = null;
        while(!queue.isEmpty()) {
            currentNode = queue.remove();
            if(currentNode.t.equals(t)) {
                return Optional.of(currentNode);
            } else {
                visited.add(currentNode);//add current node in visited list.
                queue.addAll(currentNode.neighbours);
                queue.removeAll(visited);//can also have a check if the current node is already visited.
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        GraphNode<Integer> start = new GraphNode<>(10);
        GraphNode<Integer> firstNeighbor = new GraphNode<>(10);
        start.connect(firstNeighbor);

        GraphNode<Integer> firstNeighborNeighbor = new GraphNode<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        GraphNode<Integer> secondNeighbor = new GraphNode<>(4);
        start.connect(secondNeighbor);

        System.out.println(GraphNode.search(4, firstNeighborNeighbor).get().t);

    }
}
