package Graph;

import java.util.ArrayList;

public class _37_Bridge_edge_in_a_graph {

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[], int dest){
        if(node == dest) return true;
        // We need to check if node is visited after above check because in some case src and dest may be same
        // in those case if we add this check in below loop i.e. if (!vis[neigh]) then we can find the ans as
        // src is visited already and that check will restrict us to go in node == des condition.
        else if(vis[node]) return false;
        
        vis[node] = true;
        for(int neigh: adj.get(node)){
            if(dfs(adj, neigh, vis, dest)) return true;
        }
        
        return false;
    }
    
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {   
        boolean vis[] = new boolean[V];
        vis[c] = true;
        for(int neigh: adj.get(c)){
            if(neigh != d && !vis[neigh]){
                if(dfs(adj, neigh, vis, d)) return 0;
            }
        }
        return 1;
    }
	
}
