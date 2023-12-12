package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _5_Find_if_Path_Exists_in_Graph {
	
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            ArrayList<Integer> first = arr.get(edges[i][0]);
            ArrayList<Integer> second = arr.get(edges[i][1]);
            first.add(edges[i][1]);
            second.add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        boolean vis[] = new boolean[n];
        vis[source] = true;

        while(!q.isEmpty()){
            int v = q.remove();
            if(v == destination) return true;

            for(int i = 0; i < arr.get(v).size(); i++){
                int nextNode = arr.get(v).get(i);
                if(!vis[nextNode]){
                    vis[nextNode] = true;
                    q.add(nextNode);
                }
            }

        }

        return false;
    }
	
}
