package Graph;

import java.util.ArrayList;

class Solution
{
    public int possible_paths(int[][] edges, int n, int s, int d){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int firstNode = edges[i][0];
            int secNode = edges[i][1];
            graph.get(firstNode).add(secNode);
        }
        
        boolean vis[] = new boolean[n];
        return count(s, d, vis, graph);
    }
    
    public int count(int src, int des, boolean vis[], ArrayList<ArrayList<Integer>> graph){
        if(src == des) return 1;
        vis[src] = true;
        
        int cnt = 0;
        for(int i = 0; i < graph.get(src).size(); i++){
            int node = graph.get(src).get(i);
            if(!vis[node]){
                cnt += count(node, des, vis, graph);
            }
        }
        
        vis[src] = false;
        return cnt;
    }
    
}
