package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _17_Shortest_Path_In_Weights {

	// Dijkstra's Algorithm
	// Shortest path in terms of weight
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

	static class Node implements Comparable<Node> {
		int src;
		String psf;
		int wsf;

		Node(int src, String psf, int wsf) {
			this.src = src;
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(Node node) {
			return this.wsf - node.wsf;
		}

	}

	public static void dijkstras(ArrayList<Edge> graph[], int src) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(src,""+src,0));
		boolean vis[] = new boolean[graph.length];
		
		while(!pq.isEmpty()) {
			Node rem = pq.poll();
			if(vis[rem.src] == true) {
				continue;
			}
			
			vis[rem.src] = true;
			System.out.println(rem.src + " via " + rem.psf + " @ " + rem.wsf);
			for(Edge e : graph[rem.src]) {
				if(!vis[e.nbr]) {
					pq.offer(new Node(e.nbr,rem.psf + e.nbr , rem.wsf + e.wt));
				}
			}
		}
		
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
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());
		dijkstras(graph,src);

	}
}
