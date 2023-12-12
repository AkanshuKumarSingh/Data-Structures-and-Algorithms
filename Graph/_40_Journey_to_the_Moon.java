package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;


public class _40_Journey_to_the_Moon {

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> currList: astronaut){
            adj.get(currList.get(0)).add(currList.get(1));
            adj.get(currList.get(1)).add(currList.get(0));
        }
        
        boolean vis[] = new boolean[n];
        ArrayList<Long> sizeArr = new ArrayList<>();
        long totalSize = 0;
        for(int i = 0 ; i < n; i++){
            if(!vis[i]){
                long currSize = bfs(i, vis, adj);
                totalSize += currSize;
                sizeArr.add(currSize);
            }
        }
        
        long ans = 0;
        for(int i = 0 ; i < sizeArr.size(); i++){
            totalSize -= sizeArr.get(i);
            ans += (sizeArr.get(i) * totalSize);
        }
        return ans;
    }

    public static long bfs(int node, boolean vis[], List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        long size = 0;
        
        while(!q.isEmpty()){
            node = q.remove();
            if(vis[node]){
                continue;
            }    
            
            size++;
            vis[node] = true;
            for(int neigh: adj.get(node)){
                q.add(neigh);
            }
        }
        
        return size;
    }

	
}
