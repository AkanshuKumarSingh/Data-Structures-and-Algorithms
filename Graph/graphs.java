package Graph;

import java.util.ArrayList;

public class graphs {

	public static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
		graph[src].add(new Edge(src, nbr, wt));
		graph[nbr].add(new Edge(nbr, src, wt));
	}

	public static ArrayList<Edge>[] creation() {
		int n = 7;
		// to provide memory of arraylist at every index of array
		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

//		int src[] = { 0, 0, 1, 2, 3, 4, 4, 5 };
//		int nbr[] = { 1, 3, 2, 3, 4, 5, 6, 6 };
//		int wt[] = { 10, 40, 10, 10, 2, 3, 8, 3 };
//		for(int i = 0 ; i < src.length; i++) {
//			int s = src[i];
//			int nb = nbr[i];
//			int w = wt[i];
//			
//			addEdge(graph,s,nb,w);
//		}
//		

		addEdge(graph, 0, 1, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);

		return graph;
	}

	public static void display(ArrayList<Edge>[] graph) {
		for(int i = 0 ; i < graph.length; i++) {
//			System.out.println("[ " + i +);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Edge>[] graph = creation();
		display(graph);
	}

}
