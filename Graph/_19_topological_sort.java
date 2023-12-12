package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _19_topological_sort {

	// GFG
    static void dfs(int src, boolean vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[src] = true;
        for(int neigh: adj.get(src)){
            if(!vis[neigh]){
                dfs(neigh, vis, adj, st);
            }
        }
        st.push(src);
    }
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, vis, adj, st);
            }
        }
        
        int ans[] = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        
        return ans;
    }

	
	
	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static void topologicalSort(ArrayList<Edge>[] graph,int src, boolean vis[],Stack<Integer> st) {
		vis[src] = true;
		
		for(Edge e : graph[src]) {
			if(!vis[e.nbr]) {
				topologicalSort(graph,e.nbr,vis,st);
			}
		}
		st.add(src);
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
		}

		boolean vis[] = new boolean[vtces];
		Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i < vtces; i++) {
			if(!vis[i]) {
				topologicalSort(graph,i,vis,st);
			}
		}
		
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
	}

}
