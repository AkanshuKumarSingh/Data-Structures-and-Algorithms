package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Minimum_Wire_Required_To_Connect_All_Pcs {
	// Prims Algorithm
	// Helps to find Minimum spanning tree

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

	static class PHelper implements Comparable<PHelper> {
		int src;
		int parent;
		int wt;

		PHelper(int src, int parent, int wt) {
			this.src = src;
			this.parent = parent;
			this.wt = wt;
		}

		public int compareTo(PHelper oth) {
			return this.wt - oth.wt;
		}

	}

	public static void prims(ArrayList<Edge> graph[]) {
		PriorityQueue<PHelper> pq = new PriorityQueue<>();
		pq.add(new PHelper(0, -1, 0));
		boolean vis[] = new boolean[graph.length];
		
		while (!pq.isEmpty()) {
			PHelper rem = pq.poll();
			if(vis[rem.src]) {
				continue;
			}
			
			vis[rem.src] = true;
			if(rem.parent != -1) {
				System.out.println("[" + rem.src + "-" + rem.parent + "@" + rem.wt + "]");
			}
			
			for(Edge e : graph[rem.src]) {
				if(!vis[e.nbr]) {
					pq.offer(new PHelper(e.nbr,rem.src,e.wt));
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
		
		
	}

}
