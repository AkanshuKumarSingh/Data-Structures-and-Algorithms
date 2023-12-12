package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _14_Is_Graph_Bipartite {
	
//  Leetcode
//	Intuition
//	Using graph color with 2 colors blue and red. where for blue we will take 1 and for red we will take -1 and 0 
//	for uncolored graph.
//
//	Approach
//	Approach is simple we first going to traverse the graph with help of BFS and color node with 1 and -1. 
//	And if we ancounter a node with colored node which is not oposite to our color we will return false 
//	as we need to change the color and it is no longer Bipartite graph.

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colour[] = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(colour[i] != 0) continue;
            q.add(i);
            colour[i] = 1;
            while(!q.isEmpty()){
                int node = q.remove();
                for(int neigh: graph[node]){
                    if(colour[neigh] == 0){
                        colour[neigh] -= colour[node];
                        q.add(neigh);
                    }else if(colour[neigh] == colour[node]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
	
	
	// if it is possible to divide the vertices of graph in two mutually exclusive sets(non common)
	// and exhaustive sets(both contains all the vertices) such that all edges are across sets.
	
	// every acyclic graph is bipartite
	// or if there is cycle it should be of even length is bipartite
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

	static class Node{
		int v;
		String psf;
		int level;
		Node(int v, String psf, int level){
			this.v = v;
			this.psf = psf;
			this.level = level;
		}
	}
	
	public static boolean isComponentBipartite(ArrayList<Edge>[] graph, int src, int vis[]) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(src,"" + src, 0));
		
		while(!q.isEmpty()) {
			Node rem = q.poll();
			
			if(vis[rem.v] != -1) {
				if(rem.level != vis[rem.v]) {
					return false;
				}
			}else {
				vis[rem.v] = rem.level;
			}
			
			for(Edge e : graph[rem.v]) {
				if(vis[e.nbr] == -1) {
					q.add(new Node(e.nbr,rem.psf + e.nbr,rem.level+1));
				}
			}
		}
		return true;
	}
	
	public static void isGraphBipartite(ArrayList<Edge>[] graph) {
		int vertices = graph.length;
		int vis[] = new int[vertices];
		Arrays.fill(vis, -1);
		for(int src = 0 ; src < vertices; src++) {
			if(vis[src] == -1) {
				boolean isComponentBipartite = isComponentBipartite(graph,src,vis);
				if(!isComponentBipartite) {
					System.out.println(false);
					return;
				}
			}
		}
		System.out.println(true);
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
		
		isGraphBipartite(graph);
		
	}
}
