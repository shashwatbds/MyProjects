package patterns.bfs.graph.model;

import java.util.LinkedList;

public class Graph {

    private int V; //number of vertices
    private LinkedList<Integer> adj[]; // adjacency list of current node - Queue - FIFO

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>(); // initialize an array so that we can store adjacent nodes for each node in a linked list.
        }
    }

    public void addEdge(int v, int w) {//adding w at an index v
        adj[v].add(w);
    }

    public int getV() {
        return V;
    }
    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
