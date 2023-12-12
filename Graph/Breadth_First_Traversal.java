package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Graph._1_BFS.BFSPair;

public class Breadth_First_Traversal {
	
	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static void bfs(ArrayList<Edge> graph[],int src) {
		Queue<BFSPair> qu = new LinkedList<>();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());

		// write your code here
	}
}
