package patterns.bfs.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-the-level-of-given-node-in-an-undirected-graph/
 * */
public class FindLevelOfNodeInUnidirectedGraph {

    public static void main(String[] args) {

        int V=5;
        int[][] edges = {{0,1},{0,2},{1,3},{2,4}};

        int level = findLevel(V, edges, 3);
        System.out.println("Level :"+level);
    }

    private static int findLevel(int V, int[][] edges, int X) {

        /**Preparation begins*/
        int maxVertex = 0;
        // 1. Find number of vertices.
        for (int[] it : edges) {
            maxVertex = Math.max(maxVertex, Math.max(it[0], it[1]));
        }

        // 2. Creating adjacency list
        ArrayList<Integer>[] adj = new ArrayList[maxVertex + 1];//why +1?
        for (int i = 0; i <= maxVertex; i++) {
            adj[i] = new ArrayList<>();
        }

        // 3. Adding elements to the adjacency list
        for(int i=0; i< edges.length; i++) {
            //We have list of edges, hence we can add each node of the edges in each others adjacency list.
            //Each element's adjacency list will be at same index in adjacency array as the integer.
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        // If X is greater than max Vertex that means the passed element does not exist in the graph
        if(X > maxVertex || adj[X].size() ==0) {
            return -1;
        }
        /**Preparation ends*/

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 0;
        boolean[] visited = new boolean[maxVertex+1];
        //bfs traversal

        while(!queue.isEmpty()) {
            int size= queue.size();
            while(size -->0) {
                int currentNode = queue.poll();
                if(currentNode == X) {
                    return level;
                }

                for(int i : adj[currentNode]) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
