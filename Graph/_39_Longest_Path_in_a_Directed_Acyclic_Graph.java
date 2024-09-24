package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _39_Longest_Path_in_a_Directed_Acyclic_Graph {

    public static void dfs(int src, ArrayList<ArrayList<ArrayList<Integer>>> adj, 
    boolean vis[], int dis[]){
        vis[src] = true;
        ArrayList<ArrayList<Integer>> nodes = adj.get(src);
        for(int i = 0 ; i < nodes.size(); i++){
            ArrayList<Integer> curr = nodes.get(i);
            if(dis[curr.get(0)] < dis[src] + curr.get(1)){
                dis[curr.get(0)] = dis[src] + curr.get(1);
                dfs(curr.get(0), adj, vis, dis);
            }
        }
        vis[src] = false;
    }
    
    public static int [] maximumDistance1(int v, int e, int src, int[][] edges) {
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
        dis[src] = 0;
        dfs(src, adj, new boolean[v], dis);
        return dis;
    }
	
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
