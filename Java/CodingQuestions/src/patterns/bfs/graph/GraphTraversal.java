package patterns.bfs.graph;

import patterns.bfs.graph.model.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
 * Auxiliary Space: O(V)
 * */
public class GraphTraversal {

    public static void breadthFirstSearch(Graph graph, int s) { // BFS from a given source

        // Mark all the vertices as not visited(By default set as false)
        boolean[] visited = new boolean[graph.getV()];
        // Create a queue for BFS - this will be used to store the adjacent nodes to the current node.
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            s = queue.poll(); //dequeue the vertex
            System.out.println(s);

            //Get all adjacent vertex of s
            //If adjacent vertexes have not been visited
            //mark them as visited and enqueue them
            Iterator<Integer> iterator = graph.getAdj()[s].listIterator();
            while(iterator.hasNext()) {
                int n = iterator.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");
        breadthFirstSearch(g, 2);
    }
}
