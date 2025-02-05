package org.example.blind75.graphs.traversal.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphTraversal {

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

        List<Integer> ans = bfsOfGraph(5, adj);
        for(Integer i: ans) {
            System.out.println(i);
        }
    }

    private static List<Integer> bfsOfGraph(int v, List<List<Integer>> adj) {

        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {

            Integer item = queue.poll();
            bfs.add(item);
            for(Integer neighbour : adj.get(item)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }
}
