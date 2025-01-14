package org.example.blind75.graphs.medium;

import org.example.blind75.graphs.model.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

    private final HashMap<Node, Node> visited = new HashMap<>();// we want to avoid infinite loop and hence need to keep trck of visited node
    // and we need to have an efficient loop up, hence a hashmap.

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {

        if(node == null)//base case
            return node;

        if(visited.containsKey(node))//IMP: Stops recursive calls: If we have already visited the node then return already stored value.
            return visited.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());// if node is not visited then create a cloneNode and then add to hashmap first
        visited.put(node, cloneNode);

        for(Node neighbour: node.neighbors) {// for each neighbours call this method recursively, this will create clone node
            // and will add neighbours to the clone node's neighbour list.
            cloneNode.neighbors.add(cloneGraph(neighbour));//Adding to cloneNode's neighbours while keep track of visited nodes.
        }
        return cloneNode;
    }
}
