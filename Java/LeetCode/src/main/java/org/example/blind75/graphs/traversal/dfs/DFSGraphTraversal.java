package org.example.blind75.graphs.traversal.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://siddosamith.medium.com/graph-traversals-in-java-dfs-bfs-a91910f6b9f9
 * */
public class DFSGraphTraversal {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<5; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        List<Integer> ans = dfsOfGraph(5, adj);
        for(Integer i: ans) {
            System.out.println(i);
        }
    }

    /**
     * DFS in graph: Traverse Neighbours first
     * */
    public static List<Integer> dfsOfGraph(int v, List<List<Integer>> adj) {

        boolean[] visited = new boolean[v+1];//To keep track of all nodes which have been visited, we do not traverse visited nodes again.
        visited[0] = true;//Mark first node as visited.
        List<Integer> ls = new ArrayList<>();//To print order in which nodes are traversed
        dfs(0, visited, adj, ls);
        return ls;
    }

    /**
     * Node is the level here.
     * */
    private static void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> ls) {

        visited[node] = true;
        ls.add(node);

        for(Integer neighbour: adj.get(node)) {
            if(!visited[neighbour]) {
                dfs(neighbour, visited, adj, ls);
            }
        }
    }
}
