package Graph;

import java.util.ArrayList;

public class _45_Path_of_greater_than_equal_to_k_length {

	public static boolean dfs(int src, int k, ArrayList<ArrayList<ArrayList<Integer>>> edges, boolean vis[], int wt) {
		if (wt >= k) {
			return true;
		}

		vis[src] = true;
		ArrayList<ArrayList<Integer>> neighs = edges.get(src);
		for (int i = 0; i < neighs.size(); i++) {
			ArrayList<Integer> neigh = neighs.get(i);
			int neighNode = neigh.get(0);
			int currWt = neigh.get(1);
			if (!vis[neighNode] && dfs(neighNode, k, edges, vis, currWt + wt)) {
				return true;
			}
		}
		vis[src] = false;

		return false;
	}

	static boolean pathMoreThanK(int V, int E, int K, int[] A) {

		ArrayList<ArrayList<ArrayList<Integer>>> edges = new ArrayList<>();
		ArrayList<Integer> edge = new ArrayList<>();
		boolean vis[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < 3 * E; i += 3) {
			int v1 = A[i];
			int v2 = A[i + 1];
			int wt = A[i + 2];
			ArrayList<ArrayList<Integer>> edge1 = edges.get(v1);
			ArrayList<ArrayList<Integer>> edge2 = edges.get(v2);

			edge = new ArrayList<>();
			edge.add(v2);
			edge.add(wt);
			edge1.add(edge);

			edge = new ArrayList<>();
			edge.add(v1);
			edge.add(wt);
			edge2.add(edge);
		}

		return dfs(0, K, edges, vis, 0);
	}

	public static void main(String[] args) {
		System.out.println(pathMoreThanK(4, 3, 8, new int[] { 0, 1, 5, 1, 2, 1, 2, 3, 1 }));
	}

}
