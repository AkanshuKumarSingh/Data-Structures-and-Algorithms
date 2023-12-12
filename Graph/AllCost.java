package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import Graph.Print_All_Paths.Edge;

public class AllCost {
	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void allCost(ArrayList<Edge>[] graph, int src, int dest, boolean vis[], String str, int cost) {
		if (src == dest) {
			System.out.println(str + src + "@" + cost);
			return;
		}

		vis[src] = true;
		for (int i = 0; i < graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			if (!vis[e.nbr]) {
				allCost(graph, e.nbr, dest, vis, str + src,cost + e.wt);
			}
		}
		vis[src] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = 7;
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

//		int edges = Integer.parseInt(br.readLine());
		int src[] = { 0, 0, 1, 2, 3, 4, 4, 5 };
		int nbr[] = { 1, 3, 2, 3, 4, 5, 6, 6 };
		int wet[] = { 10, 40, 10, 10, 2, 3, 8, 3 };
		for (int i = 0; i < src.length; i++) {
			int v1 = src[i];
			int v2 = nbr[i];
			int wt = wet[i];
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int srce = 0;
		int dest = 6;

		// write all your codes here
		boolean vis[] = new boolean[vtces];
		Arrays.fill(vis, false);
		allCost(graph, srce, dest, vis, "",0);

	}

}
