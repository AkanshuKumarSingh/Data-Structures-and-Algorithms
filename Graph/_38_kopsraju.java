package Graph;

import java.util.*;

public class _38_kopsraju {

	public void dfs(int src, boolean vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		vis[src] = true;
		for (int nxtSrc : adj.get(src)) {
			if (!vis[nxtSrc]) {
				dfs(nxtSrc, vis, adj, st);
			}
		}
		st.push(src);
	}

	// Function to find number of strongly connected components in the graph.
	public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st = new Stack<>();
		boolean vis[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfs(i, vis, adj, st);
			}
		}

		ArrayList<ArrayList<Integer>> tadj = new ArrayList<>();

		for (int i = 0; i < adj.size(); i++) {
			tadj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				tadj.get(adj.get(i).get(j)).add(i);
			}
		}

		vis = new boolean[V];
		int scc = 0;
		while (!st.isEmpty()) {
			int i = st.pop();
			if (!vis[i]) {
				scc++;
				dfs(i, vis, tadj, st);
			}
		}

		return scc;
	}

}
