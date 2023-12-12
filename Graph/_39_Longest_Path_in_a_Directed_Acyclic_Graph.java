package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _39_Longest_Path_in_a_Directed_Acyclic_Graph {

    public static int [] maximumDistance(int v, int e, int src, int[][] edges) {
    	ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0 ; i < v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]: edges){
            int u = edge[0];
            int f = edge[1];
            int wt = edge[2];
            ArrayList<ArrayList<Integer>> nodeEdges = adj.get(u);
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(f);
            arr.add(wt);
            nodeEdges.add(arr);
        }
        
        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MIN_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src] = 0;
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int  i = 0 ; i < adj.get(node).size(); i++){
                ArrayList<Integer> curr = adj.get(node).get(i);
                int neigh = curr.get(0);
                int wt = curr.get(1);
                if(dis[neigh] < dis[node] + wt){
                    dis[neigh] = dis[node] + wt;
                    q.add(neigh);
                }
            }
            
        }
        
        return dis;

    }

	
}
