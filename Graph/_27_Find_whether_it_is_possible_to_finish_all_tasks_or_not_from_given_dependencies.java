package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class _27_Find_whether_it_is_possible_to_finish_all_tasks_or_not_from_given_dependencies {

	public boolean isPossible(int n, int P, int[][] edges) {
		int inDegree[] = new int[n];
		int dis[] = new int[n];
		Queue<Integer> q = new LinkedList<>();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < P; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			adj.get(v2).add(v1);
			inDegree[v1]++;
		}

		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				dis[i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int node = q.remove();
			for (int neigh : adj.get(node)) {
				inDegree[neigh]--;
				if (inDegree[neigh] == 0) {
					q.add(neigh);
					dis[neigh] = dis[node] + 1;
				}
			}
		}

		for (int i : inDegree)
			if (i != 0)
				return false;
		return true;
	}

	// class to store dependencies as a pair
	static class pair {
		int first, second;

		pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	// Returns adjacency list representation from a list
	// of pairs.
	static ArrayList<ArrayList<Integer>> make_graph(int numTasks, Vector<pair> prerequisites) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);

		for (int i = 0; i < numTasks; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (pair pre : prerequisites)
			graph.get(pre.second).add(pre.first);

		return graph;
	}

	// A DFS based function to check if there is a cycle
	// in the directed graph.
	static boolean dfs_cycle(ArrayList<ArrayList<Integer>> graph, int node, boolean onpath[], boolean visited[]) {
		if (visited[node])
			return false;
		onpath[node] = visited[node] = true;

		for (int neigh : graph.get(node))
			if (onpath[neigh] || dfs_cycle(graph, neigh, onpath, visited))
				return true;

		return onpath[node] = false;
	}

	// Main function to check whether possible to finish all tasks or not
	static boolean canFinish(int numTasks, Vector<pair> prerequisites) {
		ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);

		boolean onpath[] = new boolean[numTasks];
		boolean visited[] = new boolean[numTasks];

		for (int i = 0; i < numTasks; i++)
			if (!visited[i] && dfs_cycle(graph, i, onpath, visited))
				return false;

		return true;
	}

	public static void main(String args[]) {
		int numTasks = 4;

		Vector<pair> prerequisites = new Vector<pair>();
		;

		// for prerequisites: [[1, 0], [2, 1], [3, 2]]

		prerequisites.add(new pair(1, 0));
		prerequisites.add(new pair(2, 1));
		prerequisites.add(new pair(3, 2));

		if (canFinish(numTasks, prerequisites)) {
			System.out.println("Possible to finish all tasks");
		} else {
			System.out.println("Impossible to finish all tasks");
		}
	}

}
