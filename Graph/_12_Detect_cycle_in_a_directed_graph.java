package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _12_Detect_cycle_in_a_directed_graph {

	// GFG
	// Points to remember in this ques
	// 1. We need to do dfs for each node as there may be disconnected graphs
	// 2. If a node is visited and we are again going on that node even the we are not sure that graph is cyclic because
	// we can have case like this ( 0 <- 1 <- 2 ) in this if 0 is visited and then we are doing dfs of node 1 this
	// doesn't mean graph is cyclic
	// 3. We need to keep another array dfsVisit to check for cyclic nature whose current index will be set to true
	// at start of fxn and false at end of fxn, we need to set false as 4 -> 5 -> 6 case will give true but it's not 
	// 																	\		  /
	//																	 >------->	
	// cycle as we can't get back to 4 from 4 as it's directed is not in that way, also if dfsVisit is true means we
	// have reached that node previously and again reaching that hence we have cycle.
	
	
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i] && dfs(i, V, adj, vis, new boolean[V])){
                return true;    
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsVisit[]) {
        
        vis[i] = true;
        dfsVisit[i] = true;
        for(int j = 0; j < adj.get(i).size(); j++){
            if(!vis[adj.get(i).get(j)]){
                if(dfs(adj.get(i).get(j), V, adj, vis, dfsVisit)) return true;
            }else if(dfsVisit[adj.get(i).get(j)]){
            	// if current node is visited in current dfs execution then we have cycle
                return true;
            }
        }
        
        dfsVisit[i] = false;
        return false;
        
    }
	
	
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
	
	
	//	Not handled many cases as done in above code
	public static boolean ifCycleExists(ArrayList<Edge>[] graph, int src, boolean vis[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			
			if(vis[vertex]) {
				return true;
			}
			vis[vertex] = true;
			
			for(Edge e : graph[vertex]) {
				if(!vis[e.nbr]) {
					q.add(e.nbr);
				}
			}
			
		}
		
		return false;
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

		boolean vis[] = new boolean[vtces];
		for (int i = 0; i < vtces; i++) {
			if (!vis[i]) {
				if (ifCycleExists(graph,i, vis)) {
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(false);
	}
}
