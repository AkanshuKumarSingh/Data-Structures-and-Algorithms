package Graph;

import java.util.Arrays;

public class _32_Negative_weight_cycle {
	
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int distance[] = new int[n];
        Arrays.fill(distance, 100000000);
        distance[0] = 0;

        for(int i = 1; i < n; i++){
            for(int edge[] : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(distance[v] > distance[u] + wt){
                    distance[v] = distance[u] + wt;
                }    
            }
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(distance[v] > distance[u] + wt){
                return 1;
            }    
        }
        return 0;
    }

}
