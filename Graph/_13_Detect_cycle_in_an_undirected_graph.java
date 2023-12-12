package Graph;

import java.util.ArrayList;

public class _13_Detect_cycle_in_an_undirected_graph {
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i] && dfs(i, V, adj, vis, -1)){
                return true;    
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], int prev) {
        
        vis[i] = true;
        for(int j = 0; j < adj.get(i).size(); j++){
            if(!vis[adj.get(i).get(j)]){
                if(dfs(adj.get(i).get(j), V, adj, vis, i)) return true;
            }else if(prev != adj.get(i).get(j)){
                return true;
            }
        }
        
        return false;
        
    }
}
