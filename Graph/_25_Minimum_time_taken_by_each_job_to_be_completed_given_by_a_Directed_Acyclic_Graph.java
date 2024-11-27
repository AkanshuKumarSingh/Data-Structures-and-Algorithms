package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _25_Minimum_time_taken_by_each_job_to_be_completed_given_by_a_Directed_Acyclic_Graph {
	
    public static int [] minimumTime(int n,int m, int[][] edges) {
        int inDegree[] = new int[n];
        int dis[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < m ; i++){
            int v1 = edges[i][0]-1;
            int v2 = edges[i][1]-1;
            adj.get(v1).add(v2);
            inDegree[v2]++;
        }
        
        for(int i = 0 ; i < n; i++){
            if(inDegree[i] == 0){
                q.add(i);
                dis[i] = 1;
            }
        }
        
//        I also tried doing below code after this step but same nodes are being traversed for multiple starting points
//        leading to time limit exceeded.
//        public static void dfs(int src, int dis[], ArrayList<ArrayList<Integer>> adj){
//            for(int neigh = 0; neigh < adj.get(src).size() ; neigh++){
//                dis[neigh] = Math.max(dis[neigh], dis[src]+1);
//                dfs(neigh,dis, adj);
//            }
//            
//        }
        
        while(!q.isEmpty()){
            int node = q.remove();
            for(int neigh: adj.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    q.add(neigh);
                    dis[neigh] = dis[node]+1;
                }
            }
        }
        
        return dis;
    }

	
}
