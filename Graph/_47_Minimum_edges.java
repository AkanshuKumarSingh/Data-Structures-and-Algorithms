package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _47_Minimum_edges {

	static class Node implements Comparable<Node> {
		int src;
		int wt;

		Node(int node, int wt) {
			this.src = node;
			this.wt = wt;
		}

		public int compareTo(Node obj) {
			return this.wt - obj.wt;
		}

	}

	public static void minimumEdges(int src, int dst, ArrayList<ArrayList<int[]>> edgesList, int dis[], boolean vis[]) {
// 		if(src == dst) {
// 			return;
// 		}

// 		vis[src] = true;
// 		ArrayList<int[]> edgeList = edgesList.get(src);
// 		for(int i = 0 ; i < edgeList.size(); i++) {
// 			int edge[] = edgeList.get(i);
// 			int v = edge[0];
// 			int w = edge[1];
// 			if(!vis[v] && dis[v] > dis[src] + w) {
// 				dis[v] = dis[src] + w;
// 				minimumEdges(v, dst, edgesList, dis, vis);
// 			}

// 		}
// 		vis[src] = false;

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(src, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (vis[node.src])
				continue;
			else if (node.src == dst)
				return;

			vis[node.src] = true;
			ArrayList<int[]> edgeList = edgesList.get(node.src);
			for (int i = 0; i < edgeList.size(); i++) {
				int edge[] = edgeList.get(i);
				int v = edge[0];
				int w = edge[1];
				if (!vis[v] && dis[v] > dis[node.src] + w) {
					dis[v] = dis[node.src] + w;
					q.offer(new Node(v, dis[v]));
				}
			}
		}
	}

	public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
		ArrayList<ArrayList<int[]>> edgesList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			edgesList.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0] - 1;
			int v2 = edges[i][1] - 1;
			ArrayList<int[]> edge1 = edgesList.get(v1);
			ArrayList<int[]> edge2 = edgesList.get(v2);
			edge1.add(new int[] { v2, 0 });
			edge2.add(new int[] { v1, 1 });
		}

		int dis[] = new int[n];
		boolean vis[] = new boolean[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[src - 1] = 0;

		minimumEdges(src - 1, dst - 1, edgesList, dis, vis);
		return dis[dst - 1] != Integer.MAX_VALUE ? dis[dst - 1] : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
