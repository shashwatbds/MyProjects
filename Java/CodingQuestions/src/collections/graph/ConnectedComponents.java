package collections.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

	public class Graph {
		
		int v; //size or number of vertex in the graph
		List<List<Integer>> adjListArray;
		
		public Graph(int v) {
			
			this.v = v;
			
			adjListArray = new ArrayList<>();
			
			//Create a new list for each vertex so that its adjacent nodes can be stored.
			for(int i=0; i< v; i++) {
				adjListArray.add(i, new ArrayList<Integer>());
			}
		}
		
		public void addEdge(int src, int dest) {
			adjListArray.get(src).add(dest);
			adjListArray.get(dest).add(src);//Graph is unidirected hence both nodes will be connected to each other.
		}
		
		public void dfsUtil(int v, boolean[] visited) {
			visited[v] = true;
			System.out.println(v);
			
			//Recur for all vertices adjacent to this vertex
			for(int i : adjListArray.get(v)) {
				if(!visited[i]) {
					dfsUtil(i, visited);
				}
			}
		}
		
		
		public void connectedComponents() {
			boolean[] visited = new boolean[v];
			for(int i=0; i<v; ++i) {
				dfsUtil(i, visited);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {

		ConnectedComponents c = new ConnectedComponents();
		Graph g = c.new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 4);
		
		System.out.println("Following are the connected components");
		g.connectedComponents();
		
	}

}
