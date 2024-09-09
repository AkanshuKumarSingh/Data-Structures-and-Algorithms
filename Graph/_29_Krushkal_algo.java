package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _29_Krushkal_algo {

	static class Edge {
		int u;
		int v;
		int wt;

		Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

	}

	public static void makeSet(int parent[], int rank[], int n) {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public static int findParent(int parent[], int node) {
		if (parent[node] == node) {
			return node;
		}
		parent[node] = findParent(parent, parent[node]);
		return parent[node];
	}

	public static void unionSet(int u, int v, int parent[], int rank[]) {
		u = findParent(parent, u);
		v = findParent(parent, v);

		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[u] > rank[v]) {
			parent[v] = u;
		} else {
			parent[v] = u;
			rank[u]++;
		}

	}

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {

		int parent[] = new int[n];
		int rank[] = new int[n];
		makeSet(parent, rank, n);

		ArrayList<Edge> edgesList = new ArrayList<>();
		for (ArrayList<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			int wt = edge.get(2);
			edgesList.add(new Edge(u, v, wt));
		}
		Collections.sort(edgesList, new Comparator<Edge>() {
			@Override
			public int compare(Edge edge1, Edge edge2) {
				// Compare edges based on their weights (wt)
				return edge1.wt - edge2.wt;
			}
		});

		int minWeight = 0;
		for (int i = 0; i < edgesList.size(); i++) {
			Edge edge = edgesList.get(i);
			int u = findParent(parent, edge.u);
			int v = findParent(parent, edge.v);
			int wt = edge.wt;

			if (u != v) {
				minWeight += wt;
				unionSet(u, v, parent, rank);
			}
		}

		return minWeight;
	}

}
