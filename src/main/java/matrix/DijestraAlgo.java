package matrix;

import java.util.Arrays;

public class DijestraAlgo {
	//TIME COMPLEXITY: O(V^2). 
	//Using Min-Heap + Adjacency_List we can get TIME COMPLEXITY: O(ElogV)
	private static void dijkstra(int[][] graph) {
		int V = graph.length;
		int parent[] = new int[V]; // Stores Shortest Path Structure
		int value[] = new int[V];
		Arrays.fill(value, Integer.MAX_VALUE);// Keeps shortest path values to each vertex from source infinity
		boolean processed[] = new boolean[V];// TRUE->Vertex is processed
		// Assuming start point as Node-0
		parent[0] = -1; // Start node has no parent
		value[0] = 0; // start node has value=0 to get picked 1st

		// Include (V-1) edges to cover all V-vertices
		for (int i = 0; i < V - 1; ++i) {
			// Select best Vertex by applying greedy method
			int U = selectMinVertex(value, processed, V);
			processed[U] = true; // Include new Vertex in shortest Path Graph

			// Relax adjacent vertices (not yet included in shortest path graph)
			for (int j = 0; j < V; ++j) {
				/*
				 * 3 conditions to relax:- 
				 * 1.Edge is present from U to j.
				 * 2.Vertex j is not included in shortest path graph 
				 * 3.Edge weight is smaller than current edge weight
				 */
				if (graph[U][j] != 0 && processed[j] == false && value[U] != Integer.MAX_VALUE
						&& (value[U] + graph[U][j] < value[j])) {
					value[j] = value[U] + graph[U][j];
					parent[j] = U;
				}
			}
		}
		// Print Shortest Path Graph
		for (int i = 1; i < V; ++i)
			System.out.println("U->V: " + parent[i] + "->" + i + "  wt = " + graph[parent[i]][i]);

	}

	private static int selectMinVertex(int[] value, boolean[] processed, int V) {

		int minimum = Integer.MAX_VALUE;
		int vertex = 0;
		for (int i = 0; i < V; ++i) {
			if (processed[i] == false && value[i] < minimum) {
				vertex = i;
				minimum = value[i];
			}
		}
		return vertex;
	}


	public static void main(String[] args) {
		
		int graph[][] = { {0, 1, 4, 0, 0, 0},
				          {1, 0, 4, 2, 7, 0},
				          {4, 4, 0, 3, 5, 0},
				          {0, 2, 3, 0, 4, 6},
				          {0, 7, 5, 4, 0, 7},
				          {0, 0, 0, 6, 7, 0} };

            dijkstra(graph);	
	}

	
}
