package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _11_Hamiltonian_Path_And_Cycle {
	
	// GFG
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(ArrayList<Integer> arr: Edges){
            int src = arr.get(0) - 1;
            int des = arr.get(1) - 1 ;
            graph.get(src).add(des);
            graph.get(des).add(src);

        }
        
        for(int src = 0; src < N; src++){
            if(dfs(src, N, 1, graph, new boolean[N])){
                return true;
            }
        }
        return false;
    }
    
    boolean dfs(int src, int N, int cnt, ArrayList<ArrayList<Integer>> graph, boolean vis[]){
        if(cnt == N) return true;
        vis[src] = true;
        
        for(int i: graph.get(src)){
            if(!vis[i]){
                if(dfs(i, N, cnt+1, graph, vis)) return true;
            }
        }
        vis[src] = false;

        return false;
    }
	
	// Pepcoding
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

	public static void hamiltanion(ArrayList<Edge>[] graph, int src, int osrc, boolean vis[], String psf) {

		// try to use arraylist for psf becaz it will give wrong ans for nodes > 10 becaz 10 11 will have length 2
		if (psf.length() == graph.length - 1) {
			psf += src;
			System.out.print(psf);

			boolean isCyclic = false;
			for (Edge e : graph[osrc]) {
				if (src == e.nbr) {
					isCyclic = true;
					break;
				}
			}

			if (isCyclic) {
				System.out.println("*");
			} else {
				System.out.println(".");
			}

			return;
		}

		vis[src] = true;
		for (Edge edge : graph[src]) {
			if (!vis[edge.nbr]) {
				hamiltanion(graph, edge.nbr, osrc, vis, psf + src);
			}
		}
		vis[src] = false;
	}

	public static void getPathsAndCycles(int src, ArrayList<Edge>[] graph) {
		int n = graph.length;
		boolean vis[] = new boolean[n];
		hamiltanion(graph, src, src, vis, "");
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
		getPathsAndCycles(src, graph);
	}

}
