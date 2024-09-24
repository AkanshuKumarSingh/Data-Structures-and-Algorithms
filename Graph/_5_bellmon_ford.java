package Graph;

import java.util.Arrays;
import java.util.List;

public class _5_bellmon_ford {

	public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
		// distance[u] != 100000000 because suppose we have 2 disconnected components in which one is 3 -> 7 with wt: -7
		// then dis of 3 and 7 should be INT_MAX, but our will give wt to 7 as INT_MAX-7 as wt is -7
		int distance[] = new int[n];
		Arrays.fill(distance, 100000000);
		distance[src] = 0;

		for (int i = 1; i < n; i++) {
			for (List<Integer> edge : edges) {
				int u = edge.get(0);
				int v = edge.get(1);
				int wt = edge.get(2);
				if (distance[u] != 100000000 && distance[v] > distance[u] + wt) {
					distance[v] = distance[u] + wt;
				}
			}
		}

		for (List<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			int wt = edge.get(2);
			if (distance[u] != 100000000 && distance[v] > distance[u] + wt) {
				distance[v] = distance[u] + wt;
				return new int[] { -1 };
			}
		}

		return distance;
	}

}
