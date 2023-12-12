package Graph;

import java.util.ArrayList;

public class _24_Number_of_Operations_to_Make_Network_Connected {

    public static void dfs(int n, boolean vis[], ArrayList<ArrayList<Integer>> neighs){
        vis[n] = true;
        
        for(int neigh: neighs.get(n)){
            if(!vis[neigh]){
                dfs(neigh, vis, neighs);
            }
        }
    }
    
    public static int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> neighs = new ArrayList<>();
        int comps = 0, edges = 0;
        for(int  i = 0 ; i < n ; i++){
            neighs.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < connections.length; i++){
            int v1 = connections[i][0];
            int v2 = connections[i][1];
            neighs.get(v1).add(v2);
            neighs.get(v2).add(v1);
            edges += 1;
        }
        if(edges < n-1){
            return -1;
        }
        
        boolean  vis[] = new boolean[n];
        for(int i = 0 ; i < n; i++){
            if(!vis[i]){
                dfs(i, vis, neighs);
                comps += 1;
            }
        }        
        return comps-1;
    }

	
	public static void main(String[] args) {
		

	}

}
