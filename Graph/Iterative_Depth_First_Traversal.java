package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Iterative_Depth_First_Traversal {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static class Node {
		int src;
		String psf;

		Node(int src, String psf) {
			this.src = src;
			this.psf = psf;
		}
	}

	public static void printPath(ArrayList<Edge>[] graph, int src) {
		Stack<Node> st = new Stack<>();
		st.push(new Node(src,""+src));
		boolean vis[] = new boolean[graph.length];

		while (!st.isEmpty()) {
			Node rem = st.pop();
			if (vis[rem.src]) {
				continue;
			}
			
			vis[rem.src] = true;
			System.out.println(rem.src + "@" + rem.psf);
			
			for(Edge e : graph[rem.src]) {
				if(!vis[e.nbr]) {
					st.push(new Node(e.nbr,rem.psf+e.nbr));
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());
		printPath(graph, src);

	}
}
