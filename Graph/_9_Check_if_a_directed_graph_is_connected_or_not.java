package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _9_Check_if_a_directed_graph_is_connected_or_not {
	
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

	public static void visitGraph(ArrayList<Edge>[] graph,int src, boolean vis[]) {
		vis[src] = true;
		for(Edge n : graph[src]) {
			if(!vis[n.nbr]) {
				visitGraph(graph,n.nbr,vis);
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

		// write your code here
		int cnt = 0;
		boolean vis[] = new boolean[vtces];
		for(int i = 0 ; i < vtces; i++) {
			if(!vis[i]) {
				if(cnt > 0) {
					cnt = -1;
					break;
				}
				visitGraph(graph,i,vis);
				cnt++;
			}
		}
		if(cnt == -1) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
	}

}
